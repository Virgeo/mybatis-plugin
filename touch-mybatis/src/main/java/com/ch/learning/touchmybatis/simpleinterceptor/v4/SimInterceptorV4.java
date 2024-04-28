package com.ch.learning.touchmybatis.simpleinterceptor.v4;

import com.ch.learning.touchmybatis.simpleinterceptor.v2.SimInvocation;
import com.ch.learning.touchmybatis.simpleinterceptor.v3.SimPluginV3;
import org.apache.ibatis.plugin.Plugin;

/**
 * @Description
 * @Author chengwg
 * @Date 2024/4/28 14:43
 */
public interface SimInterceptorV4 {
    Object intercept(SimInvocation invocation) throws Throwable;

    default Object plugin(Object target) {
        return SimPluginV4.wrap(target, this);
    }
}
