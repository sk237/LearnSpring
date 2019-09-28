package com.sk237.joong233.Service;

import com.sk237.joong233.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPasswordHash userPasswordHash;

    @Autowired
    HttpSession session;

    public String login(String userId, String userPw) {
        if (userId.isEmpty() || userPw.isEmpty()) {
            return "login";
        }
        session.setAttribute("loginUser", userId);

        return "index";
    }

}
