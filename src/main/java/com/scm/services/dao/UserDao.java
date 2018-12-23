package com.scm.services.dao;

import com.scm.services.model.User;

public interface UserDao extends Dao<User> {
    User getUserByLoginAndPassword(User user);
}
