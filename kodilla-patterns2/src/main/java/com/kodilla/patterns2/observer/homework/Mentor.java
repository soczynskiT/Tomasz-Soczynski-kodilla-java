package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String name;
    private int newTasksToCheckCount;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(TasksToCheck tasksToCheck) {
        System.out.println(name + ": New task to check in " + tasksToCheck.getName());
        newTasksToCheckCount++;
    }

    int getNewTasksToCheckCount() {
        return newTasksToCheckCount;
    }
}
