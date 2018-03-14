package com.kodilla.patterns.strategy.social;

public class User {
    final private String name;
    SocialPublisher socialPublisher;

    User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }

    public String sharePost() {
        return socialPublisher.share();
    }
}
