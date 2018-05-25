package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {
    private final String taskName;
    private final String color;
    private final String whatToPaint;
    private boolean isTaskExecuted;

    PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
        this.isTaskExecuted = false;
    }

    @Override
    public void executeTask() {
        System.out.println("[Executing painting task]\n" +
                "Task name - " + getTaskName() + "\n" +
                "Painting " + whatToPaint + " in " + color + " color.");
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
