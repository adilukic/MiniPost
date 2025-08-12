package com.example.vebdomaci6.repositories.user;

import com.example.vebdomaci6.entities.User;

public interface UserRepo {
    public User findUser(String username);
}
