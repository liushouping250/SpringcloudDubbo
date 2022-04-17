package com.demo.api.util.filters;

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
@Slf4j
@Activate(group = CommonConstants.PROVIDER)
public class RequestHandlerInterceptorConfig  implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        //获取要过滤的方法的参数
        Object[] params = invocation.getArguments();
        //有需要返回值的业务逻辑

        log.info("[{}], [{}], [{}]", invoker.getInterface(), invocation.getMethodName(), Arrays.toString(invocation.getArguments()));

        //做自己的逻辑
        return invoker.invoke(invocation);
    }

}
