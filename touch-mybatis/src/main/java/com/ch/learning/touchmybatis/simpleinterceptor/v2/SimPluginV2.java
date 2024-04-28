package com.ch.learning.touchmybatis.simpleinterceptor.v2;

import com.ch.learning.touchmybatis.simpleinterceptor.v1.SimInterceptorV1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author chengwg
 * @Date 2024/4/28 14:44
 */
public class SimPluginV2 implements InvocationHandler {
    //拦截器
    private SimInterceptorV2 simInterceptorV2;
    //目标对象
    private Object target;

    public SimPluginV2(Object target, SimInterceptorV2 simInterceptorV2) {
        this.simInterceptorV2 = simInterceptorV2;
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return simInterceptorV2.intercept(new SimInvocation(method, args, target));
    }
}
