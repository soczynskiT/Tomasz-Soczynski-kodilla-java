package com.kodilla.hibernate.tasklist;

import com.kodilla.hibernate.task.Task;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TASKLISTS")
public class TaskList {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "LISTNAME")
    private String listName;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(targetEntity = Task.class,
            mappedBy = "taskList",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public List<Task> tasks = new ArrayList<>();

    public TaskList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    private TaskList() {
    }

    public Long getId() {
        return id;
    }

    public String getListName() {
        return listName;
    }

    public String getDescription() {
        return description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setListName(String listName) {
        this.listName = listName;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}