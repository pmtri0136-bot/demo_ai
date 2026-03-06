package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserMapper {

    default UserDto toDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserDto(
            user.getId(),
            user.getUserName(),
            user.getFirstName(),
            user.getLastName() == null ? null : user.getLastName().toUpperCase(),
            user.getProsCompany(),
            user.getEmail()
        );
    }
}
