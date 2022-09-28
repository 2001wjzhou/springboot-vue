package com.yhc.cxjwadmin.service.impl;

import com.yhc.cxjwadmin.entity.Student;
import com.yhc.cxjwadmin.mapper.StudentMapper;
import com.yhc.cxjwadmin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectStudent(String name,String dept, String major, String classnum, String gradenum, String sex, Integer status) {
        if("all".equals(dept)){
            dept=null;
        }
        if("all".equals(major)){
            major=null;
        }if("all".equals(classnum)){
            classnum=null;
        }if("all".equals(gradenum)){
            gradenum=null;
        }if("all".equals(sex)){
            sex=null;
        }
        return studentMapper.selectStudent(name,dept,major,classnum,gradenum,sex,status);
    }

    @Override
    public String updateStudent(String id, int status) {
        status=(status==1) ? 2:1;
        int n = studentMapper.updateStudent(id, status);
        return n > 0 ? "更新成功" : "更新有误";
    }

    @Override
    public String updateStudentAll(String sid, String name, String sex, String dept, String major, String classnum, String gradenum, String id) {
        int n= studentMapper.updateStudentAll(sid,  name,  sex,  dept,  major,  classnum,  gradenum,  id);
        return n > 0 ? "更新成功" : "更新有误";
    }
}
