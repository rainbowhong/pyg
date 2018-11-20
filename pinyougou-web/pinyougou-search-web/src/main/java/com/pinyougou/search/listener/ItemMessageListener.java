package com.pinyougou.search.listener;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.pinyougou.pojo.Item;
import com.pinyougou.service.GoodsService;
import com.pinyougou.service.ItemSearchService;
import com.pinyougou.solr.SolrItem;
import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/** 商品消息监听器 */
public class ItemMessageListener implements SessionAwareMessageListener<ObjectMessage> {

    @Reference(timeout = 30000)
    private GoodsService goodsService;
    @Reference(timeout = 30000)
    private ItemSearchService itemSearchService;


    @Override
    public void onMessage(ObjectMessage objectMessage, Session session) throws JMSException {
        System.out.println("===ItemMessageListener===");
        Long[] ids = (Long[]) objectMessage.getObject();
        System.out.println("ids:" + Arrays.toString(ids));
        // 查询上架的SKU商品数据
        List<Item> itemList = goodsService.findItemByGoodsId(ids);
        if(itemList.size() > 0) {
            List<SolrItem> solrItems = new ArrayList<>();
            for(Item item : itemList) {
                SolrItem solrItem = new SolrItem();
                solrItem.setTitle(item.getTitle());
                solrItem.setSpecMap(JSON.parseObject(item.getSpec(),Map.class));
                solrItem.setUpdateTime(item.getUpdateTime());
                solrItem.setSeller(item.getSeller());
                solrItem.setPrice(item.getPrice());
                solrItem.setImage(item.getImage());
                solrItem.setGoodsId(item.getGoodsId());
                solrItem.setBrand(item.getBrand());
                solrItem.setId(item.getId());
                solrItems.add(solrItem);
            }
            itemSearchService.saveOrUpdate(solrItems);
        }
    }
}
