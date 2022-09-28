package com.yhc.cxjwadmin.mapper;

import com.yhc.cxjwadmin.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Corday 天涯
 * @Date 2022/5/4 13:56
 */
@Mapper
public interface CourseMapper {
// 1.查询某个课程对应的所有学院信息
 List<Course> selectCourses(String cname);
}
