package com.yhc.cxjwadmin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author Corday 天涯
 * @Date 2022/5/4 13:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private int did;
    private  String dname;
    private String tel;
//    private List<Course> courseList;
}
