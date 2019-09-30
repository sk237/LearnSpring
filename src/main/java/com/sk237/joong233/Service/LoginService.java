package com.sk237.joong233.Service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginService {


    public void login(String userId, String userPw, HttpSession session) {

        session.setAttribute("loginUser", userId);
    }

}
