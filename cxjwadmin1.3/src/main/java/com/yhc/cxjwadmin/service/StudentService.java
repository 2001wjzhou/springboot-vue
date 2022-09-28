package com.yhc.cxjwadmin.service;

import com.yhc.cxjwadmin.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    List<Student> selectStudent(String name, String dept, String major, String classnum, String gradenum, String sex, Integer status);

    String updateStudent(String id,int status);

    String updateStudentAll(String sid, String name, String sex, String dept, String major,  String classnum,  String gradenum, String id);
}
