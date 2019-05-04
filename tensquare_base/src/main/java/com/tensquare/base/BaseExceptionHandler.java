package com.tensquare.base;

import entity.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class BaseExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = Exception.class)
    public ResponseResult exception(Exception e, HttpServletRequest request) {
        logger.error(request.getRequestURI());
        logger.error(e.toString(), e);
        return ResponseResult.FAILED("请求地址: "+ request.getRequestURI() + "      异常信息: " + e.getMessage());
    }

}
