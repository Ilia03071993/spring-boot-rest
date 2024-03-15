package com.example.springbootrest.service;

import com.example.springbootrest.entity.User;
import com.example.springbootrest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User with id = %d not found".formatted(id)));
    }

    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void updateUserById(Integer id, User user) {
        User updatableUser = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User with id = %d not found".formatted(id)));
        updatableUser.setName(user.getName());
        updatableUser.setMessage(user.getMessage());
        userRepository.save(updatableUser);
    }

    @Transactional
    public void deleteUser(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new NoSuchElementException("User with id = %d not found".formatted(id));
        }
        userRepository.deleteById(id);
    }
}