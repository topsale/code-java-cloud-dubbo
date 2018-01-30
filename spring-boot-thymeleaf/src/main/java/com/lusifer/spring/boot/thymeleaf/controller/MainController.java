package com.lusifer.spring.boot.thymeleaf.controller;

import com.lusifer.spring.boot.thymeleaf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @RequestMapping(value = {"", "index"})
    public String main(Model model) {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("张三");
        user1.setAge(22);

        User user2 = new User();
        user2.setId(2L);
        user2.setName("李四");
        user2.setAge(25);

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        model.addAttribute("list", list);

        return "index";
    }
}
