package com.example.mp3.controller;

import com.example.mp3.model.user.AppRole;
import com.example.mp3.model.user.AppUser;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private IAppUserService userService;
    @Autowired
    private IAppRoleService roleService;

    //create user
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpForm user) throws IOException {
        if (userService.existsByUsername(user.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("the username existed! please try again !"), HttpStatus.OK);
        }
        if (userService.existsByEmail(user.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("the email existed! please try again !"), HttpStatus.OK);
        }
        AppUser appUser = new AppUser(user.getName(), user.getPhone(), user.getEmail(), user.getAddress(), user.getAvatar().getBytes(),
                user.getUsername(), user.getPassword());
        Set<String> roleNames = user.getRoles();
        Set<AppRole> roles = roleService.getRolesByName(roleNames);
        appUser.setRoleSet(roles);
        userService.save(appUser);
        return new ResponseEntity<>(new ResponseMessage("Create user success !"), HttpStatus.OK);
    }

    // login user
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

    //edit user
    @PutMapping("/{id}")
    public ResponseEntity<AppUser> update(@PathVariable Long id, @RequestBody AppUser user) {
        Optional<AppUser> userOptional = userService.findById(id);
        if (userOptional.isPresent()) {
            user.setId(id);
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
