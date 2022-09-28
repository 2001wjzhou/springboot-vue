package com.yhc.cxjwadmin.mapper;

import com.yhc.cxjwadmin.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Corday 天涯
 * @Date 2022/5/4 14:02
 */
@Mapper
public interface DeptMapper {
// 1.查询某个学院开设的所有课程
 List<Dept> selectDepts(String dname);
}
