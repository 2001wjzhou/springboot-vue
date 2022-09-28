package com.yhc.cxjwadmin.service.impl;

import com.yhc.cxjwadmin.entity.Teacher;
import com.yhc.cxjwadmin.mapper.TeacherMapper;
import com.yhc.cxjwadmin.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> selectTeacher(String dept, String sex) {
        return teacherMapper.selectTeacher(dept,sex);
    }



}
