package org.example.services;

import org.example.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    void saveUser(User user);

    User getUserByUsername(String name);
}
