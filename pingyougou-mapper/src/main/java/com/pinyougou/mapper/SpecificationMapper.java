package com.pinyougou.mapper;

import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import com.pinyougou.pojo.Specification;

import java.util.List;
import java.util.Map;

/**
 * SpecificationMapper 数据访问接口
 *
 * @version 1.0
 * @date 2018-10-31 22:24:33
 */
public interface SpecificationMapper extends Mapper<Specification> {


    List<Specification> findAll(Specification specification);

    @Select("SELECT id,spec_name text from tb_specification order by id ASC ")
    List<Map<String, Object>> findAllByIdAndName();
}