package com.ooqiu.gaming.server.web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String main() {
        return "main";
    }

    /**
     * 跳转到起始页
     * @return
     */
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    /**
     * 登录业务
     * @param email 邮箱
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String email, String password) {
        if ("admin@admin.com".equals(email) && "admin".equals(password)) {
            return "redirect:main";
        } else {
            return "login";
        }
    }
}
