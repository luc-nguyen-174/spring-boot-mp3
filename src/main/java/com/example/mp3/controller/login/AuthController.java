package com.example.mp3.controller.login;

import com.example.mp3.model.DTO.request.SignInForm;
import com.example.mp3.model.DTO.request.SignUpForm;
import com.example.mp3.model.DTO.response.JwtResponse;
import com.example.mp3.model.DTO.response.ResponseMessage;
import com.example.mp3.model.login.Role;
import com.example.mp3.model.login.RoleName;
import com.example.mp3.model.login.User;
import com.example.mp3.security.jwt.JwtProvider;
import com.example.mp3.security.userprincal.UserPrinciple;
import com.example.mp3.service.login.iplm.RoleService;
import com.example.mp3.service.login.iplm.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody SignUpForm signUpForm) {
        if (userService.existsByUsername(signUpForm.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("the username existed! please try again !"), HttpStatus.OK);
        }
        if (userService.existsByEmail(signUpForm.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("the email existed! please try again !"), HttpStatus.OK);
        }
        User user = new User(signUpForm.getName(), signUpForm.getUsername(), signUpForm.getEmail(),
                passwordEncoder.encode(signUpForm.getPassword()));
        Set<String> strRoles = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role) {
                case "admin" -> {
                    Role adminRole = roleService.findByName(RoleName.ROLE_ADMIN).orElseThrow(
                            () -> new RuntimeException("Role not found")
                    );
                    roles.add(adminRole);
                }
                case "pm" -> {
                    Role pmRole = roleService.findByName(RoleName.ROLE_PM).orElseThrow(
                            () -> new RuntimeException("Role not found")
                    );
                    roles.add(pmRole);
                }
                default -> {
                    Role userRole = roleService.findByName(RoleName.ROLE_USER).orElseThrow(
                            () -> new RuntimeException("Role not found")
                    );
                    roles.add(userRole);
                }
            }
        });
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity<>(new ResponseMessage("Create user success !"), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody SignInForm signInForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return new ResponseEntity<>(new JwtResponse(token, userPrinciple.getName(), userPrinciple.getAuthorities()), HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<String> hello() {
        return  ResponseEntity.ok("hello admin");
    }
}
