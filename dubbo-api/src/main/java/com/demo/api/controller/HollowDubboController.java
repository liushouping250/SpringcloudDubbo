package com.demo.api.controller;

import com.demo.service.service.HollowDubbo;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author mr.monster
 * @version 1.0
 * @Description
 * @date 2022/4/10 11:00
 */
@Service
public class HollowDubboController implements HollowDubbo {


    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
