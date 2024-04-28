package com.ch.learning.touchmybatis.simpleinterceptor.v3;

import com.ch.learning.touchmybatis.simpleinterceptor.BaseService;
import com.ch.learning.touchmybatis.simpleinterceptor.BaseServiceImpl;
import com.ch.learning.touchmybatis.simpleinterceptor.v2.SimInterceptorV2;
import com.ch.learning.touchmybatis.simpleinterceptor.v2.SimInvocation;
import com.ch.learning.touchmybatis.simpleinterceptor.v2.SimPluginV2;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author chengwg
 * @Date 2024/4/28 15:02
 */
@Slf4j
public class TestV3 {
    public static void main(String[] args) {
        BaseService baseService = new BaseServiceImpl();
        SimInterceptorV2 simInterceptorV2 = new SimInterceptorV2(){
            @Override
            public Object intercept(SimInvocation invocation) throws Throwable {
                log.info("执行拦截...修改入参为[小花]");
                Object[] args1 = invocation.getArgs();
                args1[0] = "小花";
                return invocation.proceed();
            }
        };
        BaseService proxyService = (BaseService) SimPluginV3.wrap(baseService, simInterceptorV2);
        proxyService.sayHello("小米");
    }
}
