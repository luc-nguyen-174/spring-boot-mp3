package com.example.mp3.service.login;


import com.example.mp3.model.login.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByUsername(String name);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    User save(User user);
}
