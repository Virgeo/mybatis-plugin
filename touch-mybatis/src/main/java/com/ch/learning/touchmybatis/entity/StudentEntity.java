package com.ch.learning.touchmybatis.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "student")
@Data
public class StudentEntity {
    @Id
    @Column(name = "s_id")
    private String sId;

    @Column(name = "s_name")
    private String sName;

    @Column(name = "s_birth")
    private String sBirth;

    @Column(name = "s_sex")
    private String sSex;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
}