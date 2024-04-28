package com.ch.learning.touchmybatis.simpleinterceptor.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author chengwg
 * @Date 2024/4/28 14:44
 */
public class SimPluginV1 implements InvocationHandler {
    //拦截器
    private SimInterceptorV1 simInterceptorV1;
    //目标对象
    private Object target;

    public SimPluginV1(Object target, SimInterceptorV1 simInterceptorV1) {
        this.simInterceptorV1 = simInterceptorV1;
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        simInterceptorV1.intercept();
        return method.invoke(target, args);
    }
}
