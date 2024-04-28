package com.ch.learning.touchmybatis.simpleinterceptor;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description
 * @Author chengwg
 * @Date 2024/4/28 14:42
 */
@Slf4j
public class BaseServiceImpl implements BaseService {
    @Override
    public String sayHello(String person) {
        log.info("+++++++++++++++++ say: Hello {}+++++++++++", person);
        return "Hello "+person;
    }
}
