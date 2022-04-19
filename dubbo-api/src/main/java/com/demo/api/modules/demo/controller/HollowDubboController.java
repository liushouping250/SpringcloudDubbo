package com.demo.api.modules.demo.controller;


import com.demo.api.util.globalException.ResultUtil;
import com.demo.service.service.HollowDubbo;
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
public class HollowDubboController  {

    @Autowired
    private HollowDubbo hollowDubbo;


    @GetMapping("/hello")
    public ResultUtil<Object> hello() {
        return ResultUtil.success(hollowDubbo.hello("Dubbo!"));
    }

}
