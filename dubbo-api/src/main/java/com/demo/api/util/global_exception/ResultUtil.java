package com.demo.api.util.global_exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 统一响应数据
 * @author: Mr.monster.liu
 * @create: 2021-05-11 16:19
 **/
@Data
public class ResultUtil<T> {

    @ApiModelProperty("响应代码")
    private Integer  code;
    @ApiModelProperty("响应信息")
    private  String msg;
    @ApiModelProperty("响应结果集")
    private  T result;


    public  static<T> ResultUtil<T> success(T object) {

        ResultUtil<T> objectTestResponseDTO = new ResultUtil<>();

        objectTestResponseDTO.setCode(ResultCode.SUCCESS.getCode());

        objectTestResponseDTO.setMsg(ResultCode.SUCCESS.getMsg());

        objectTestResponseDTO.setResult(object);

        return objectTestResponseDTO;
    }

    public static<T> ResultUtil<Object> success() {
        return success(null);
    }

    public static ResultUtil<Object>  error(Integer code, String msg) {

        ResultUtil<Object> objectTestResponseDTO = new ResultUtil<>();

        objectTestResponseDTO.setCode(code);

        objectTestResponseDTO.setMsg(msg);

        return objectTestResponseDTO;
    }

    public static ResultUtil<Object>  error( String msg) {

        ResultUtil<Object> objectTestResponseDTO = new ResultUtil<>();

        objectTestResponseDTO.setCode(200);

        objectTestResponseDTO.setMsg(msg);

        return objectTestResponseDTO;
    }
}
