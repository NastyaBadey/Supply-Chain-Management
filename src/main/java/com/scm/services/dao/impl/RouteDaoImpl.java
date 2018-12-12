package com.scm.services.dao.impl;

import com.scm.services.dao.RouteDao;
import com.scm.services.model.Route;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RouteDaoImpl implements RouteDao {
    private static final Logger logger = LoggerFactory.getLogger(RouteDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    public void add(Route route) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(route);
        logger.info("Route successfully added. Route details: ", route);
    }

    public void update(Route route) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(route);
        logger.info("Route successfully updated. Route details: ", route);
    }

    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Route route = session.load(Route.class, id);
        if (route != null) {
            session.delete(route);
            logger.info("Route successfully removed. Route details: ", route);
            return;
        }
        logger.error("Route with id \'" + id + "\' cannot be removed.");
    }

    public Route getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Route route = session.load(Route.class, id);
        System.out.println("Route successfully loaded. Route details: " + route);
        return route;
    }

    public List<Route> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Route> routeList = session.createQuery("from Route").list();
        for (Route route : routeList) {
            logger.info("Route list element: ", route);
        }
        return routeList;
    }
}
