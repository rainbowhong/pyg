package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.comm.pojo.PageResult;
import com.pinyougou.pojo.TypeTemplate;
import com.pinyougou.service.TypeTemplateService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

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
    public PageResult findByPage(TypeTemplate typeTemplate, int rows, int page) {
        if (typeTemplate != null && StringUtils.isNoneBlank(typeTemplate.getName())) {

            try {
                typeTemplate.setName(new String(typeTemplate.getName().getBytes("ISO8859-1"), "UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return typeTemplateService.findByPage(typeTemplate, page, rows);
    }

    //添加模板
    @PostMapping("/save")
    public boolean save(@RequestBody TypeTemplate typeTemplate) {
        try {
            typeTemplateService.save(typeTemplate);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //更新模板

    @PostMapping("/update")
    public boolean update(@RequestBody TypeTemplate typeTemplate) {
        try {
            typeTemplateService.update(typeTemplate);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //删除
    @PostMapping("/delete")
    public boolean delete(Long[] ids) {
        try {
            typeTemplateService.deleteAll(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
