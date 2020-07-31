package com.sk237.joong233.Controller;

import com.sk237.joong233.Model.*;
import com.sk237.joong233.Service.ContentService;
import com.sk237.joong233.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ContentService contentService;
    private final HttpSession session;

    @PostMapping(value = "signupRequest")
    public String joinRequest(@ModelAttribute(value = "userInfo") UserInfo userInfo) {

        String userId = userInfo.getUserId();
        String userPw = userInfo.getUserPw();
        String userName = userInfo.getUserName();

        return userService.joinUser(userId, userPw, userName);
    }

    @PostMapping(value = "loginRequest")
    public ModelAndView loginRequest(@ModelAttribute(value = "userInfo") UserInfo userInfo) {
        ModelAndView mav = new ModelAndView("index");
        //TODO null check with aop
        String userId = userInfo.getUserId();
        String userPw = userInfo.getUserPw();

        User user = userService.login(userId, userPw);
        List<Content> contents = contentService.showAll(user.getUserId());

        session.setAttribute("loginUser", user);
        mav.addObject("contentList", new ContentList(contents));
        return mav;
    }
}

