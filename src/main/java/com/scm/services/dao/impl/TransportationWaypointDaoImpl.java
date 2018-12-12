package com.scm.services.dao.impl;

import com.scm.services.dao.TransportationWaypointDao;
import com.scm.services.model.TransportationWaypoint;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransportationWaypointDaoImpl implements TransportationWaypointDao {
    private static final Logger logger = LoggerFactory.getLogger(TransportationWaypointDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    public void add(TransportationWaypoint transportationWaypoint) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(transportationWaypoint);
        logger.info("TransportationWaypoint successfully added. TransportationWaypoint details: ", transportationWaypoint);
    }

    public void update(TransportationWaypoint transportationWaypoint) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(transportationWaypoint);
        logger.info("TransportationWaypoint successfully updated. TransportationWaypoint details: ", transportationWaypoint);
    }

    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        TransportationWaypoint transportationWaypoint = session.load(TransportationWaypoint.class, id);
        if (transportationWaypoint != null) {
            session.delete(transportationWaypoint);
            logger.info("TransportationWaypoint successfully removed. TransportationWaypoint details: ", transportationWaypoint);
            return;
        }
        logger.error("TransportationWaypoint with id \'" + id + "\' cannot be removed.");
    }

    public TransportationWaypoint getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        TransportationWaypoint transportationWaypoint = session.load(TransportationWaypoint.class, id);
        System.out.println("TransportationWaypoint successfully loaded. TransportationWaypoint details: " + transportationWaypoint);
        return transportationWaypoint;
    }

    public List<TransportationWaypoint> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<TransportationWaypoint> transportationWaypointList = session.createQuery("from TransportationWaypoint").list();
        for (TransportationWaypoint transportationWaypoint : transportationWaypointList) {
            logger.info("TransportationWaypoint list element: ", transportationWaypoint);
        }
        return transportationWaypointList;
    }
}
