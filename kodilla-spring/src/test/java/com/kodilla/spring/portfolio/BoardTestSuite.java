package com.kodilla.spring.portfolio;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        final String toDoTask = "Some task still to do.";
        final String inProgressTask = "Some task still in progress";
        final String doneTask = "This task has been done";

        Board board = (Board)context.getBean("getBoard");

        //When
        board.addToDoTask(toDoTask);
        board.addInProgressTask(inProgressTask);
        board.addDoneTask(doneTask);
        //Then
        board.getAllTasks().stream()
                .flatMap(s-> s.getTasks().stream())
                .forEach(System.out::println);
    }
}
