package com.scm.services.util;

import com.scm.services.model.User;
import com.scm.services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceUtil {
    private static UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    public static void addUser(User user) {
        userService.addUser(user);
    }

    public static void updateUser(User user) {
        userService.updateUser(user);
    }

    public static void removeUser(int userId) {
        userService.removeUser(userId);
    }

    public static User getUserById(int userId) {
        return userService.getUserById(userId);
    }

    public static List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public static User getUserByLoginAndPassword(User user) {
        return userService.getUserByLoginAndPassword(user);
    }
}
