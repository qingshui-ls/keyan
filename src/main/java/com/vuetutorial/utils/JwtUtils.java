package com.vuetutorial.utils;

import com.vuetutorial.entity.Token;
import com.vuetutorial.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JwtUtils {


//    JWT token签名签名密钥长度至少32位
    private static final String JWT_SIGN_KEY = "keyanguanli_jwt_token_json_sign_key";

    private static final String BASE64_SECURITY = Base64.getEncoder().encodeToString(JWT_SIGN_KEY.getBytes(StandardCharsets.UTF_8));

    public static Token createJwt(Map<String, String> user, long expire) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        //生成签名密钥
        byte[] apiKeySecretBytes = Base64.getDecoder().decode(BASE64_SECURITY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //添加JWT的类
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JsonWebToken");

        //设置参数到jwt
        user.forEach(builder::claim);

        //Token过期时间
        long expMillis = nowMillis + expire * 1000;
        Date exp = new Date(expMillis);
        builder.setIssuedAt(now).setNotBefore(now).setExpiration(exp).signWith(signingKey, signatureAlgorithm);

        //组装Token信息
        Token tokenInfo = new Token();
        tokenInfo.setToken(builder.compact());
        tokenInfo.setExpire(expire);
        tokenInfo.setExpiration(localDateTime(exp));
        return tokenInfo;
    }

    /**
     * Date转换为LocalDateTime
     *
     * @param date 日期
     */


    public static LocalDateTime localDateTime(Date date) {
        if (date == null) {
            return LocalDateTime.now();
        }
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }


    /***
     *
     @Description:获取Claims
     @Param:
     @Date:8/27/22*/


    public static Claims getClaims(String token, long allowedClockSkewSeconds) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        return parseJwt(token, allowedClockSkewSeconds);
    }


    public static Claims parseJwt(String jsonWebToken, long allowedClockSkewSeconds) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(Base64.getDecoder().decode(BASE64_SECURITY))
                    .setAllowedClockSkewSeconds(allowedClockSkewSeconds)
                    .build()
                    .parseClaimsJws(jsonWebToken)
                    .getBody();
        } catch (ExpiredJwtException ex) {
            log.error("token过期", ex);
            //过期
            //抛异常 让系统捕获到返回到前端
        } catch (SignatureException ex) {
            log.error("签名错误", ex);
            //签名错误
            //抛异常 让系统捕获到返回到前端
        } catch (IllegalArgumentException ex) {
            log.error("token为空", ex);
            //token 为空
            //抛异常 让系统捕获到返回到前端
        } catch (Exception e) {
            log.error("解析token异常", e);
            //抛异常 让系统捕获到返回到前端
        }
        return null;
    }

    public static Token createJwt(User user, long expire) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        //生成签名密钥
        byte[] apiKeySecretBytes = Base64.getDecoder().decode(BASE64_SECURITY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //添加JWT的类
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JsonWebToken");

        //设置参数到jwt
        builder.claim("username", user.getUsername());
        builder.claim("password", user.getPassword());

        //Token过期时间
        long expMillis = nowMillis + expire * 1000;
        Date exp = new Date(expMillis);
        builder.setIssuedAt(now).setNotBefore(now).setExpiration(exp).signWith(signingKey, signatureAlgorithm);

        //组装Token信息
        Token tokenInfo = new Token();
        tokenInfo.setToken(builder.compact());
        tokenInfo.setExpire(expire);
        tokenInfo.setExpiration(localDateTime(exp));
        return tokenInfo;
    }

    public static void main(String[] args) {
        Map<String, String> param = new HashMap<>();
        param.put("username", "admin");
        param.put("password", "123456");

        Token token = JwtUtils.createJwt(param, 100000L);

        System.out.println("token：" + token.getToken());
        System.out.println("token的有效期：" + token.getExpire());
        System.out.println("token过期时间：" + token.getExpiration());


        Claims claims = JwtUtils.parseJwt("eyJ0eXAiOiJKc29uV2ViVG9rZW4iLCJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsInVzZXJuYW1lIjoiYWRtaW4iLCJpYXQiOjE2ODY5MTgwMjMsIm5iZiI6MTY4NjkxODAyMywiZXhwIjoxNjg3MDE4MDIzfQ.XyZyGa6sAULoPECCIzB63eiY0TL5fPjz--EFVKMbKF", 60L);

        System.out.println(claims);
        System.out.println("从token中获取的userId：" + claims.get("userId"));
        System.out.println("从token中获取userName：" + claims.get("userName"));

    }

}
