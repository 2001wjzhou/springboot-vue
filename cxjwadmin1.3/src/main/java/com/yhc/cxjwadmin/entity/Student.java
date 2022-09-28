package com.yhc.cxjwadmin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private Integer id;
    private String sid;
    private String name;
    private String sex;
    private String dept;
    private String major;
    private String classnum;
    private String gradenum;
    private Integer status;
}
