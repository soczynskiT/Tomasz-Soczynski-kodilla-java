package com.kodilla.spring.forum;

import org.springframework.stereotype.Component;

@Component
public class ForumUser {

    final private String name;

    public ForumUser() {
        this.name = "Jhon Smith";
    }

    public String getName() {
        return name;
    }
}
