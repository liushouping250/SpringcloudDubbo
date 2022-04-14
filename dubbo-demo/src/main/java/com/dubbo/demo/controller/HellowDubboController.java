package com.dubbo.demo.controller;

import com.demo.service.service.HollowDubbo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mr.monster
 * @version 1.0
 * @Description
 * @date 2022/4/10 11:00
 */
@RestController
public class HellowDubboController {


    @Reference
    private HollowDubbo hollowDubbo;

    @GetMapping("/hello")
    public String hello() {
        return hollowDubbo.hello("Dubbo!");
    }
}
