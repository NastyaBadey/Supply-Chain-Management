package com.scm.services.service.impl;

import com.scm.services.dao.UserDao;
import com.scm.services.model.User;
import com.scm.services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public User addUser(User user) {
        return userDao.add(user);
    }

    @Transactional
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Transactional
    public void removeUser(int userId) {
        userDao.remove(userId);
    }

    @Transactional
    public User getUserById(int userId) {
        return userDao.getById(userId);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    @Transactional
    public User getUserByLoginAndPassword(User user) {
        return userDao.getUserByLoginAndPassword(user);
    }
}
