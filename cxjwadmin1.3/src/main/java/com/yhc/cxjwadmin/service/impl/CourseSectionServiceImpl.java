package com.yhc.cxjwadmin.service.impl;

import com.yhc.cxjwadmin.mapper.CourseSectionMapper;
import com.yhc.cxjwadmin.service.CourseSectionService;
import com.yhc.cxjwadmin.vo.CourseSectionVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Corday 天涯
 * @Date 2022/5/4 15:45
 */

@Service
public class CourseSectionServiceImpl implements CourseSectionService {
    @Resource
    private CourseSectionMapper sectionMapper;

    public List<CourseSectionVo> selectCS(){
        return sectionMapper.selectCS();
    }

}
