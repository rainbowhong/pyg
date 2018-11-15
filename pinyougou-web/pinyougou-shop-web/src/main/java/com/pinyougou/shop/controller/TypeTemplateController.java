package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TypeTemplate;
import com.pinyougou.service.TypeTemplateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Author: rainbow
 * Description:
 * Date:Create in 8:46 2018/11/8
 * Modified By:
 */
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {

    @Reference(timeout = 10000)
    private TypeTemplateService typeTemplateService;

    @GetMapping("findOne")
    public TypeTemplate findOne(Long id) {
        return typeTemplateService.findOne(id);
    }


    @GetMapping("/showSpecification")
    public List<Map> showSpecification(Long id) {
        return typeTemplateService.showSpecification(id);
    }
}
