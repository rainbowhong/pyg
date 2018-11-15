package com.pinyougou.manager.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: rainbow
 * Description:
 * Date:Create in 16:13 2018/11/5
 * Modified By:
 */
@RestController
public class LoginController {
    /**
     * 显示登录用户名
     */
    @GetMapping("/showLoginName")
    public Map<String, String> showLoginName() {
        String loginName = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, String> data = new HashMap<>();
        data.put("loginName",loginName);
        return data;
    }
}
