package com.jnshu.exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.alibaba.fastjson.support.spring.annotation.FastJsonView;
import org.springframework.core.Ordered;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/*全局异常处理器*/
/*
* 只要实现了HandlerExceptionResolver
* */
public class StudentExceptionResolver implements HandlerExceptionResolver, Ordered {

//    private static final Logger Log = Logger.getLogger(StudentExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        StudentException studentException = null;
        if(e instanceof StudentException){
            studentException = (StudentException) e;
        }else if (e instanceof HttpMessageNotReadableException){
            studentException = new StudentException("参数异常");
        }else {
            studentException = new StudentException("未知错误");
        }
        ModelAndView mv = new ModelAndView();
        /* 使用FastJson提供的FastJsonJsonView视图返回，不需要捕获异常 */
        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("code","1000001");
        attributes.put("msg",studentException.getMessage());

        view.setAttributesMap(attributes);
        mv.setView(view);


        return mv;
    }

    /**
     * 异常处理先后顺序.
     *
     * @see org.springframework.core.Ordered#getOrder()
     * 由于SpringMVC默认异常处理机制，如不配置自定义全局异常处理器，则会依次执行如下异常处理器
     *
     * 0 org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver,
     * 1 org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver,
     * 2 org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver
     */

    @Override
    public int getOrder() {
        return 2;
    }
}
