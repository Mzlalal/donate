package com.mzlalal.donate.controller.advice;

import com.mzlalal.donate.model.comm.Results;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Collectors;

/**
 * @description:
 * @author: Mzlalal
 * @date: 2019/12/26 17:45
 * @version: 1.0
 */
@ControllerAdvice
public class WebExceptionHandler {
    /**
     * 使用@Valid 验证路径中请求实体校验失败后抛出的异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler
    public Results BindExceptionHandler(BindException e) {
        // 获取消息并返回
        String message = e.getBindingResult()
                .getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining());
        return Results.FAIL(message);
    }
}
