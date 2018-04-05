package com.kodilla.hibernate.task;

import com.kodilla.hibernate.tasklist.TaskList;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "TASKS")
public final class Task {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @Column(name = "CREATED")
    private Date created;

    @Column(name = "DURATION")
    private int duration;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TASK_FINANCIALS_DETAILS")
    private TaskFinancialDetails taskFinancialDetails;

    @ManyToOne
    @JoinColumn(name = "TASKLIST_ID")
    private TaskList taskList;

    private Task() {
    }

    public Task(final String description, final int duration) {
        this.description = description;
        this.created = new Date();
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreated() {
        return created;
    }

    public int getDuration() {
        return duration;
    }

    public TaskFinancialDetails getTaskFinancialDetails() {
        return taskFinancialDetails;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setCreated(Date created) {
        this.created = created;
    }

    private void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTaskFinancialDetails(TaskFinancialDetails taskFinancialDetails) {
        this.taskFinancialDetails = taskFinancialDetails;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }
}