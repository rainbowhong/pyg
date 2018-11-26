package com.pinyougou.service;

import com.pinyougou.cart.Cart;

import java.util.List;

public interface CartService {


    /**
     * @param carts
     * @param itemId
     * @param num
     * @return
     */


    // 调用服务层添加SKU 商品到购物车
    List<Cart> addItemToCart(List<Cart> carts, Long itemId, Integer num);


    /**
     * 从Redis中查询购物车
     *
     * @param username 用户名
     * @return 购物车
     */
    List<Cart> findCartRedis(String username);


    /**
     * 将购物车保存到Redis
     *
     * @param username 用户名
     * @param carts    购物车
     */
    void saveCartRedis(String username, List<Cart> carts);


    /**
     * 合并购物车
     * @param cookieCarts cookie购物车
     * @param carts Redis购物车
     * @return  合并后的购物车
     */
    List<Cart> mergeCart(List<Cart> cookieCarts, List<Cart> carts);
}
