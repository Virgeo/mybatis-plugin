package com.ch.learning.touchmybatis.simpleinterceptor.v2;

/**
 * @Description
 * @Author chengwg
 * @Date 2024/4/28 14:43
 */
public interface SimInterceptorV2 {
    Object intercept(SimInvocation invocation) throws Throwable;
}
