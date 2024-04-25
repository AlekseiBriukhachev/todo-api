package com.aleksei.api.todoapi.repository;


import com.aleksei.api.todoapi.entity.TodoActivity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ActivityRepository extends JpaRepository<TodoActivity, Long> {
}
