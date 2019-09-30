package com.sk237.joong233.Controller;

import com.sk237.joong233.Service.LogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    private LogoutService logoutService;

    @Autowired
    HttpSession session;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("joinPage")
    public String joinPage() {
        return "join";
    }


    @RequestMapping("logout")
    public String logout() {
        return logoutService.logout(session);
    }



}
