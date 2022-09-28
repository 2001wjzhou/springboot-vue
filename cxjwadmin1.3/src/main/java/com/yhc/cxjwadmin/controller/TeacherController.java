package com.yhc.cxjwadmin.controller;


import com.yhc.cxjwadmin.entity.Teacher;
import com.yhc.cxjwadmin.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/tgo")
    public List<Teacher> selectTeacher(String dept, String sex) {
        return teacherService.selectTeacher(dept,sex);
    }

}
