package com.pinyougou.service;

import com.pinyougou.pojo.Brand;
import com.pinyougou.pojo.Brand;

import java.io.Serializable;
import java.util.List;

/**
 * Author: rainbow
 * Description:
 * Date:Create in 22:08 2018/10/29
 * Modified By:
 */
public interface BrandService {
    /** 添加方法 */
    void save(Brand Brand);

    /** 修改方法 */
    void update(Brand Brand);

    /** 根据主键id删除 */
    void delete(Serializable id);

    /** 批量删除 */
    void deleteAll(Serializable[] ids);

    /** 根据主键id查询 */
    Brand findOne(Serializable id);

    /** 查询全部 */
    List<Brand> findAll();

    /** 多条件分页查询 */
    List<Brand> findByPage(Brand Brand, int page, int rows);
}
