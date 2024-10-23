package com.hucs.manager.web.interceptors;

import com.hucs.manager.core.config.NegocioException;
import com.hucs.manager.web.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerInterceptor;

@Log
@ControllerAdvice
public class ErrorInterceptor implements HandlerInterceptor {

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<StandardError> negocioExceptionErrorHandler(NegocioException e, HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }


}
