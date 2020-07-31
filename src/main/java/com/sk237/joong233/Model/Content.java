package com.sk237.joong233.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String content;
    private String userId;
    private boolean done;
    private boolean deleted;
    private LocalDateTime createdTime;

    public boolean updateDone() {
        done = !done;
        return done;
    }

    public boolean deleteContent() {
        deleted = false;
        return false;
    }
}

