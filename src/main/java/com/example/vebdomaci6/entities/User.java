package com.example.vebdomaci6.entities;

public class User {
    private String username;
    private String hashedPassword;
    private String role;

    public User(String username, String role, String hashedPassword) {
        this.username = username;
        this.role = role;
        this.hashedPassword = hashedPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
