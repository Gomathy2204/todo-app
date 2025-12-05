package com.todo.todoapp.Model;

public class Todo {
    private int id;
    private String title;
    private boolean completed;

    // Default constructor required by Spring
    public Todo() {}

    public Todo(int id, String title, boolean completed){
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
