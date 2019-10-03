package com.sk237.joong233.Service;

import com.sk237.joong233.Model.User;
import com.sk237.joong233.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ToDoService toDoService;

    @Autowired
    UserPasswordHash userPasswordHash;

    public void login(String userId, String userPw, HttpSession session) {

        if (userId.isEmpty() || userPw.isEmpty()) {
            return;
        }

        User user = userRepository.findByUserIdAndUserPw(userId, userPasswordHash.getSHA256(userPw));

        if (user == null) {
            return;
        }
        session.setAttribute("loginUser", user);
        session.setAttribute("contentList", toDoService.showAll(user.getUserId()));
    }

}
