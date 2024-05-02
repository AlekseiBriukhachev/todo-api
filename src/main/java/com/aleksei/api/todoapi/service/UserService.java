package com.aleksei.api.todoapi.service;

import com.aleksei.api.todoapi.dto.UserDto;
import com.aleksei.api.todoapi.entity.TodoUser;
import com.aleksei.api.todoapi.mapper.TodoActivityMapper;
import com.aleksei.api.todoapi.mapper.TodoUserMapper;
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
    private final TodoUserMapper todoUserMapper;
    private final TodoActivityMapper todoActivityMapper;

    public List<UserDto> getAllUsers() {
        var userList = userRepository.findAll();
        return userList.stream()
                .map(todoUserMapper::toDto)
                .toList();
    }

    public TodoUser getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
