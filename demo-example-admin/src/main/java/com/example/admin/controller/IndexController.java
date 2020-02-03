package com.example.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author oyxl 10071355
 * @version 1.0
 * @description TODO
 * @date 2020/1/21 10:44
 * @blame 仓储开发组
 **/
@Controller
@RequestMapping("/")
public class IndexController {


    @GetMapping("main")
    public String index(Map data) {
        data.put("name", "YiHui Freemarker");
        data.put("now", LocalDateTime.now().toString());
        return "index";
    }



}
