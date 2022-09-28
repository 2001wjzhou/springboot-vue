package com.yhc.cxjwadmin;

import com.yhc.cxjwadmin.mapper.*;
import com.yhc.cxjwadmin.service.CourseDeptVoService;
import com.yhc.cxjwadmin.service.StudentService;
import com.yhc.cxjwadmin.vo.CourseDeptVo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 如果是纯注解编程，则不需要@RunWith来管理xml配置
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class CxjwadminApplicationTests {
    @Resource
    private CourseDeptVoService courseDeptService;
    @Resource
    private StudentService studentService;
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private CourseSectionMapper courseSectionMapper;
    @Test
    void queryDepts() {
        List<CourseDeptVo> list = courseDeptService.queryAllDepts(null,1,"写作",null);
        System.out.println(list);
    }
    @Test
    public  void updateCourse(){
     String msg = courseDeptService.upateCourse("100001",2);
        System.out.println("当前为:"+msg);
    }
    @Test
    public void tes01(){

/*        System.out.println("student信息"+studentMapper.selectStudent(null,null,null,null,null,null,null));
        System.out.println("------");*/
        System.out.println("查询所有"+studentService.updateStudentAll("190101","张嘉雯","女","化工学院","化学工程与工艺","化工191","2019","1"));
    }
    @Test
    public void test02(){
        System.out.println(studentService.updateStudent("1",1));
    }
    @Test
    public void test03(){
        System.out.println("教师信息"+teacherMapper.selectTeacher(null,"男"));
    }
    @Test
    public void tes04(){

        System.out.println("选课细节信息"+courseSectionMapper.selectCS());
    }
}
