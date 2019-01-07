package com.neuedu.web;

import com.neuedu.dao.UserDao;
import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WebTest {
    @Autowired
    private IUserService service;
    @RequestMapping("/a.do")
    public String a(ModelMap map){
        List<User> lists=service.getLists();
        map.put("lists",lists);
        return "a";
    }
}
