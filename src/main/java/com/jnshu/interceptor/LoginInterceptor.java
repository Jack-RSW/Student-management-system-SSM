package com.jnshu.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//登陆拦截器
public class LoginInterceptor implements HandlerInterceptor {
       private static Logger logger = LoggerFactory.getLogger(HandlerInterceptor.class);

    //执行Handler方法之前执行
    //用于身份认证、身份授权
    //比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取请求的url
        String url = request.getRequestURI();

        //判断url是否是公开地址(实际使用时将公开地址配置到配置文件中)
        //可以导入一个配置文件,匹配其中的请求
        System.out.println("login索引是："+url.indexOf("login"));
        if (url.indexOf("login")>0){
            return true;
        }

        //判断session
        HttpSession session = request.getSession();
        //从session中取出用户信息
        String username = (String) session.getAttribute("username");
        if (username!=null){
            //用户存在放行
            System.out.println("用户放行————————————————————————————————————");
            return true;
        }
        String test = "密码错误";
        //执行到这里标识用户身份需要认证,跳转到登陆界面
        //跳转网址需要绝对路径,将当前请求重新映射到/WEB-INF/jsp/login.jsp,
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        logger.info("用户身份需要认证,跳转至登陆页面,执行Handler方法之前执行");

        return false;
    }

    //进入Handler方法之后，返回modelAndView之前执行
    //应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里
    //传到视图，也可以在这里统一指定视图
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("LoginInterceptor postHandle 拦截器执行了,进入Handler方法之后，返回modelAndView之前执行");
    }

    //执行Handler完成执行此方法
    //应用场景：统一异常处理，统一日志处理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("afterCompletion 拦截器执行了,Handler运行完成后执行此方法");
    }
}
