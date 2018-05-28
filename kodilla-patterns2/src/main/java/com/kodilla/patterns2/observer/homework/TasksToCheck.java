package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;


public class TasksToCheck implements Observable {
    private final List<Observer> mentors;
    private final List<String> taskToCheck;
    private final String name;

    public TasksToCheck(String name) {
        this.mentors = new ArrayList<>();
        this.taskToCheck = new ArrayList<>();
        this.name = name;
    }

    public void addTask(String task) {
        taskToCheck.add(task);
        informObservers();
    }

    @Override
    public void subscribeObserver(Observer mentor) {
        mentors.add(mentor);
    }

    @Override
    public void unsubscribeObserver(Observer mentor) {
        mentors.remove(mentor);
    }

    @Override
    public void informObservers() {
        for (Observer mentor : mentors) {
            mentor.update(this);
        }
    }

    public List<String> getTaskToCheck() {
        return taskToCheck;
    }

    public String getName() {
        return name;
    }
}
