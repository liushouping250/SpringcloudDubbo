package com.dubbo.demo.modules.controller;

import com.dubbo.demo.modules.service.impl.HollowDubboImpl;
import com.dubbo.demo.util.global_exception.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    private HollowDubboImpl hollowDubbo;

    @GetMapping("/hello")
    public ResultUtil<Object> hello() {
        return ResultUtil.success(hollowDubbo.implMethod("Dubbo!"));

    }
}
