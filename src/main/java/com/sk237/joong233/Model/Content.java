package com.sk237.joong233.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "content")
@Setter
@Getter
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contentId")
    private long id;

    @Column(name = "content")
    private String content;

    @Column(name = "userId", columnDefinition = "text")
    private String userId;

    @Column (name = "done")
    private int done;

    @Column (name = "createdTime")
    private LocalDateTime createdTime;
}
