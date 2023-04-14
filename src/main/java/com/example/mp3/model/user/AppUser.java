package com.example.mp3.model.user;

import com.example.mp3.model.music.PlayList;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;
    private String address;
    private String email;
    private String phone;
    @Lob
    private byte[] avatar;
    @OneToMany(mappedBy = "users")
    private List<PlayList> playLists;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<AppRole> roleSet;

    public AppUser() {
    }

    public AppUser(String username, String password, String name, String address, String email, String phone, byte[] avatar, List<PlayList> playLists, Set<AppRole> roleSet) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.avatar = avatar;
        this.playLists = playLists;
        this.roleSet = roleSet;
    }

    public AppUser(String name, String phone, String email, String address, String username, String password) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.username = username;
        this.password = password;
    }


    public AppUser(String name, String phone, String email, String address, byte[] bytes, String username, String password) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.username = username;
        this.password = password;
        this.avatar = bytes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public Set<AppRole> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<AppRole> roleSet) {
        this.roleSet = roleSet;
    }

    public List<PlayList> getPlayLists() {
        return playLists;
    }

    public void setPlayLists(List<PlayList> playLists) {
        this.playLists = playLists;
    }
}