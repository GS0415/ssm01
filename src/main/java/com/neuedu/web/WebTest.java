package com.neuedu.web;

import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WebTest {
    @Autowired
    private IUserService service;

    @RequestMapping("/login.do")
    public String login() {
        return "login";
    }

    @RequestMapping("/dologin.do")
    public String doLogin(String userName, String passWord, HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(userName);
        User u = service.getOne(userName);
        System.out.println(u);
        if (u != null) {
            if (passWord.equals(u.getPassWord())) {
                Cookie cookie = new Cookie("name", userName);
                cookie.setMaxAge(60 * 60 * 24 * 7);
                resp.addCookie(cookie);
                HttpSession session = req.getSession();
                session.setAttribute("user", u);
                return "redirect:a.do";
            } else {
                return "login";
            }
        }else {
            return "login";
        }
    }

    @RequestMapping("/a.do")
    public String a(ModelMap map) {
        List<User> lists = service.getLists();

        map.put("lists", lists);
        return "a";
    }

    @RequestMapping("/update.do")
    public String update(int id, ModelMap maps) {
        System.out.println(id);
        User user = service.getUser(id);
        System.out.println(user);
        maps.put("user", user);
        return "update";
    }

    @RequestMapping("/doupdate.do")
    public String doUpdate(User user) {
        service.updateOne(user);
        return "redirect:a.do";
    }

    @RequestMapping("/delete.do")
    public String delete(User user) {
        service.delOne(user);
        return "redirect:a.do";
    }

    @RequestMapping("/add.do")
    public String add() {
        return "add";
    }

    @RequestMapping("/doadd.do")
    public String doAdd(User user) {
        service.insertOne(user);
        return "redirect:a.do";
    }
}
