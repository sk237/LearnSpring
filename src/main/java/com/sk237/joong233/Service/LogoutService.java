package com.sk237.joong233.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LogoutService {

    @Autowired
    HttpSession session;

    public String logout() {
        session.removeAttribute("loginUser");
        return"index";
    }

}
