package com.pinyougou.mapper;

import com.pinyougou.pojo.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Author: rainbow
 * Description:
 * Date:Create in 22:03 2018/10/29
 * Modified By:
 */
public interface BrandMapper {

    /**
     * 查询所有品牌
     * @return
     */
    @Select("select * from tb_brand order by id asc")
    List<Brand> findAll();
}
