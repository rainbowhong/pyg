package com.pinyougou.service;

import com.pinyougou.pojo.Brand;

import java.util.List;

/**
 * Author: rainbow
 * Description:
 * Date:Create in 22:08 2018/10/29
 * Modified By:
 */
public interface BrandService {
    /**
     * 查询所有品牌
     */
    List<Brand> findAll();
}
