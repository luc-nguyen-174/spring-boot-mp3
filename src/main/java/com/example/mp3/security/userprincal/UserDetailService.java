package com.example.mp3.security.userprincal;

import com.example.mp3.model.login.User;
import com.example.mp3.repository.login.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepo userRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not fond -> username or password" + username));
        return UserPrinciple.build(user);
    }
}
