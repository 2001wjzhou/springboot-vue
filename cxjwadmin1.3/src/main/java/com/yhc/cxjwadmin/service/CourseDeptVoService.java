package com.yhc.cxjwadmin.service;

import com.yhc.cxjwadmin.vo.CourseDeptVo;


import java.util.List;

/**
 * @Author Corday 天涯
 * @Date 2022/5/4 15:45
 */
public interface CourseDeptVoService {
    //  .查询学院的开设的课程信息
    List<CourseDeptVo> queryAllDepts(String dname, Integer status, String cname, String code);
    //逻辑删除或恢复学院开设的课程
/*    String updateCousers(List<Integer> ids,int status);*/

    String upateCourse(String id,int status);

}
