package com.todo.todoapp.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.todo.todoapp.Model.Todo;
import com.todo.todoapp.Repository.TodoRepository;

@Service
public class TodoService {

    private final TodoRepository repo;

    public TodoService(TodoRepository repo){
        this.repo = repo;
    }

    public Todo addTask(Todo todo) {
        repo.addTask(todo.getTitle(), todo.isCompleted());
        return todo;
    }

    public List<Todo> getAllTasks(){
        return repo.getAllTasks();
    }

    public int updateTask(int id , boolean completed){
        return repo.updateTask(id, completed);
    }

    public int deleteTasks(int id){
        return repo.deleteTasks(id);
    }
}
