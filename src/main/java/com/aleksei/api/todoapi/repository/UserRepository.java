package com.aleksei.api.todoapi.repository;


import com.aleksei.api.todoapi.entity.TodoUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<TodoUser, Long> {
}
