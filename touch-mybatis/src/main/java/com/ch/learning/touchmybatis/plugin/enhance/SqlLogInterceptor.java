package com.ch.learning.touchmybatis.plugin.enhance;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author chengwg
 * @Date 2024/4/26 9:20
 */
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class,
                RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class,
                RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
})
@Component
@Slf4j
//@Order(1)
public class SqlLogInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("开始执行SqlLogInterceptor ...");

        long start = System.currentTimeMillis();
        try{
            return invocation.proceed();
        }finally {
            long end = System.currentTimeMillis();
            MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
            Object param = invocation.getArgs().length > 1 ? invocation.getArgs()[1] : null;
            String sql = mappedStatement.getBoundSql(param).getSql();
            log.info("SqlId[{}], SQL[{}], executeTime[{}] ms", mappedStatement.getId(), sql, end-start);
        }
    }
}
