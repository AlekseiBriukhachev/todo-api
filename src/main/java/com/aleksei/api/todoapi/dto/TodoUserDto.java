package com.aleksei.api.todoapi.dto;

import com.aleksei.api.todoapi.entity.TodoUser;
import lombok.Builder;

import java.util.List;


@Builder
public record TodoUserDto(
        Long id,
        String name,
        String email,
        List<TodoActivityDto> activities
) {
    public static TodoUserDto from(TodoUser user) {
        return TodoUserDto.builder()
                .id(user.getId())
                .name(user.getFullName())
                .email(user.getEmail())
                .activities(user.getActivities() != null ?
                        user.getActivities().stream().map(TodoActivityDto::from).toList() : List.of())
                .build();
    }
}
