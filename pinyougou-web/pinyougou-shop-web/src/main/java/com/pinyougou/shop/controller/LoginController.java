package com.pinyougou.shop.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: rainbow
 * Description:
 * Date:Create in 10:35 2018/11/6
 * Modified By:
 */
@RestController
public class LoginController {

    @GetMapping("/showLoginName")
    public Map<String,String> showLoginName() {
        String loginName = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String,String> data = new HashMap<>();
        data.put("loginName",loginName);
        return data;
    }
}
