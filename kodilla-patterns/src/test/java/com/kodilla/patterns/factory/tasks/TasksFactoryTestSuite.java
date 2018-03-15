package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TasksFactoryTestSuite {
    private static final TaskFactory TASK_FACTORY = new TaskFactory();

    @Test
    public void testCreateShoppingTask() {
        //Given
        //When
        Task shoppingTask = TASK_FACTORY.createTask(TaskFactory.SHOPPING);
        shoppingTask.executeTask();
        //Then
        Assert.assertEquals("buying specific product", shoppingTask.getTaskName());
        Assert.assertTrue(shoppingTask.isTaskExecuted());
    }

    @Test
    public void testCreatePaintingTask() {
        //Given
        //When
        Task paintingTask = TASK_FACTORY.createTask(TaskFactory.PAINTING);
        paintingTask.executeTask();
        //Then
        Assert.assertEquals("painting", paintingTask.getTaskName());
        Assert.assertTrue(paintingTask.isTaskExecuted());
    }

    @Test
    public void testCreateDrivingTask() {
        //Given
        //When
        Task drivingTask = TASK_FACTORY.createTask(TaskFactory.DRIVING);
        drivingTask.executeTask();
        //Then
        Assert.assertEquals("driving from A to B", drivingTask.getTaskName());
        Assert.assertTrue(drivingTask.isTaskExecuted());
    }
}
