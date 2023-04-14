package com.example.mp3.service.appuser;

import com.example.mp3.model.user.AppUser;
import com.example.mp3.model.DTO.ICountRole;
import com.example.mp3.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAppUserService extends IGeneralService<AppUser>, UserDetailsService {
    AppUser findByUsername(String name);
    Iterable<ICountRole> getRoleNumber();
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
