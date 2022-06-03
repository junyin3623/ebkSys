package com.ebkproject.ebkauth.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ebkproject.ebkauth.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserMapper extends BaseMapper<User> {

    User gotoLogin(@Param("user") User user);
}
