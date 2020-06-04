package com.stone.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import sun.security.provider.certpath.OCSPResponse;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionControllerHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionrHandler(HttpServletRequest request, Exception e) throws Exception {
        logger.error("Requset URL : {}, Exception: {}", request.getRequestURL(), e);
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.addObject("exception", e);
        modelAndView.setViewName("error/error");
        return modelAndView;
    }
}
