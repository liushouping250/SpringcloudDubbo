package com.dubbo.demo.modules.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: Monster
 * @Date: 2022/04/19/14:12
 * @Description:
 */
@Data
public class DemoRequestVO {

    @ApiModelProperty("姓名")
    private String name;

}
