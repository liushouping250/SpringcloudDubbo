package com.dubbo.demo.util.filters;

import com.dubbo.demo.util.globalException.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

import java.util.Arrays;

/**
 * @author mr.monster
 * @version 1.0
 * @Description
 * @date 2022/4/16 23:13
 */

@Activate(group = CommonConstants.CONSUMER)
@Slf4j
public class RequestHandlerInterceptorConfig implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        if (invoker.getUrl() == null) {
            throw new RpcException("调用Dubbo服务时，准备动作处理失败！");
        }
        log.info("[{}], [{}], [{}]", invoker.getInterface(), invocation.getMethodName(), Arrays.toString(invocation.getArguments()));
        Result invoke = invoker.invoke(invocation);
        if (invoke.hasException() ) {
            ResultUtil.error(122,"rpc error");
        }
        return invoke;

    }

}
