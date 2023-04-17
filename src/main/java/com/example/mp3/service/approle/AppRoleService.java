package com.example.mp3.service.approle;

import com.example.mp3.model.user.AppRole;
import com.example.mp3.repo.user.IAppRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AppRoleService implements IAppRoleService {

    @Autowired
    private IAppRoleRepo roleRepo;

    @Override
    public Iterable<AppRole> findAll() {
        return roleRepo.findAll();
    }

    @Override
    public Optional<AppRole> findById(Long id) {
        return roleRepo.findById(id);
    }

    @Override
    public AppRole save(AppRole appRole) {
        return roleRepo.save(appRole);
    }

    @Override
    public void remove(Long id) {
        roleRepo.deleteById(id);
    }

    @Override
    public AppRole findByName(String name) {
        return roleRepo.findByName(name);
    }

    @Override
    public Set<AppRole> getRolesByName(Set<String> roleNames) {
        Set<AppRole> roles = new HashSet<>();
        for (String roleName : roleNames) {
            AppRole role = roleRepo.findByName(roleName);
            if (role != null) {
                roles.add(role);
            }
        }
        return roles;
    }
}
