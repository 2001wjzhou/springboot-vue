package com.yhc.cxjwadmin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Corday 天涯
 * @Date 2022/5/4 13:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDept {//关系实体
    private int id;
//    课程序号
    private int cid;
//    部门编号
    private int did;
//    课程类型:必修/限选/公选
    private String ctype;
//    测试类型:考试/考查
    private  String ttype;
//    状态1-正常,2-已删除
    private int stauts;
//    设置学期
//    private  int semester;
}
