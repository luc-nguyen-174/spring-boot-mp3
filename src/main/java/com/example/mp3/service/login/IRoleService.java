package com.example.mp3.service.login;


import com.example.mp3.model.login.Role;
import com.example.mp3.model.login.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
