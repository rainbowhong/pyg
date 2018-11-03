package com.pinyougou.mapper;

import com.pinyougou.pojo.Brand;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Author: rainbow
 * Description:
 * Date:Create in 22:03 2018/10/29
 * Modified By:
 */
public interface BrandMapper extends Mapper<Brand> {

    /**
     * 查询所有品牌
     *
     * @return
     */
    List<Brand> findAll(Brand brand);


    //查询所有的品牌(id与name)
    @Select("select id,name as text from tb_brand order by id ASC")
    List<Map<String, Object>> findAllByIdAndName();
}
