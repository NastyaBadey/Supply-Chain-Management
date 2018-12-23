package com.scm.services.dao.impl;

import com.scm.services.dao.UserDao;
import com.scm.services.model.User;
import com.scm.util.Constants;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    public User add(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        Constants.showMessage("User successfully added. User details: " + user);
        return user;
    }

    public void update(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        Constants.showMessage("User successfully updated. User details: " + user);
    }

    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        if (user != null) {
            session.delete(user);
            Constants.showMessage("User successfully removed. User details: " + user);
            return;
        }
        Constants.showErrorMessage("User with id \'" + id + "\' cannot be removed.");
    }

    public User getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        Constants.showMessage("User successfully loaded. User details: " + user);
        return user;
    }

    public List<User> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        for (User user : userList) {
            Constants.showMessage("User list element: " + user);
        }
        return userList;
    }

    public User getUserByLoginAndPassword(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("from User where userLogin = '" +
                user.getUserLogin() + "' and userPassword = '" + user.getUserPassword() + "'").list();
        if (users.isEmpty()) {
            Constants.showErrorMessage("User \'" + user.getUserLogin() + "\' not found.");
            return null;
        }
        Constants.showMessage("User \'" + user.getUserLogin() + "\' successfully loaded. User details: " + user);
        return users.get(0);
    }
}
