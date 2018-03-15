package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task createTask(final String taskClassTaskName) {
        switch (taskClassTaskName) {
            case SHOPPING:
                return new ShoppingTask("buying specific product", "cellphone", 1);
            case PAINTING:
                return new PaintingTask("painting", "red", "only walls");
            case DRIVING:
                return new DrivingTask("driving from A to B", "shopping mall", "bus");
            default:
                return null;
        }
    }
}
