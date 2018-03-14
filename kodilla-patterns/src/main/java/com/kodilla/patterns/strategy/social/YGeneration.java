package com.kodilla.patterns.strategy.social;

class YGeneration extends User {

    YGeneration(String name) {
        super(name);
        this.socialPublisher = new TweeterPublisher();
    }
}
