package com.kodilla.patterns.strategy.social;

class Millenials extends User {

    Millenials(String name) {
        super(name);
        this.socialPublisher = new FacebookPublisher();
    }
}
