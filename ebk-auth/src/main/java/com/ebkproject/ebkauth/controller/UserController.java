package com.ebkproject.ebkauth.controller;

import com.ebkproject.ebkauth.entity.User;
import com.ebkproject.ebkauth.service.UserService;
import com.ebkproject.ebkauth.util.JWTUtils;
import com.ebkproject.ebkcommon.constant.AuthServerConstant;
//import com.sun.tracing.dtrace.ModuleAttributes;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    /**
     * 使用user 账号密码获取token
     * @param user
     * @return
     */
    @GetMapping("/user/login")
    public Map<String, Object> login(@ModelAttribute User user) {
        log.info("用户名：[{}]", user.getUsername());
        log.info("密码：[{}]", user.getPassword());

        Map<String, Object> map = new HashMap<>();

        try {
            User userDB = userService.login(user);
            Map<String, String> payload = new HashMap<>();
            payload.put("id", userDB.getId());
            payload.put("username", userDB.getUsername());

            //生成JWT令牌
            String token = JWTUtils.getToken(payload);

            map.put("state", true);
            map.put("token", token);
            map.put("msg", "认证成功");

        } catch (
                Exception e) {
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }


    /**
     * 基于interceptor 验证token有效性
     * @param token
     * @return
     */
    @PostMapping("/user/verify")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "请求token", required = true, paramType = "header"),
    })
    public Map<String, Object> test(String token) {
        Map<String, Object> map = new HashMap<>();
        map.put("state", true);
        map.put("msg", "请求成功");
//        stringRedisTemplate.opsForValue().set();
        return map;
    }
}
