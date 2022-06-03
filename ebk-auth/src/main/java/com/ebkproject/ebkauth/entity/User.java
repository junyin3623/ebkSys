package com.ebkproject.ebkauth.entity;

import lombok.Data;

@Data
public class User {
    private String id;
    private String username;
    private String password;
    //省略了get和set方法
}
