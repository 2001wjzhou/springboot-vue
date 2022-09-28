package com.yhc.cxjwadmin.mapper;

import com.yhc.cxjwadmin.vo.CourseSectionVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseSectionMapper {

    @Select("<script>" + "select * from view_course_section " +
            "<where>" +
            "</where>" +
            "</script> ")
    List<CourseSectionVo> selectCS();

}
