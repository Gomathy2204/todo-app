package com.todo.todoapp.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.todo.todoapp.Model.Todo;
import com.todo.todoapp.Service.TodoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/tasks")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service){
        this.service = service;
    }

    // CREATE TASK
    @PostMapping("")
    public Todo addTask(@RequestBody Todo todo) {
        return service.addTask(todo);
    }

    // GET ALL TASKS
    @GetMapping("")
    public List<Todo> getAllTasks() {
        return service.getAllTasks();
    }

    // UPDATE TASK STATUS
    @PutMapping("/{id}")
    public String updateTask(@PathVariable int id, @RequestBody Todo todo) {
        service.updateTask(id, todo.isCompleted());
        return "Task Updated!";
    }

    // DELETE TASK
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id){
        service.deleteTasks(id);
        return "Task Deleted!";
    }
}
