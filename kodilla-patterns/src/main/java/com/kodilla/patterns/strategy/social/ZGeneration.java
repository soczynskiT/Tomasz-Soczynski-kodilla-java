package com.kodilla.patterns.strategy.social;

class ZGeneration extends User {

    ZGeneration(String name) {
        super(name);
        this.socialPublisher = new SnapchatPublisher();
    }
}
