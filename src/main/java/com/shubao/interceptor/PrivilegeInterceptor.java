package com.shubao.interceptor;

import com.shubao.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PrivilegeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        //逻辑：判断用户是否登录，即判断session中是否存在user对象
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null){
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return false;
        }
        //放行，可以访问目标资源
        return true;
    }
}
