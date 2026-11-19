package com.cesul.barber.repositories;

import com.cesul.barber.entities.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(UUID.randomUUID());
        }

        int index = this.users.indexOf(user);

        if (index >= 0) {
            this.users.set(index, user);
        } else {
            this.users.add(user);
        }

        return user;
    }

    public List<User> findAll() {
        return new ArrayList<>(this.users);
    }

    public Optional<User> findById(UUID id) {
        return this.users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public boolean deleteById(UUID id) {
        return this.users.removeIf(user -> user.getId().equals(id));
    }

    public void deleteAll() {
        this.users.clear();
    }
}