package com.sk237.joong233.Controller;

import com.sk237.joong233.Service.JoinService;
import com.sk237.joong233.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private JoinService joinService;

    @Autowired
    private LoginService loginService;

    @Autowired
    HttpSession session;

    @PostMapping(value = "joinRequest")
    public String joinRequest(@RequestParam Map<String, String> paraMap) {

        String userId = paraMap.get("userId");
        String userPw = paraMap.get("userPw");
        String userName = paraMap.get("userName");
        String page = joinService.joinUser(userId, userPw, userName);

        return page;
    }

    @PostMapping(value = "loginRequest")
    public String loginRequest(@RequestParam Map<String, String> paraMap) {
        String userId = paraMap.get("userId");
        String userPw = paraMap.get("userPw");

        loginService.login(userId, userPw, session);

        return "index";
    }

}

