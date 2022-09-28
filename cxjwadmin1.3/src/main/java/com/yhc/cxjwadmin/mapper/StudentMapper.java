package com.yhc.cxjwadmin.mapper;

import com.yhc.cxjwadmin.entity.Student;
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
public interface StudentMapper {
    //1.问:是否可以通过一条sql语句，或结合xml配置方式完成各种筛选操作：先在数据库中检验,再写入java中
    //根据课程状态查所有学院，按学院名称与课程状态，按学院名称与课程状态及课程名称,按学院名称与课程状态及课程编号
    //@Select("select * from view_course_dept where dname=#{dname} and status=#{status} or cname=#{cname} or code=#{code} ")
    @Select("<script>" + "select * from students " +
            "<where>" +
            "<if test='dept!=null'>dept=#{dept}</if> " +
            "<if test='major!=null'>and major=#{major}</if>" +
            "<if test='classnum!=null'> and classnum=#{classnum}</if>" +
            "<if test='gradenum!=null'> and gradenum=#{gradenum}</if>" +
            "<if test='sex!=null'> and sex=#{sex}</if>" +
            "<if test='status!=null'> and status=#{status}</if>" +
            "<if test='name!=null'> and name like concat('%',#{name},'%') </if> " +
            "</where>" +
            "</script> ")
    List<Student> selectStudent(@Param("name") String name,
            @Param("dept") String dept,@Param("major") String major,@Param("classnum") String classnum,
            @Param("gradenum") String gradenum,@Param("sex") String sex,@Param("status") Integer status
    );

    /*逻辑删除*/
    @Update("update  students set status=#{status} where id=#{id}")
    int updateStudent(@Param("id") String id, @Param("status") int status);

    @Select("select * from students")
    List<Student> selectAll();

    @Update("update students set " +
            "sid=#{sid},name=#{name},sex=#{sex},dept=#{dept},major=#{major},classnum=#{classnum},gradenum=#{gradenum} where id=#{id}")
    int updateStudentAll(@Param("sid") String sid,@Param("name") String name,@Param("sex") String sex,@Param("dept") String dept,
                         @Param("major") String major,@Param("classnum") String classnum,@Param("gradenum") String gradenum,
                         @Param("id") String id);
}
