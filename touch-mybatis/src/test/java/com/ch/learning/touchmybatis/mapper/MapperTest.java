package com.ch.learning.touchmybatis.mapper;



import com.ch.learning.touchmybatis.entity.StudentEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author chengwg
 * @Date 2023/3/23 14:12
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MapperTest {

    @Autowired
    private StudentEntityMapper studentEntityMapper;
    @Test
    public void student() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setSId("01");
        studentEntityMapper.updateByPrimaryKeySelective(studentEntity);
        System.out.println(studentEntity.toString());

//        StudentEntity studentEntity1 = new StudentEntity();
//        studentEntity1.setSId("09");
//        studentEntity1.setSName("傻春");
//        studentEntity1.setSSex("男");
//        studentEntity1.setSBirth("2001-01-01");
//        studentEntityMapper.updateByPrimaryKeySelective(studentEntity1);
//        System.out.println(studentEntity1.toString());

    }
}