package com.yhc.cxjwadmin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author Corday 天涯
 * @Date 2022/5/4 13:45
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {
//    课程序号
    private int cid;
//    课程编号
    private String code;
    private String cname;
//    总学时
    private int period;
//    学分
    private int credit;
    private List<Dept> deptList;
}
