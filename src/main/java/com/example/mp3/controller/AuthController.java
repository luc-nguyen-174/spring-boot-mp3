package com.example.mp3.controller;

import com.example.mp3.model.AppRole;
import com.example.mp3.model.AppUser;
import com.example.mp3.model.DTO.ICountRole;
import com.example.mp3.model.DTO.JwtResponse;
import com.example.mp3.model.DTO.request.SignInForm;
import com.example.mp3.model.DTO.request.SignUpForm;
import com.example.mp3.model.DTO.response.ResponseMessage;
import com.example.mp3.service.approle.IAppRoleService;
import com.example.mp3.service.appuser.IAppUserService;
import com.example.mp3.service.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private IAppUserService userService;
    @Autowired
    private IAppRoleService roleService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpForm user) {
        if (userService.existsByUsername(user.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("the username existed! please try again !"), HttpStatus.OK);
        }
        if (userService.existsByEmail(user.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("the email existed! please try again !"), HttpStatus.OK);
        }
        AppUser appUser = new AppUser(user.getName(), user.getPhone(), user.getEmail(), user.getAddress(),
                user.getUsername(), user.getPassword());
        Set<String> roleNames = user.getRoles();
        Set<AppRole> roles = roleService.getRolesByName(roleNames);
        appUser.setRoleSet(roles);
        userService.save(appUser);
        return new ResponseEntity<>(new ResponseMessage("Create user success !"), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody SignInForm user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        AppUser currentUser = userService.findByUsername(user.getUsername());
        return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(),
                userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @GetMapping("/hello")
    public ResponseEntity<Iterable<ICountRole>> hello() {
        Iterable<ICountRole> iCountRoles = userService.getRoleNumber();
        return new ResponseEntity<>(iCountRoles, HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<String> admin() {
        return new ResponseEntity<>("Admin", HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<String> user() {
        return new ResponseEntity<>("User", HttpStatus.OK);
    }

}
