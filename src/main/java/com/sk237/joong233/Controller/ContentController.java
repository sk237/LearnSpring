package com.sk237.joong233.Controller;

import com.sk237.joong233.Model.Content;
import com.sk237.joong233.Model.User;
import com.sk237.joong233.Repository.ContentRepository;
import com.sk237.joong233.Service.CreateService;
import com.sk237.joong233.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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

    @PostMapping("/update")
    public String update(HttpServletRequest request) {
        String[] idDone = request.getParameterValues("doneBox");
        String[] idDelete = request.getParameterValues("deleteBox");
        if (idDone != null && idDone.length > 0) {
            for (String id : idDone) {
                Content content = contentRepository.getOne(Long.parseLong(id));
                content.setDone((1 + content.getDone()) % 2);
                contentRepository.save(content);
            }
        }
        if (idDelete != null && idDelete.length > 0) {
            for (String idCode : idDelete) {
                long id = Long.parseLong(idCode);
                contentRepository.deleteById(id);
            }
        }

        User user = (User) session.getAttribute("loginUser");
        session.setAttribute("contentList", toDoService.showAll(user.getUserId()));
        return "index";
    }
}
