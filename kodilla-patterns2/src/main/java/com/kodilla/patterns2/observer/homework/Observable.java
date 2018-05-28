package com.kodilla.patterns2.observer.homework;

public interface Observable {
    void subscribeObserver(Observer observer);
    void unsubscribeObserver(Observer observer);
    void informObservers();
}
