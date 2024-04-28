package com.ch.learning.touchmybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.ch.learning.touchmybatis.mapper")
@SpringBootApplication
public class TouchMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TouchMybatisApplication.class, args);
    }

}
