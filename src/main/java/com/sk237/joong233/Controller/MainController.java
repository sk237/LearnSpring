package com.sk237.joong233.Controller;

import com.sk237.joong233.Model.User;
import com.sk237.joong233.Service.LogoutService;
import com.sk237.joong233.Service.ToDoService;
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

    @Autowired
    private ToDoService toDoService;

    @RequestMapping("/")
    public String index() {
        User user = (User) session.getAttribute("loginUser");
        if (user != null) {
            session.setAttribute("contentList", toDoService.showAll(user.getUserId()));
        }
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
