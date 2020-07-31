package com.sk237.joong233.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StatusList {
    List<Status> statuses;

    public StatusList() {
        this.statuses = new ArrayList<>();
    }
    public StatusList(List<Status> statuses) {
        this.statuses = statuses;
    }
}
