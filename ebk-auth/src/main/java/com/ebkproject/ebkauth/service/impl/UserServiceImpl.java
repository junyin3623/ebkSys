package com.ebkproject.ebkauth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ebkproject.ebkauth.dao.UserMapper;
import com.ebkproject.ebkauth.entity.User;
import com.ebkproject.ebkauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("jwt")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {

//        UserDao baseMapper = this.getBaseMapper();

        //查询数据库
        System.out.println(user.toString());
        User userDB = userMapper.gotoLogin(user);
        System.out.println(userDB.toString() + "---------------");
        if (userDB != null) {
            return userDB;
        }
        throw new RuntimeException("登录失败");
    }
}
