package com.sk237.joong233.Controller;

import com.sk237.joong233.Model.*;
import com.sk237.joong233.Service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;
    private final HttpSession session;

    @PostMapping("/createToDo")
    public String createToDo(@RequestParam Map<String, String> paraMap) {
        // todo need to fix for requestPara
        String content = paraMap.get("content");
        User user = (User) session.getAttribute("loginUser");
        return contentService.create(content, user.getUserId());

    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute(value = "contentList") ContentList updateContents) {

        // todo it doesnt work, need to check binding list in thymeleaf
        ModelAndView mav = new ModelAndView("index");
        List<Content> contents = new ArrayList<>(updateContents.getContents());
        contentService.update(contents);
        User user = (User) session.getAttribute("loginUser");
        List<Content> updatedContents = contentService.showAll(user.getUserId());
        mav.addObject("contentList", new ContentList(updatedContents));
        return mav;
    }


}
