package com.vuetutorial.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vuetutorial.utils.JwtUtils;
import com.vuetutorial.entity.result.Result;
import com.vuetutorial.entity.result.ResultEnum;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Map<String, Object> map = new HashMap<>();
        //令牌建议是放在请求头中，获取请求头中令牌
        String token = request.getHeader("token");

        Claims claims = JwtUtils.parseJwt(token, 1000L);//验证令牌
        if (claims != null) {
            return true;//放行请求
        } else {
            Result<Object> result = new Result<>(ResultEnum.NO_PERMISSION, null);
            //将map转化成json，response使用的是Jackson
            String json = new ObjectMapper().writeValueAsString(result);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().print(json);
            return false;
        }
    }
}
