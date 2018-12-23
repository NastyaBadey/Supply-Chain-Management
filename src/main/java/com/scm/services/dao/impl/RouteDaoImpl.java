package com.scm.services.dao.impl;

import com.scm.services.dao.RouteDao;
import com.scm.services.model.Route;
import com.scm.util.Constants;
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


    public Route add(Route route) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(route);
        Constants.showMessage("Route successfully added. Route details: " + route);
        return route;
    }

    public void update(Route route) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(route);
        Constants.showMessage("Route successfully updated. Route details: " + route);
    }

    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Route route = session.load(Route.class, id);
        if (route != null) {
            session.delete(route);
            Constants.showMessage("Route successfully removed. Route details: " + route);
            return;
        }
        Constants.showErrorMessage("Route with id \'" + id + "\' cannot be removed.");
    }

    public Route getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Route route = session.load(Route.class, id);
        Constants.showMessage("Route successfully loaded. Route details: " + route);
        return route;
    }

    public List<Route> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Route> routeList = session.createQuery("from Route").list();
        for (Route route : routeList) {
            Constants.showMessage("Route list element: " + route);
        }
        return routeList;
    }
}
