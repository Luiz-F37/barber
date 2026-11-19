package com.cesul.barber.services;

import com.cesul.barber.dtos.UserCreationDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsersService {

    private List<UserCreationDTO> users = new ArrayList<>();

    public UserCreationDTO create(UserCreationDTO user) {
        user.setId(UUID.randomUUID());
        this.users.add(user);

        return user;
    }

    public List<UserCreationDTO> findAll() {
        return this.users;
    }

    public Optional<UserCreationDTO> findById(UUID id) {
        return this.users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public Optional<UserCreationDTO> update(UUID id, Map<String, String> request) {
        Optional<UserCreationDTO> userOptional = this.findById(id);

        userOptional.ifPresent(user -> {
            if (request.containsKey("name")) {
                user.setName(request.get("name"));
            }
            if (request.containsKey("email")) {
                user.setEmail(request.get("email"));
            }
        });

        return userOptional;
    }

    public Optional<UserCreationDTO> updateAvatar(UUID id, Map<String, String> request) {
        Optional<UserCreationDTO> userOptional = this.findById(id);

        userOptional.ifPresent(user -> {
            if (request.containsKey("avatarUrl")) {
                user.setAvatarURL((String) request.get("avatarUrl"));
            }
        });

        return userOptional;
    }

    public boolean delete(UUID id) {
        return this.users.removeIf(user -> user.getId().equals(id));
    }

    public boolean clear() {
        this.users.clear();
        return true;
    }
}