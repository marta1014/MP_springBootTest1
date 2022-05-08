package com.demobatis.util;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdvice {
    @ExceptionHandler
    public ResponseFormat ErrorAdvices(Exception e) {
        e.printStackTrace();
       return new ResponseFormat("999999","应用系统错误,稍后再试");
    }
}
