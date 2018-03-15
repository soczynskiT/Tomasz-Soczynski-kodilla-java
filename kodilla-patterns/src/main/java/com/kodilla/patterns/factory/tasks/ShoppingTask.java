package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private boolean isTaskExecuted;

    ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
        this.isTaskExecuted = false;
    }

    @Override
    public void executeTask() {
        System.out.println("[Executing shopping task]\n" +
                "Task name - " + getTaskName() + "\n" +
                "Buying " + quantity + " items of " + whatToBuy);
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
