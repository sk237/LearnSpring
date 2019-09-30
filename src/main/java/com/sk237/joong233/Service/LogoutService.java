package com.sk237.joong233.Service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LogoutService {

    public String logout(HttpSession session) {
        session.removeAttribute("loginUser");
        return"index";
    }

}
