package com.aleksei.api.todoapi.mapper;

import com.aleksei.api.todoapi.dto.UserDto;
import com.aleksei.api.todoapi.entity.TodoUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring", uses = {TodoActivityMapper.class})
public interface TodoUserMapper {

    @Mapping(target = "name", source = "fullName")
    UserDto toDto(TodoUser user);

    @Mapping(target = "fullName", source = "name")
    TodoUser toEntity(UserDto userDto);

    List<UserDto> toDto(List<TodoUser> users);

    List<TodoUser> toEntity(List<UserDto> userDtos);
}
