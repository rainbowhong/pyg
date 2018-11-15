package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.ItemCat;
import com.pinyougou.service.ItemCatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: rainbow
 * Description:
 * Date:Create in 19:50 2018/11/7
 * Modified By:
 */
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {


    @Reference(timeout = 10000)
    private ItemCatService itemCatService;

    @GetMapping("/findItemCatByParentId")
    public List<ItemCat> findItemCatByParentId(@RequestParam(defaultValue = "0", value = "parentId") long parentId) {
        return itemCatService.findItemCatByParentId(parentId);

    }
}
