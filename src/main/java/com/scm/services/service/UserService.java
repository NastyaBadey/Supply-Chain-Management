package com.scm.services.service;

import com.scm.services.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    void updateUser(User user);

    void removeUser(int id);

    User getUserById(int id);

    List<User> getAllUsers();

    User getUserByLoginAndPassword(User user);
}
