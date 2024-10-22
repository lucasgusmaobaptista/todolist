package com.lucasgusmao.todosimple.controller;

import com.lucasgusmao.todosimple.models.Task;
import com.lucasgusmao.todosimple.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
@Validated
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<Task> createTask(Task task) {
        taskService.createTask(task);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Task> updateTask(Task task) {
        taskService.updateTask(task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }

}
