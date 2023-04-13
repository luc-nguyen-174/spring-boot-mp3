package com.example.mp3.model.DTO.request;

import java.util.Set;

public class SignUpForm {
    private String name;
    private String phone;
    private String email;
    private String address;
    private String username;
    private String password;
    private Set<String> roles;

    public SignUpForm() {
    }

    public SignUpForm(String name, String phone, String email, String address, String username, String password, Set<String> roles) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}