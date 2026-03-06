package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "lastName", expression = "java(user.getLastName() == null ? null : user.getLastName().toUpperCase())")
    UserDto toDto(User user);
}
