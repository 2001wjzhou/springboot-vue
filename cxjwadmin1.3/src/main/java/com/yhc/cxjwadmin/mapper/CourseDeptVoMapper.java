package com.yhc.cxjwadmin.mapper;

import com.yhc.cxjwadmin.vo.CourseDeptVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author Corday 天涯
 * @Date 2022/5/4 15:34
 * @多表关联查询,通过视图来完成
 */
@Mapper
public interface CourseDeptVoMapper {
    //1.问:是否可以通过一条sql语句，或结合xml配置方式完成各种筛选操作：先在数据库中检验,再写入java中
    //根据课程状态查所有学院，按学院名称与课程状态，按学院名称与课程状态及课程名称,按学院名称与课程状态及课程编号
    //@Select("select * from view_course_dept where dname=#{dname} and status=#{status} or cname=#{cname} or code=#{code} ")
    @Select("<script>" + "select * from view_course_dept " +
            "<where>" +
            "<if test='dname!=null'>dname=#{dname}</if> " +
            "<if test='status!=null'>and status=#{status}</if>" +
            "<if test='cname!=null'> and cname like concat('%',#{cname},'%') </if> " +
            "<if test='code!=null'> and code=#{code}</if>" +
            "</where>" +
            "</script> ")
    List<CourseDeptVo> selectDepts(@Param("dname") String dname, @Param("status") Integer status, @Param("cname") String cname, @Param("code") String code);

    /*逻辑删除*/
    @Update("update  view_course_dept set status=#{status} where id=#{id}")
    int upateCourse(@Param("id") String id, @Param("status") int status);

}
