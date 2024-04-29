package com.aleksei.api.todoapi.repository;


import com.aleksei.api.todoapi.entity.TodoActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<TodoActivity, Long> {
}
