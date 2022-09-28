package com.yhc.cxjwadmin.mapper;

import com.yhc.cxjwadmin.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author Corday 天涯
 * @Date 2022/5/4 15:34
 * @多表关联查询,通过视图来完成
 */
@Mapper
public interface TeacherMapper {
    //1.问:是否可以通过一条sql语句，或结合xml配置方式完成各种筛选操作：先在数据库中检验,再写入java中
    //根据课程状态查所有学院，按学院名称与课程状态，按学院名称与课程状态及课程名称,按学院名称与课程状态及课程编号
    //@Select("select * from view_course_dept where dname=#{dname} and status=#{status} or cname=#{cname} or code=#{code} ")
    @Select("<script>" + "select * from teachers " +
            "<where>" +
            "<if test='dept!=null'>dept=#{dept}</if> " +
            "<if test='sex!=null'>and sex=#{sex}</if>" +
            "</where>" +
            "</script> ")
    List<Teacher> selectTeacher(@Param("dept") String dept,@Param("sex") String sex);


    @Select("select * from teachers")
    List<Teacher> selectAll();


}
