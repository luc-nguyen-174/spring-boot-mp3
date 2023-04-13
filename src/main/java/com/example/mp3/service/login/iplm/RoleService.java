package com.example.mp3.service.login.iplm;


import com.example.mp3.model.login.Role;
import com.example.mp3.model.login.RoleName;
import com.example.mp3.repository.login.IRoleRepo;
import com.example.mp3.service.login.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepo roleRepo;

    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepo.findByName(name);
    }
}
