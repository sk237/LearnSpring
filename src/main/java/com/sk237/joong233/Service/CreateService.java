package com.sk237.joong233.Service;

import com.sk237.joong233.Model.Content;
import com.sk237.joong233.Model.User;
import com.sk237.joong233.Repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class CreateService {

    @Autowired
    ContentRepository contentRepository;

    @Autowired
    HttpSession session;

    public String create(String content) {
        if (content.isEmpty()) {
            return "index";
        }
        Content con = new Content();
        User user = (User) session.getAttribute("loginUser");
        con.setContent(content);
        con.setUserId(user.getUserId());
        con.setDone(0);
        contentRepository.save(con);
        return "redirect:";
    }

}
