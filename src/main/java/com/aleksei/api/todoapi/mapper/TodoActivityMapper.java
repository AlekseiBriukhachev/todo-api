package com.aleksei.api.todoapi.mapper;

import com.aleksei.api.todoapi.dto.ActivityDto;
import com.aleksei.api.todoapi.entity.TodoActivity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TodoUserMapper.class})
public interface TodoActivityMapper {

    ActivityDto toDto(TodoActivity activity);

    @Mapping(target = "todoUser", ignore = true)
    TodoActivity toEntity(ActivityDto activityDto);
}
