package com.aleksei.api.todoapi.controllers;

import com.aleksei.api.todoapi.entity.TodoUser;
import com.aleksei.api.todoapi.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/users")
@Tag(name = "Users Controller", description = "To-Do API")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<TodoUser>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoUser> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

}
