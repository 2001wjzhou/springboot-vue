package com.yhc.cxjwadmin.service;

import com.yhc.cxjwadmin.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> selectTeacher(String dept, String sex);

}
