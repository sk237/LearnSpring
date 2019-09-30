package com.sk237.joong233.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ContentController {

    @PostMapping("/createToDo")
    public String createToDo(@RequestParam Map<String, String> paraMap) {
        String content = paraMap.get("content");


        return "index";
    }

}
