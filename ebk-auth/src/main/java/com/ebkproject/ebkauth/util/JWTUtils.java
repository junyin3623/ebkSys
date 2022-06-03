package com.ebkproject.ebkauth.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ebkproject.ebkcommon.constant.AuthServerConstant;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {

    private static final String SING = "GONG123456";

    /**
     * 生成token
     */
    public static String getToken(Map<String, String> map) {
        Calendar instance = Calendar.getInstance();
        //默认7天过期
        instance.add(Calendar.DATE, 1);

        //创建jwt builder
        JWTCreator.Builder builder = JWT.create();

        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });

        String token = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SING));
        String token_full = AuthServerConstant.AUTH_JWT_TOKEN_PREFIX + token;
        return token_full;
    }

    /**
     * 验证token合法性
     */
    public static DecodedJWT verify(String token) {
        String[] split_token = token.split(AuthServerConstant.AUTH_JWT_TOKEN_PREFIX, 2);
        System.out.println("print token as " + split_token[1]);


        return JWT.require(Algorithm.HMAC256(SING)).build().verify(split_token[1]);
    }
}
