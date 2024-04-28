package com.ch.learning.touchmybatis.simpleinterceptor.v1;

import com.ch.learning.touchmybatis.simpleinterceptor.BaseService;
import com.ch.learning.touchmybatis.simpleinterceptor.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author chengwg
 * @Date 2024/4/28 15:02
 */
@Slf4j
public class TestV1 {
    public static void main(String[] args) {
        BaseService baseService = new BaseServiceImpl();
        SimInterceptorV1 simInterceptorV1 = new SimInterceptorV1() {
            @Override
            public Object intercept() throws Throwable {
                log.info("执行拦截...");
                return null;
            }
        };
        SimPluginV1 simPluginV1 = new SimPluginV1(baseService, simInterceptorV1);
        BaseService proxyService = (BaseService) Proxy.newProxyInstance(BaseService.class.getClassLoader(), BaseServiceImpl.class.getInterfaces(), simPluginV1);
        proxyService.sayHello("小米");
    }
}
