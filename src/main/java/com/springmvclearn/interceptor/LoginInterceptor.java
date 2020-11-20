package com.springmvclearn.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 自定义登录拦截器
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        if (!(url.contains("Login") || url.contains("login") || url.contains("register"))) {
            if (request.getSession().getAttribute("user") != null) {
                return true;
            }else {
                if ((url.contains("css") || url.contains("js") || url.contains("images"))) {
                    return true;
                }else {
                    response.sendRedirect(request.getContextPath()+ "/user/toLogin.action");
                }

            }
        } else {
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
