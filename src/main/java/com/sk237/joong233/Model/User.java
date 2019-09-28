package com.sk237.joong233.Model;

import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userId;
    private String userPw;
    private String userName;
}
