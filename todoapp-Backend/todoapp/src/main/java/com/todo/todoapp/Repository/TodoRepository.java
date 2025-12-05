package com.todo.todoapp.Repository;

import com.todo.todoapp.Model.Todo;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {
    private final JdbcTemplate jdbcTemplate;

    public TodoRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    // INSERT
    public int addTask(String title , boolean completed){
        String sql = "INSERT INTO tasks( title, completed) VALUES (?, ?)";
        return jdbcTemplate.update(sql, title, completed);
    }

    // SELECT
    public List<Todo> getAllTasks(){
        String sql = "SELECT * FROM tasks";
        return jdbcTemplate.query(sql, (rs, rowNum) -> 
            new Todo(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getBoolean("completed")
            )
        );
    }

    // UPDATE
    public int updateTask(int id, boolean completed){
        String sql = "UPDATE tasks SET completed = ? WHERE id = ?";
        return jdbcTemplate.update(sql, completed, id);
    }

    // DELETE
    public int deleteTasks(int id){
        String sql = "DELETE FROM tasks WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
