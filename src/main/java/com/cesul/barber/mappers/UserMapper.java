package com.cesul.barber.mappers;

import com.cesul.barber.dtos.UserRequestDTO;
import com.cesul.barber.dtos.UserResponseDTO;
import com.cesul.barber.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public User toEntity(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }

    public UserResponseDTO toResponse(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setAvatarUrl(user.getAvatarUrl());
        return dto;
    }

    public List<UserResponseDTO> toResponseList(List<User> users) {
        List<UserResponseDTO> list = new ArrayList<>();

        for (User user : users) {
            list.add(toResponse(user));
        }

        return list;
    }

    public void updateEntity(User user, UserRequestDTO dto) {
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
    }
}