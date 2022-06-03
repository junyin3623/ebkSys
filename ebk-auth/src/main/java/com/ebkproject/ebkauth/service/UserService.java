package com.ebkproject.ebkauth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ebkproject.ebkauth.entity.User;

public interface UserService extends IService<User> {
    User login(User user);
}
