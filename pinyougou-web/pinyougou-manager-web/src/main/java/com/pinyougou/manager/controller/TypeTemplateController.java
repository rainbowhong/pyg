package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.comm.pojo.PageResult;
import com.pinyougou.pojo.TypeTemplate;
import com.pinyougou.service.TypeTemplateService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * Author: rainbow
 * Description:
 * Date:Create in 16:57 2018/11/3
 * Modified By:
 */
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {

    @Reference(timeout = 10000)
    private TypeTemplateService typeTemplateService;


    @GetMapping("/findByPage")
    public PageResult findByPage(TypeTemplate typeTemplate,int rows,int page) {
        if (typeTemplate != null && StringUtils.isNoneBlank(typeTemplate.getName())) {

            try {
                typeTemplate.setName(new String(typeTemplate.getName().getBytes("ISO8859-1"), "UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return typeTemplateService.findByPage(typeTemplate,page,rows);
    }
}
