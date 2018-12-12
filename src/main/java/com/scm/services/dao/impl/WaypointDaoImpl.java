package com.scm.services.dao.impl;

import com.scm.services.dao.WaypointDao;
import com.scm.services.model.Waypoint;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WaypointDaoImpl implements WaypointDao {
    private static final Logger logger = LoggerFactory.getLogger(WaypointDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    public void add(Waypoint waypoint) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(waypoint);
        logger.info("Waypoint successfully added. Waypoint details: ", waypoint);
    }

    public void update(Waypoint waypoint) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(waypoint);
        logger.info("Waypoint successfully updated. Waypoint details: ", waypoint);
    }

    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Waypoint waypoint = session.load(Waypoint.class, id);
        if (waypoint != null) {
            session.delete(waypoint);
            logger.info("Waypoint successfully removed. Waypoint details: ", waypoint);
            return;
        }
        logger.error("Waypoint with id \'" + id + "\' cannot be removed.");
    }

    public Waypoint getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Waypoint waypoint = session.load(Waypoint.class, id);
        System.out.println("Waypoint successfully loaded. Waypoint details: " + waypoint);
        return waypoint;
    }

    public List<Waypoint> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Waypoint> waypointList = session.createQuery("from Waypoint").list();
        for (Waypoint waypoint : waypointList) {
            logger.info("Waypoint list element: ", waypoint);
        }
        return waypointList;
    }
}
