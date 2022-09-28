package com.yhc.cxjwadmin.controller;

import com.yhc.cxjwadmin.service.CourseSectionService;
import com.yhc.cxjwadmin.vo.CourseDeptVo;
import com.yhc.cxjwadmin.vo.CourseSectionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class CourseSectionController {
    @Resource
    private CourseSectionService courseSectionService;

    @RequestMapping("/csgo")// http://localhost:8081/go?dname=文学院&status=2
    //拿到全是json字符串，需要我们解析为:dname,status,cname,code
    public List<CourseSectionVo> go() {
        return courseSectionService.selectCS();
    }
}
