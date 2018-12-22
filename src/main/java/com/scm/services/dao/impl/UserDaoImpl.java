package com.scm.services.dao.impl;

import com.scm.services.dao.UserDao;
import com.scm.services.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    public void add(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("User successfully added. User details: ", user);
    }

    public void update(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User successfully updated. User details: ", user);
    }

    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        if (user != null) {
            session.delete(user);
            logger.info("User successfully removed. User details: ", user);
            return;
        }
        logger.error("User with id \'" + id + "\' cannot be removed.");
    }

    public User getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        System.out.println("User successfully loaded. User details: " + user);
        return user;
    }

    public List<User> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        for (User user : userList) {
            logger.info("User list element: ", user);
        }
        return userList;
    }

    public User getUserByLoginAndPassword(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        ArrayList<User> users = (ArrayList) session.createQuery("from User where userLogin = '" +
                user.getUserLogin() + "' and userPassword = '" + user.getUserPassword() + "'").list();
        if (users.isEmpty()){
            System.out.println("User \'" + user.getUserLogin() + "\' not found.");
            return null;
        }
        System.out.println("User \'" + user.getUserLogin() + "\' successfully loaded. User details: " + user);
        return users.get(0);
    }
}
