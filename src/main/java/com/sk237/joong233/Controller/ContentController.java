package com.sk237.joong233.Controller;

import com.sk237.joong233.Model.Content;
import com.sk237.joong233.Model.User;
import com.sk237.joong233.Repository.ContentRepository;
import com.sk237.joong233.Service.CreateService;
import com.sk237.joong233.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ContentController {

    @Autowired
    private CreateService createService;

    @Autowired
    HttpSession session;

    @Autowired
    ContentRepository contentRepository;

    @Autowired
    ToDoService toDoService;

    @PostMapping("/createToDo")
    public String createToDo(@RequestParam Map<String, String> paraMap) {

        String content = paraMap.get("content");
        return createService.create(content);

    }

    @RequestMapping("done/{idx}")
    public String done(@PathVariable long idx) {
        Content content = contentRepository.getOne(idx);
        content.setDone(1);
        contentRepository.save(content);
        User user = (User) session.getAttribute("loginUser");
        session.setAttribute("contentList", toDoService.showAll(user.getUserId()));
        return "index";
    }

    @RequestMapping("/deleteToDo/{idx}")
    public String deleteToDo(@PathVariable long idx) {
        contentRepository.deleteById(idx);
        User user = (User) session.getAttribute("loginUser");
        session.setAttribute("contentList", toDoService.showAll(user.getUserId()));
        return "index";
    }
}
