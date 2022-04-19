package com.dubbo.demo.modules.demo.controller;

import com.demo.service.service.HollowDubbo;
import com.dubbo.demo.modules.demo.vo.DemoRequestVO;
import com.dubbo.demo.util.globalException.ResultUtil;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * @author mr.monster
 * @version 1.0
 * @Description
 * @date 2022/4/10 11:00
 */
@RestController
@RequestMapping("/api")
@Api(tags = "测试demo")
public class HellowDubboController {


    @Reference(check = false)
    private HollowDubbo hollowDubbo;

    @GetMapping("/hello")
    @ApiOperation(value = "get 接口参数")
    public ResultUtil<String> hello(@ApiParam(name = "name", value = "姓名", required = true) @RequestParam("name") String name) {
        return ResultUtil.success(hollowDubbo.hello(name));
    }

    @PostMapping("/test")
    @ApiOperation(value = "post 文档参数", response = DemoRequestVO.class)
    public ResultUtil<DemoRequestVO> test(@RequestBody DemoRequestVO demoRequest){
        return ResultUtil.success(demoRequest);
    }

}
