package com.biyesheji.cims.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 贫困户新增，户籍id不存在的异常处理
 */
@ControllerAdvice
public class SQLExcHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public String handleSQLExc(HttpServletRequest request){

        request.setAttribute("javax.servlet.error.status_code",501);
        return "forward:/error";
    }
}
