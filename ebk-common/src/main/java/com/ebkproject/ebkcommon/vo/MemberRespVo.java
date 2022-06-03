package com.ebkproject.ebkcommon.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class MemberRespVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String username;
    private String password;
    //省略了get和set方法
}
