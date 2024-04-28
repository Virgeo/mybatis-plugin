package com.ch.learning.touchmybatis.simpleinterceptor.v4;

import com.ch.learning.touchmybatis.simpleinterceptor.BaseService;
import com.ch.learning.touchmybatis.simpleinterceptor.BaseServiceImpl;
import com.ch.learning.touchmybatis.simpleinterceptor.v2.SimInterceptorV2;
import com.ch.learning.touchmybatis.simpleinterceptor.v2.SimInvocation;
import com.ch.learning.touchmybatis.simpleinterceptor.v3.SimPluginV3;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author chengwg
 * @Date 2024/4/28 15:02
 */
@Slf4j
public class TestV4 {
    public static void main(String[] args) {
        BaseService baseService = new BaseServiceImpl();
        SimInterceptorV4 simInterceptor1 = invocation -> {
            log.info("执行拦截...修改入参为[小花]");
            Object[] args1 = invocation.getArgs();
            args1[0] = "小花";
            return invocation.proceed();
        };
        SimInterceptorV4 simInterceptor2 = invocation -> {
            log.info("执行拦截...修改入参为[小李]");
            Object[] args1 = invocation.getArgs();
            args1[0] = "小李";
            return invocation.proceed();
        };
        List<SimInterceptorV4> interceptorList = new ArrayList<>();
        interceptorList.add(simInterceptor1);
        interceptorList.add(simInterceptor2);

        BaseService proxyService = baseService;
        for (SimInterceptorV4 interceptor : interceptorList) {
            proxyService = (BaseService) interceptor.plugin(proxyService);
        }

        proxyService.sayHello("小米");
    }
}


