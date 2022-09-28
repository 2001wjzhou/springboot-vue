package com.yhc.cxjwadmin.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Corday 天涯
 * @Date 2022/5/4 15:28
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDeptVo {//对应数据库中的视图表
//    序号
    private  int id;
//    课程编号
    private String code;
//    课程名称
    private String cname;
//    学时
    private int period;
//    学分
    private  int credit;
//    学院名称
    private String dname;
//    课程类型
    private String ctype;
//    测试类型
    private String ttype;
//    课程状态:1-正常,2-删除
    private int status;
}
