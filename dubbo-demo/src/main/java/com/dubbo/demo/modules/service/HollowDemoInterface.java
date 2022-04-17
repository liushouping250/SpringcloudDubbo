package com.dubbo.demo.modules.service;

import com.dubbo.demo.aop.SysLog;

/**
 * @author mr.monster
 * @version 1.0
 * @Description
 * @date 2022/4/17 14:06
 */
public interface HollowDemoInterface {
    @SysLog("AOP测试")
    Object implMethod(String  name);
}
