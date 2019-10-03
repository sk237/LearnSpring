package com.sk237.joong233.Service;

import com.sk237.joong233.Model.Content;
import com.sk237.joong233.Model.User;
import com.sk237.joong233.Repository.ContentRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    HttpSession session;
    public List<Content> showAll(String userId) {
        List<Content> list = contentRepository.findAllByUserId(userId);
        return list;
    }

}
