package com.yhc.cxjwadmin.controller;

import com.yhc.cxjwadmin.service.CourseDeptVoService;
import com.yhc.cxjwadmin.vo.CourseDeptVo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Corday 天涯
 * @Date 2022/5/4 15:52
 */
@RestController//所有请求均返回json字符串
@CrossOrigin//允许跨域(不同的服务地址)访问
public class CourseDeptController {
    //    注入一个对象
    @Resource
    private CourseDeptVoService courseDeptService;
    /**
     * @param dname  学院名称
     * @param status 课程状态：1开设,2删除
     * @param cname  课程名称
     * @param code   课程编码
     * @return
     */
    @RequestMapping("/go")// http://localhost:8081/go?dname=文学院&status=2
    //拿到全是json字符串，需要我们解析为:dname,status,cname,code
    public List<CourseDeptVo> go(String dname, Integer status, String cname, String code) {
        //数据库中查所有学院的课程信息
        //System.out.println("学院："+dname);
        //System.out.println("状态："+status);
        return courseDeptService.queryAllDepts(dname, status, cname, code);
    }
    /**
     * 拿到全是json字符串，需要我们解析为:List,status
     * @param ids
     * @param status
     * @return
     * String ids
     */

/*    @RequestMapping("/update")
    public String updateCourse(List<Integer> ids,int status){
        //List<CourseDeptVo>  cs=null;
        //int st=1;

        return courseDeptService.updateCousers(ids,status);
    }*/
    @RequestMapping("/update")
    public String updateCourse(@RequestParam("id") String id,@RequestParam("status") int status){
        System.out.println("输出"+id+status);
        return courseDeptService.upateCourse(id,status);
    }
}
