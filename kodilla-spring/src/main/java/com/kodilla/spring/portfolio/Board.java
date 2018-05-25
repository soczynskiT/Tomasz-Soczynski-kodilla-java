package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Board {

    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public Board(final TaskList toDoList, final TaskList inProgressList, final TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public void addToDoTask(String task) {
        toDoList.addTask(task);
    }

    public void addInProgressTask(String task) {
        inProgressList.addTask(task);
    }

    public void addDoneTask(String task) {
        doneList.addTask(task);
    }

    public List<TaskList> getAllTasks() {
        return new ArrayList<>(Arrays.asList(toDoList, inProgressList, doneList));
    }
}
