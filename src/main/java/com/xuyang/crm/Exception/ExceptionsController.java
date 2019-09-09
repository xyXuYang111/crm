package com.xuyang.crm.Exception;

import com.xuyang.crm.util.ContextUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
        //是ajax请求
        if (ContextUtil.isAjaxRequest(request)) {
            return GeneralMessage.error("系统错误，请联系管理员。");
        }else {
            ModelAndView modelView = new ModelAndView();
            modelView.addObject("failMsg", "系统错误，请联系管理员。");
            modelView.setViewName(ERROR);
            return modelView;
        }
    }

    /**
     * 自定义异常
     * @param exception
     * @return
     */
    @ResponseBody
    @ExceptionHandler(SgException.class)
    public Object exceptionHandler(HttpServletRequest request, SgException exception){
        //是ajax请求
        if (ContextUtil.isAjaxRequest(request)) {
            return GeneralMessage.error(exception.getMessage());
        }else {
            ModelAndView modelView = new ModelAndView();
            modelView.addObject("failMsg", exception.getMessage());
            modelView.setViewName(FAIL);
            return modelView;
        }
    }
}
