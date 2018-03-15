package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {
    private final String taskName;
    private final String where;
    private final String using;
    private boolean isTaskExecuted;

    DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
        this.isTaskExecuted = false;
    }

    @Override
    public void executeTask() {
        System.out.println("[Executing driving task]\n" +
                "Task name - " + getTaskName() + "\n" +
                "Driving to " + where + " using " + using);
        setTaskStatusExecuted();
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return isTaskExecuted;
    }

    private void setTaskStatusExecuted() {
        this.isTaskExecuted = true;
    }
}
