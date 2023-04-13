package com.example.mp3.service.appuser;

import com.example.mp3.model.AppUser;
import com.example.mp3.model.DTO.ICountRole;
import com.example.mp3.model.DTO.UserPrinciple;
import com.example.mp3.repo.IAppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService implements IAppUserService {

    @Autowired
    private IAppUserRepo appUserRepo;

    @Override
    public Iterable<AppUser> findAll() {
        return appUserRepo.findAll();
    }

    @Override
    public Optional<AppUser> findById(Long id) {
        return appUserRepo.findById(id);
    }

    @Override
    public AppUser save(AppUser appUser) {
        return appUserRepo.save(appUser);
    }

    @Override
    public void remove(Long id) {
        appUserRepo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> userOptional = appUserRepo.findByUsername(username);
        if (userOptional.isPresent()) {
            return UserPrinciple.build(userOptional.get());
        }
        return null;
    }

    @Override
    public AppUser findByUsername(String name) {
        return appUserRepo.findByUsername(name).get();
    }

    @Override
    public Iterable<ICountRole> getRoleNumber() {
        return appUserRepo.getRoleNumber();
    }

    @Override
    public Boolean existsByUsername(String username) {
        return appUserRepo.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return appUserRepo.existsByEmail(email);
    }
}
