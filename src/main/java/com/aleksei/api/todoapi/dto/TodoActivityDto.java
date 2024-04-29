package com.aleksei.api.todoapi.dto;

import com.aleksei.api.todoapi.entity.TodoActivity;
import lombok.Builder;

import java.util.Date;

@Builder
public record TodoActivityDto(
        Long id,
        String title,
        String description,
        Date startDate,
        Date endDate
) {
    public static TodoActivityDto from(TodoActivity activity) {
        return TodoActivityDto.builder()
                .id(activity.getId())
                .title(activity.getTitle())
                .description(activity.getDescription())
                .startDate(activity.getStartDate())
                .endDate(activity.getEndDate())
                .build();
    }
}
