package com.pinyougou.mapper;

import tk.mybatis.mapper.common.Mapper;

import com.pinyougou.pojo.Specification;

import java.util.List;

/**
 * SpecificationMapper 数据访问接口
 * @date 2018-10-31 22:24:33
 * @version 1.0
 */
public interface SpecificationMapper extends Mapper<Specification>{


    List<Specification> findAll(Specification specification);
}