package com.kodilla.hibernate.tasklist;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TASKLISTS")
public class TaskList {
    private long id;
    private String listName;
    private String description;

    public TaskList(String listName, String description) {
        this.id = id;
        this.listName = listName;
        this.description = description;
    }

    private TaskList() {
    }

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    public long getId() {
        return id;
    }

    @NotNull
    @Column(name = "LISTNAME")
    public String getListName() {
        return listName;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setId(long id) {
        this.id = id;
    }

    private void setListName(String listName) {
        this.listName = listName;
    }
}
