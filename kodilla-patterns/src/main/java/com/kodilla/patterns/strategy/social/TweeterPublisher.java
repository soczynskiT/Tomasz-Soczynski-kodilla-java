package com.kodilla.patterns.strategy.social;

public class TweeterPublisher implements SocialPublisher {

    @Override
    public String share() {

        return "Tweeter";
    }
}
