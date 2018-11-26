package com.pinyougou.cart.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.ctc.wstx.util.StringUtil;
import com.pinyougou.cart.Cart;
import com.pinyougou.comm.util.CookieUtils;
import com.pinyougou.service.CartService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Reference(timeout = 10000)
    private CartService cartService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;


    /**
     * 添加SKU 商品到购物车
     */
    @GetMapping("/addCart")
    @CrossOrigin(origins="http://item.pinyougou.com",allowCredentials="true")
    public boolean addCart(Long itemId, Integer num) {
        try {
            //获取登录用户名
            String username = request.getRemoteUser();
            // 获取购物车集合
            List<Cart> carts = findCart();
            // 调用服务层添加SKU 商品到购物车
            carts = cartService.addItemToCart(carts, itemId, num);


            //判断用户是否登录
            if (StringUtils.isNoneBlank(username)) {
                cartService.saveCartRedis(username, carts);
            } else {

                // 将购物车重新存入Cookie 中
                CookieUtils.setCookie(request, response,
                        CookieUtils.CookieName.PINYOUGOU_CART,
                        JSON.toJSONString(carts),
                        3600 * 24, true);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 获取购物车集合
     */
    @GetMapping("/findCart")
    private List<Cart> findCart() {

        // 获取登录用户名
        String username = request.getRemoteUser();
        //定义购物车集合
        List<Cart> carts = null;
        if (StringUtils.isNoneBlank(username)) {
            // 已登录
            /**######## 从Redis 获取购物车#######*/
            carts = cartService.findCartRedis(username);
            String cartStr = CookieUtils.getCookieValue(request, CookieUtils.CookieName.PINYOUGOU_CART, true);
            // 判断是否为空
            if (StringUtils.isNoneBlank(cartStr)) {
                // 转化成List 集合
                List<Cart> cookieCarts = JSON.parseArray(cartStr, Cart.class);
                if (cookieCarts != null && cookieCarts.size() > 0) {
                    // 合并购物车
                    carts = cartService.mergeCart(cookieCarts, carts);
                    // 将合并后的购物车存入Redis
                    cartService.saveCartRedis(username, carts);
                    // 删除Cookie 购物车
                    CookieUtils.deleteCookie(request, response,
                            CookieUtils.CookieName.PINYOUGOU_CART);
                }
            }
        } else {
            // 未登录
            // 从Cookie 中获取购物车集合json 字符串
            String cartStr = CookieUtils.getCookieValue(request,
                    CookieUtils.CookieName.PINYOUGOU_CART, true);
            // 判断是否为空
            if (StringUtils.isBlank(cartStr)) {
                cartStr = "[]";
            }

            carts = JSON.parseArray(cartStr, Cart.class);
        }

        return carts;
    }


}
