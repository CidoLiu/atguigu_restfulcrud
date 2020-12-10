package com.cido.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.print.DocFlavor;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

//    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @PostMapping(value = "/user/login") // 与上述注释同效
    public String login(@RequestParam("username") String username, // 参数名对应form表单的input控件的name
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session) {
        // 登陆校验
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("loginUser",username);
            // 登陆成功后，防止刷新页面表单重复提交，可以重定向到主页
            return "redirect:/main";
        } else {
            map.put("msg", "用户名密码错误");
            return "login";
        }
    }
}
