package com.kodilla.spring.forum;

import org.springframework.stereotype.Component;

@Component
public class ForumUser {

    private final String name;

    public ForumUser() {
        this.name = "Jhon Smith";
    }

    public String getName() {
        return name;
    }
}
