package com.aleksei.api.todoapi.controllers;

import com.aleksei.api.todoapi.dto.UserDto;
import com.aleksei.api.todoapi.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/users")
@Tag(name = "Users Controller", description = "To-Do API")
@RequiredArgsConstructor
public class UsersController {
    private final UserService userService;


    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

}
