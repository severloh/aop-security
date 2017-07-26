package com.example.demo.interceptor;

import com.example.demo.annotation.Access;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义一个权限拦截器，继承HandlerInterceptorAdapter
 * <p>
 * Created by silvester on 2017/7/26.
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
    //在调用方法之前执行拦截

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行拦截器1");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        //从方法处理器中获取要调用的方法
        Method method = handlerMethod.getMethod();
        //获取出方法上的注解
        Access access = method.getAnnotation(Access.class);
        if (access == null) {
            //如果为null，说明不需要拦截，直接放过
            return true;
        }
        if (access.authorities().length > 0) {
            //如果权限配置不为空，则取出配置值
            String[] authorities = access.authorities();
            Set<String> authset = new HashSet<>();
            for (String authority : authorities) {
                //将权限放入一个set集合中
                authset.add(authority);
            }

            String role = request.getParameter("role");
            if (StringUtils.isEmpty(role)) {
                if (authset.contains(role)) {
                    System.out.println("通过权限验证");
                    return true;
                }
            }
        }
        System.out.println("权限验证失败！");
        response.setStatus(401);
        return false;
    }
}
