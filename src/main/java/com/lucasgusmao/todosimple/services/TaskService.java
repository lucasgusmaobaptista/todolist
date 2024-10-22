package com.lucasgusmao.todosimple.services;

import com.lucasgusmao.todosimple.models.Task;
import com.lucasgusmao.todosimple.models.user.User;
import com.lucasgusmao.todosimple.repositories.TaskRepository;
import com.lucasgusmao.todosimple.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskService {

    private final UserService userService;
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa com id " + id + " não encontrada"));
    }

    @Transactional
    public Task createTask(Task task) {
        User user = userService.findById(task.getUser().getId());
        task.setId(null);
        return taskRepository.save(task);
    }

    @Transactional
    public Task updateTask(Task task) {
        Task newTask = findById(task.getId());
        newTask.setDescription(task.getDescription());
        return taskRepository.save(newTask);
    }

    public void deleteTask(Long id) {
        Task task = findById(id);
        taskRepository.delete(task);
    }
}
