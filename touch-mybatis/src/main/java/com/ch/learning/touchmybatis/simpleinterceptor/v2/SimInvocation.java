package com.ch.learning.touchmybatis.simpleinterceptor.v2;

import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author chengwg
 * @Date 2024/4/28 16:04
 */
@Data
public class SimInvocation {
    private Method method;
    private Object[] args;
    //目标对象
    private Object target;

    public SimInvocation(Method method, Object[] args, Object target) {
        this.method = method;
        this.args = args;
        this.target = target;
    }

    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return this.method.invoke(target, args);
    }
}
