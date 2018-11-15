package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.comm.pojo.PageResult;
import com.pinyougou.pojo.Goods;
import com.pinyougou.service.GoodsService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

/**
 * Author: rainbow
 * Description:
 * Date:Create in 19:02 2018/11/6
 * Modified By:
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Reference(timeout = 10000)
    private GoodsService goodsService;

    @PostMapping("/save")
    public boolean save(@RequestBody Goods goods) {
        try {
            String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
            goods.setSellerId(sellerId);
            goodsService.save(goods);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @GetMapping("/findByPage")
    public PageResult findByPage(Goods goods, Integer page, Integer rows) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        goods.setSellerId(name);
        try {
            if (!StringUtils.isEmpty(goods.getGoodsName())) {
                goods.setGoodsName(new String(goods.getGoodsName().getBytes("ISO8859-1"), "UTF-8"));
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return goodsService.findByPage(goods, page, rows);
    }


    //商品上下架
    @GetMapping("/updateMarketable")
    public boolean updateMarketable(String status,Long[] ids) {
        try {
            goodsService.updateMarketable(status,ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
