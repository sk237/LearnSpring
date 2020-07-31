package com.sk237.joong233.Model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ContentList {
    List<Content> contents;

    public ContentList() {
        this.contents = new ArrayList<>();
    }

    public ContentList(List<Content> contents) {
        this.contents = new ArrayList<>(contents);
    }
}

