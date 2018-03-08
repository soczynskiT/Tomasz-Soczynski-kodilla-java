package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Bean(name = "toDoList")
    @Scope("prototype")
    public TaskList getToDoList() {
        return new TaskList();
    }

    @Bean(name = "inProgressList")
    @Scope("prototype")
    public TaskList getInProgressTaskList() {
        return new TaskList();
    }

    @Bean(name = "doneList")
    @Scope("singleton")
    public TaskList getDoneList() {
        return new TaskList();
    }

    @Bean
    public Board getBoard(){
        return new Board(getToDoList(), getInProgressTaskList(), getDoneList());
    }
}
