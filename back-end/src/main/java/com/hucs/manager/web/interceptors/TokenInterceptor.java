package com.hucs.manager.web.interceptors;

import com.hucs.manager.web.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Log
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("validando token");
        String token = request.getHeader("Authorization");
        if (token == null || !JwtUtil.isValidToken(token)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized
            response.getWriter().write("Missing or invalid token");
            return false;
        }

        HttpSession session = request.getSession();
        session.setAttribute("username", JwtUtil.getUsernameFromToken(token));
        return true;
    }


}
