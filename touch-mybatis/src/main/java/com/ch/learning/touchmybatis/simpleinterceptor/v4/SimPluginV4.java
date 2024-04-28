package com.ch.learning.touchmybatis.simpleinterceptor.v4;

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
public class SimPluginV4 implements InvocationHandler {
    //拦截器
    private SimInterceptorV4 simInterceptorV4;
    //目标对象
    private Object target;

    public SimPluginV4(Object target, SimInterceptorV4 simInterceptorV4) {
        this.simInterceptorV4 = simInterceptorV4;
        this.target = target;
    }

    public static Object wrap(Object target, SimInterceptorV4 interceptor) {
        Class<?> type = target.getClass();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        return interfaces.length > 0 ? Proxy.newProxyInstance(type.getClassLoader(), interfaces, new SimPluginV4(target, interceptor)) : target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return simInterceptorV4.intercept(new SimInvocation(method, args, target));
    }
}
