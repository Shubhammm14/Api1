package com.example.project7.jwtmodel;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
@Table(name = "login_table")
public class User {
    public User(long id, String name, String password, String email, String rol, boolean enabled) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.rol = rol;
        this.enabled = enabled;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String password;
    private String email;
    private String rol;
    private boolean enabled;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", rol='" + rol + '\'' +
                ", enabled=" + enabled +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
