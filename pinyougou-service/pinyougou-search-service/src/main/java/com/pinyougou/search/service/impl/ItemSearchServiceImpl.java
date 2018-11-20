package com.pinyougou.search.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.service.ItemSearchService;
import com.pinyougou.solr.SolrItem;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.*;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceName = "com.pinyougou.service.ItemSearchService")
@Transactional
public class ItemSearchServiceImpl implements ItemSearchService {

    @Autowired
    private SolrTemplate solrTemplate;

    @Override
    public Map<String, Object> search(Map<String, Object> params) {
        Map<String, Object> data = new HashMap<>();
        String keywords = (String) params.get("keywords");

        /** 获取当前页码 */
        Integer page = (Integer) params.get("page");
        if (page == null) {
            /*默认第一页*/
            page = 1;
        }

        /*获取每页显示的记录数*/
        Integer rows = (Integer) params.get("rows");
        if (rows == null) {
            /** 默认20条记录 */
            rows = 20;
        }


        if (StringUtils.isNoneBlank(keywords)) {
            HighlightQuery highlightQuery = new SimpleHighlightQuery();
            HighlightOptions highlightOptions = new HighlightOptions();
            highlightOptions.addField("title");
            highlightOptions.setSimplePrefix("<font color='red'>");
            highlightOptions.setSimplePostfix("</font>");
            highlightQuery.setHighlightOptions(highlightOptions);
            Criteria criteria = new Criteria("keywords").is(keywords);
            highlightQuery.addCriteria(criteria);

            /** 按商品分类过滤 */
            if (!"".equals(params.get("category"))) {
                Criteria criteria1 = new Criteria("category")
                        .is(params.get("category"));
                highlightQuery.addFilterQuery(new SimpleFilterQuery(criteria1));
            }

            if (!"".equals(params.get("brand"))) {
                Criteria criteria1 = new Criteria("brand")
                        .is(params.get("brand"));
                highlightQuery.addFilterQuery((new SimpleFilterQuery(criteria1)));
            }

            /** 按规格过滤 */
            if (params.get("spec") != null) {
                Map<String, String> specMap = (Map) params.get("spec");
                for (String key : specMap.keySet()) {
                    Criteria criteria1 = new Criteria("spec_" + key).is(specMap.get(key));
                    highlightQuery.addFilterQuery(new SimpleFilterQuery(criteria1));
                }
            }

            /** 按价格过滤 */
            if (!"".equals(params.get("price"))) {
                /** 得到价格范围数组 */
                String[] price = params.get("price").toString().split("-");
                /** 如果价格区间起点不等于0 */
                if (!price[0].equals("0")) {
                    Criteria criteria1 = new Criteria("price").greaterThanEqual(price[0]);
                    highlightQuery.addFilterQuery(new SimpleFilterQuery(criteria1));
                }
                /** 如果价格区间终点不等于星号 */
                if (!price[1].equals("*")) {
                    Criteria criteria1 = new Criteria("price").lessThanEqual(price[1]);
                    highlightQuery.addFilterQuery(new SimpleFilterQuery(criteria1));
                }
            }


            /** 添加排序 */
            String sortValue = (String) params.get("sort"); // ASC  DESC
            String sortField = (String) params.get("sortField");         // 排序域
            if (StringUtils.isNoneBlank(sortValue) && StringUtils.isNoneBlank(sortField)) {
                Sort sort = new Sort("ASC".equalsIgnoreCase(sortValue) ? Sort.Direction.ASC : Sort.Direction.DESC, sortField);
                /** 增加排序 */
                highlightQuery.addSort(sort);
            }


            /** 设置起始记录查询数 */
            highlightQuery.setOffset((page - 1) * rows);
            /** 设置每页显示记录数 */
            highlightQuery.setRows(rows);


            HighlightPage<SolrItem> highlightPage = solrTemplate
                    .queryForHighlightPage(highlightQuery, SolrItem.class);
            for (HighlightEntry<SolrItem> he : highlightPage.getHighlighted()) {
                SolrItem solrItem = he.getEntity();
                if (he.getHighlights().size() > 0 && he.getHighlights().
                        get(0).getSnipplets().size() > 0) {
                    solrItem.setTitle(he.getHighlights().get(0).getSnipplets().get(0));
                }
            }
            data.put("rows", highlightPage.getContent());
            /** 设置总页数 */
            data.put("totalPages", highlightPage.getTotalPages());
            /** 设置总记录数 */
            data.put("total", highlightPage.getTotalElements());

        } else {
            SimpleQuery simpleQuery = new SimpleQuery("*:*");
            /** 设置起始记录查询数 */
            simpleQuery.setOffset((page - 1) * rows);
            /** 设置每页显示记录数 */
            simpleQuery.setRows(rows);
            ScoredPage scoredPage = solrTemplate.queryForPage(simpleQuery, SolrItem.class);
            data.put("rows", scoredPage.getContent());
            /** 设置总页数 */
            data.put("totalPages", scoredPage.getTotalPages());
            /** 设置总页数 */
            data.put("total", scoredPage.getTotalElements());
        }
        return data;
    }


    // 把SKU商品数据同步到索引库
    @Override
    public void saveOrUpdate(List<SolrItem> solrItems) {
        UpdateResponse updateResponse = solrTemplate.saveBeans(solrItems);
        if (updateResponse.getStatus() == 0) {
            solrTemplate.commit();
        } else {
            solrTemplate.rollback();
        }
    }


    /**
     * 删除商品索引
     */
    @Override
    public void delete(List<Long> goodsIds) {
        Query query = new SimpleQuery();
        Criteria criteria = new Criteria("goodsId").in(goodsIds);
        query.addCriteria(criteria);
        UpdateResponse updateResponse = solrTemplate.delete(query);
        if (updateResponse.getStatus() == 0) {
            solrTemplate.commit();
        } else {
            solrTemplate.rollback();
        }
    }
}
