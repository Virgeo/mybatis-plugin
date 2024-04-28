package com.ch.learning.touchmybatis.simpleinterceptor.v3;

import com.ch.learning.touchmybatis.simpleinterceptor.v2.SimInterceptorV2;
import com.ch.learning.touchmybatis.simpleinterceptor.v2.SimInvocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author chengwg
 * @Date 2024/4/28 14:44
 */
public class SimPluginV3 implements InvocationHandler {
    //拦截器
    private SimInterceptorV2 simInterceptorV2;
    //目标对象
    private Object target;

    public SimPluginV3(Object target, SimInterceptorV2 simInterceptorV2) {
        this.simInterceptorV2 = simInterceptorV2;
        this.target = target;
    }

    public static Object wrap(Object target, SimInterceptorV2 interceptor) {
        Class<?> type = target.getClass();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        return interfaces.length > 0 ? Proxy.newProxyInstance(type.getClassLoader(), interfaces, new SimPluginV3(target, interceptor)) : target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return simInterceptorV2.intercept(new SimInvocation(method, args, target));
    }
}
