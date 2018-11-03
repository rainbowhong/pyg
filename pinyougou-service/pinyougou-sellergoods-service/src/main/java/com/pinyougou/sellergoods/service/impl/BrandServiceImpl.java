package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.comm.pojo.PageResult;
import com.pinyougou.mapper.BrandMapper;
import com.pinyougou.pojo.Brand;
import com.pinyougou.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Author: rainbow
 * Description:
 * Date:Create in 22:10 2018/10/29
 * Modified By:
 */
@Service(interfaceName = "com.pinyougou.service.BrandService")
@Transactional
public class BrandServiceImpl implements BrandService {

    /*注入数据访问接口代理对象*/
    @Autowired
    private BrandMapper brandMapper;


    @Override
    public void save(Brand Brand) {
        brandMapper.insertSelective(Brand);
    }

    @Override
    public void update(Brand Brand) {
        brandMapper.updateByPrimaryKeySelective(Brand);
    }

    @Override
    public void delete(Serializable id) {

    }

    @Override
    public void deleteAll(Serializable[] ids) {
        //创建示范对象
        Example example = new Example(Brand.class);
        //创建条件对象
        Example.Criteria criteria = example.createCriteria();
        //添加in条件
        criteria.andIn("id",Arrays.asList(ids));
        brandMapper.deleteByExample(example);
    }

    @Override
    public Brand findOne(Serializable id) {
        return null;
    }

    @Override
    public List<Brand> findAll() {
    /*    //开始分页
        PageInfo<Brand> pageInfo = PageHelper.startPage(1, 10)
                .doSelectPageInfo(new ISelect() {
                    @Override
                    public void doSelect() {
                        brandMapper.selectAll();
                    }
                });
        System.out.println("总记录数：" + pageInfo.getTotal());
        System.out.println("总页数：" + pageInfo.getPages());
        return pageInfo.getList();*/
        return brandMapper.selectAll();
    }

    @Override
    public PageResult findByPage(Brand Brand, int page, int rows) {
        try {
            //开始分页
            PageInfo<Brand> pageInfo = PageHelper.startPage(page, rows)
                    .doSelectPageInfo(new ISelect() {
                        @Override
                        public void doSelect() {
                            brandMapper.findAll(Brand);
                        }
                    });
            return new PageResult(pageInfo.getTotal(), pageInfo.getList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
