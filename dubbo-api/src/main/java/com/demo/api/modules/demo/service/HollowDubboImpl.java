package com.demo.api.modules.demo.service;

import com.demo.service.service.HollowDubbo;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author mr.monster
 * @version 1.0
 * @Description
 * @date 2022/4/17 12:09
 */
@Service
public class HollowDubboImpl  implements HollowDubbo {

    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
