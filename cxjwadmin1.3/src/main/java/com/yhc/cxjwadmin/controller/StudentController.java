package com.yhc.cxjwadmin.controller;


import com.yhc.cxjwadmin.entity.Student;
import com.yhc.cxjwadmin.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/sgo")
    public List<Student> selectStudent(String name,String dept, String major, String classnum, String gradenum, String sex, Integer status) {
        return studentService.selectStudent(name, dept,major,classnum,gradenum,sex,status);
    }
    @RequestMapping("/supdate")
    public String updateCourse(@RequestParam("id") String id, @RequestParam("status") int status){
        System.out.println("输出"+id+status);
        return studentService.updateStudent(id,status);
    }
    @RequestMapping("/supdateAll")
    public String updateC(@RequestParam("sid") String sid, @RequestParam("name") String name, @RequestParam("sex") String sex, @RequestParam("dept") String dept,
                               @RequestParam("major") String major, @RequestParam("classnum") String classnum, @RequestParam("gradenum") String gradenum,
                               @RequestParam("id") String id){
        return studentService.updateStudentAll(sid,name,sex,dept,major,classnum,gradenum,id);
    }

}
