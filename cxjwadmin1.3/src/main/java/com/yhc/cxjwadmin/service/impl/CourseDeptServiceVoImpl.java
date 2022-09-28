package com.yhc.cxjwadmin.service.impl;

import com.yhc.cxjwadmin.mapper.CourseDeptVoMapper;
import com.yhc.cxjwadmin.service.CourseDeptVoService;
import com.yhc.cxjwadmin.vo.CourseDeptVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Corday 天涯
 * @Date 2022/9/22 14:21
 */
@Service
public class CourseDeptServiceVoImpl implements CourseDeptVoService {
    @Resource
    protected CourseDeptVoMapper courseDeptVoMapper;

    /**
     * 查询学院开设的课程信息
     *
     * @param dname
     * @param status
     * @param cname
     * @param code
     * @return
     */
    @Override
    public List<CourseDeptVo> queryAllDepts(String dname, Integer status, String cname, String code) {
        if("all".equals(dname)){
            dname=null;
        }
        if("all".equals(cname)){
            cname=null;
        }
        return courseDeptVoMapper.selectDepts(dname, status, cname, code);
    }

    @Override
    public String upateCourse(String id, int status) {
        status=(status==1) ? 2:1;
        int n = courseDeptVoMapper.upateCourse(id, status);

        return n > 0 ? "更新成功" : "更新有误";
    }

    /**
     * @param ids
     * @param status
     * @return
     */
/*    @Override
    public String updateCousers(List<Integer> ids, int status) {
        int n = courseDeptVoMapper.upateCourses(ids, status);
        return n > 0 ? "更新成功" : "更新有误";
    }*/

}
