package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "todos")
public class Todos extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    @Column(nullable = false)
    private String description;


    private boolean completed;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long userid;

    @OneToMany(mappedBy = "todos",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "todos", allowSetters = true)
    private List<Todos> todos = new ArrayList<>();

    public Todo()
    {
    }


    public Todos(
            long todoid,
            String description,
            boolean completed,
            long userid
    )
    {
        this. todoid = todoid;
        this.description = description;
        this.completed = completed;
        this.userid = userid;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTodoid() {
        return todoid;
    }

    public void setTodoid(long todoid) {
        this.todoid = todoid;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }


    public List<Todos> getTodos() { return todos; }

    public void setTodos(List<Todos> todos) { this.todos = todos; }
}
