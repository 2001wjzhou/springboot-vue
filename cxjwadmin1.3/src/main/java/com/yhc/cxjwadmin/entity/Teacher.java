package com.yhc.cxjwadmin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
    private Integer id;
    private String tid;
    private String name;
    private String dept;
}
