package com.lucasgusmao.todosimple.services;

import com.lucasgusmao.todosimple.models.user.User;
import com.lucasgusmao.todosimple.repositories.TaskRepository;
import com.lucasgusmao.todosimple.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private TaskRepository taskService;

    public UserService(UserRepository userRepository, TaskRepository taskService) {
        this.userRepository = userRepository;
        this.taskService = taskService;
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow( ()-> new RuntimeException("Usuário com id " + id + " não encontrado"));
    }

    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(User user) {
        User newUser = findById(user.getId());
        newUser.setPassword(user.getPassword());
        return userRepository.save(newUser);
    }

    public void deleteUser(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }

}
