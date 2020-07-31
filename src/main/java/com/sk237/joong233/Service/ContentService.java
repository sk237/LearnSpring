package com.sk237.joong233.Service;

import com.sk237.joong233.Model.Content;
import com.sk237.joong233.Model.Status;
import com.sk237.joong233.Model.StatusList;
import com.sk237.joong233.Repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;

    public String create(String content, String userId) {
        if (content.isEmpty()) {
            return "index";
        }

        Content con = Content.builder()
                .content(content)
                .userId(userId)
                .done(false)
                .deleted(false)
                .createdTime(LocalDateTime.now())
                .build();

        contentRepository.save(con);
        return "redirect:";
    }

    public void update(List<Content> contents) {
        for (Content c : contents) {
            contentRepository.save(c);
        }
    }

    public List<Content> showAll(String userId) {
        List<Content> contentList = contentRepository.findAllByUserIdOrderByCreatedTime(userId);
        contentList.removeIf(c -> c.isDeleted());
        return contentList;
    }
}
