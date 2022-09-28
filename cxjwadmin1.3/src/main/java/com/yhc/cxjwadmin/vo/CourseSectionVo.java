package com.yhc.cxjwadmin.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseSectionVo {
    private int id;
    private String name;
    private String sid;
    private String code;
    private String cname;
    private String year;
    private String term;
}
