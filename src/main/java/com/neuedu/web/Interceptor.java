package com.neuedu.web;

import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.UserServiceImpl;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class Interceptor implements HandlerInterceptor {
    private IUserService service = new UserServiceImpl();
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object o) throws Exception {
        Cookie[] cookies = req.getCookies();
        Map<String, Cookie> map = getCookie(cookies);
        Cookie cookie = map.get("name");
        if (cookie == null) {
            resp.sendRedirect("login.do");
        }else {
           /* String userName = cookie.getValue();
            System.out.println(userName);

            User user = service.getOne(userName);
            System.out.println(user);
            HttpSession session = req.getSession();
            session.setAttribute("user",user);*/
           return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }





    public static Map<String, Cookie> getCookie(Cookie[] cookies) {
        Map<String, Cookie> map = new HashMap<>();
        if (cookies != null) {
            for (Cookie cookie : cookies
            ) {
                map.put(cookie.getName(), cookie);
            }
        }
        return map;
    }
}
