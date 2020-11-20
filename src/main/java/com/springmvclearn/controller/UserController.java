package com.springmvclearn.controller;

import com.springmvclearn.entity.User;
import com.springmvclearn.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController extends BaseController {

    @Resource
    UserService userService;

    // 跳转到登录界面
    @RequestMapping("/user/toLogin.action")
    public String toLogin() {
        return "/pages/login.jsp";
    }

    // 列表
    @RequestMapping("/user/login.action")
    public String login(User user, Model model, HttpServletRequest request) {
        Map<String, String> map  = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("password", user.getPassword());
        List<User> userList = userService.find(map);
        if (userList!=null && userList.size()>0) {
            request.getSession().setAttribute("user", userList.get(0));
            return "/home.jsp";
        }
        model.addAttribute("errorMsg", "登录失败！账号或者密码错误！");
        return "/login.jsp";
    }



}
