package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class MentorTestSuite {
    @Test
    public void testUpdate() {
        //Given
        final TasksToCheck javaTasks = new JavaTasksToCheck();
        final TasksToCheck nodeTasks = new NodeTasksToCheck();
        final Observer javaMentor = new Mentor("Java mentor");
        final Observer nodeMentor = new Mentor("Node mentor");
        javaTasks.subscribeObserver(javaMentor);
        nodeTasks.subscribeObserver(nodeMentor);
        //When
        javaTasks.addTask("First Java task");
        javaTasks.addTask("Second Java task");
        javaTasks.addTask("Third Java task");
        nodeTasks.addTask("First and last Node task");
        //Then
        assertEquals(3, ((Mentor) javaMentor).getNewTasksToCheckCount());
        assertEquals(1, ((Mentor) nodeMentor).getNewTasksToCheckCount());
    }
}