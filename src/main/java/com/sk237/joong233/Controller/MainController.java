package com.sk237.joong233.Controller;

import com.sk237.joong233.Model.*;
import com.sk237.joong233.Service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ContentService contentService;
    private final HttpSession session;

    @RequestMapping("/")
    public ModelAndView index() {
        // todo need to use aop or filter to verify the login user
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("userInfo", new UserInfo());

        User user = (User) session.getAttribute("loginUser");
        if (user != null) {
            List<Content> contents = contentService.showAll(user.getUserId());
            mav.addObject("contentList", new ContentList(contents));
        }

        return mav;
    }



    @RequestMapping("signupPage")
    public ModelAndView joinPage() {
        ModelAndView mav = new ModelAndView("signup");
        mav.addObject("userInfo", new UserInfo());
        mav.addObject("userInfo", new UserInfo());
        return mav;
    }


    @RequestMapping("logout")
    public ModelAndView logout() {
        session.removeAttribute("loginUser");
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("userInfo", new UserInfo());
        return mav;
    }
}
