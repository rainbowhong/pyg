package com.pinyougou.content.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.comm.pojo.PageResult;
import com.pinyougou.pojo.Content;
import com.pinyougou.mapper.ContentMapper;
import com.pinyougou.service.ContentService;

import java.util.List;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.Arrays;

/**
 * ContentServiceImpl 服务接口实现类
 *
 * @version 1.0
 * @date 2018-11-14 00:54:16
 */
@Service(interfaceName = "com.pinyougou.service.ContentService")
@Transactional
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper contentMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 添加方法
     */
    public void save(Content content) {
        try {
            contentMapper.insertSelective(content);
            /** 清除Redis缓存 */
            redisTemplate.delete("content");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 修改方法
     */
    public void update(Content content) {
        try {
            contentMapper.updateByPrimaryKeySelective(content);
            /** 清除Redis缓存 */
            redisTemplate.delete("content");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 根据主键id删除
     */
    public void delete(Serializable id) {
        try {
            contentMapper.deleteByPrimaryKey(id);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 批量删除
     */
    public void deleteAll(Serializable[] ids) {
        try {
            // 创建示范对象
            Example example = new Example(Content.class);
            // 创建条件对象
            Example.Criteria criteria = example.createCriteria();
            // 创建In条件
            criteria.andIn("id", Arrays.asList(ids));
            // 根据示范对象删除
            contentMapper.deleteByExample(example);
            /** 清除Redis缓存 */
            redisTemplate.delete("content");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 根据主键id查询
     */
    public Content findOne(Serializable id) {
        try {
            return contentMapper.selectByPrimaryKey(id);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 查询全部
     */
    public List<Content> findAll() {
        try {
            return contentMapper.selectAll();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 多条件分页查询
     */
    public PageResult findByPage(Content content, int page, int rows) {
        try {
            PageInfo<Content> pageInfo = PageHelper.startPage(page, rows)
                    .doSelectPageInfo(new ISelect() {
                        @Override
                        public void doSelect() {
                            contentMapper.selectAll();
                        }
                    });
            return new PageResult(pageInfo.getTotal(), pageInfo.getList());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    /**
     * 根据广告类型ID查询数据
     */
    @Override
    public List<Content> findContentByCategoryId(long categoryId) {

        /** 定义广告数据 */
        List<Content> contentList = null;

        try {
            contentList = (List<Content>) redisTemplate.boundValueOps("content").get();
            if (contentList != null && contentList.size() > 0) {
                return contentList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            // 创建示范对象
            Example example = new Example(Content.class);
            // 创建查询条件对象
            Example.Criteria criteria = example.createCriteria();
            // 添加等于条件 category_id = categoryId
            criteria.andEqualTo("categoryId", categoryId);
            // 添加等于条件 status = 1
            criteria.andEqualTo("status", "1");
            // 排序(升序) order by sort_order asc
            example.orderBy("sortOrder").asc();
            /** 查询广告数据 */
            contentList = contentMapper.selectByExample(example);
            try {
                redisTemplate.boundValueOps("content").set(contentList);
            } catch (Exception ex) {
            }
            return contentList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}