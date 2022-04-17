package com.dubbo.demo.modules.service.impl;

import com.demo.service.service.HollowDubbo;
import com.dubbo.demo.aop.SysLog;
import com.dubbo.demo.modules.service.HollowDemoInterface;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author mr.monster
 * @version 1.0
 * @Description
 * @date 2022/4/17 1:06
 */
@Service
public class HollowDubboImpl implements HollowDemoInterface {

    @Reference(check = false)//check true 启动引用会检查服务是否可用
    private HollowDubbo hollowDubbo;

    @SysLog("AOP测试")
    public Object implMethod(String  name){
        System.out.printf("implMethod===========");
        return hollowDubbo.hello(name);
    }
}
