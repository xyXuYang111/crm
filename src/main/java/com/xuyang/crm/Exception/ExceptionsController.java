package com.xuyang.crm.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: cypc
 * @Date: 2019/9/9 20:30
 * @Description:
 */
public class ExceptionsController {

    /**
     * 全局异常
     * @param exception
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(HttpServletRequest request, Exception exception){
       return null;
    }
}
