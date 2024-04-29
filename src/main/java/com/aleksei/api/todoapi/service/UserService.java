package com.aleksei.api.todoapi.service;

import com.aleksei.api.todoapi.dto.TodoUserDto;
import com.aleksei.api.todoapi.entity.TodoUser;
import com.aleksei.api.todoapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<TodoUserDto> getAllUsers() {
        var userList = userRepository.findAll();
        return userList.stream()
                .map(TodoUserDto::from)
                .toList();
    }

    public TodoUser getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }


//    @Transactional
//    public void create(TodoUser user) {
//        userRepository.save(user);
//    }
//
//
//    @Transactional
//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//    }
//
//    @Transactional
//    public void update(Long id, TodoUser updatedUser) {
//        var existingClient = userRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Client with id " + id + " not found"));
//        existingClient.setFullName(updatedUser.getFullName());
//        existingClient.setEmail(updatedUser.getEmail());
//    }
}
