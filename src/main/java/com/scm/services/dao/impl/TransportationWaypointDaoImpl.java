package com.scm.services.dao.impl;

import com.scm.services.dao.TransportationWaypointDao;
import com.scm.services.model.TransportationWaypoint;
import com.scm.util.Constants;
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


    public TransportationWaypoint add(TransportationWaypoint transportationWaypoint) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(transportationWaypoint);
        Constants.showMessage("TransportationWaypoint successfully added. " +
                "TransportationWaypoint details: " + transportationWaypoint);
        return transportationWaypoint;
    }

    public void update(TransportationWaypoint transportationWaypoint) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(transportationWaypoint);
        Constants.showMessage("TransportationWaypoint successfully updated. TransportationWaypoint details: " + transportationWaypoint);
    }

    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        TransportationWaypoint transportationWaypoint = session.load(TransportationWaypoint.class, id);
        if (transportationWaypoint != null) {
            session.delete(transportationWaypoint);
            Constants.showMessage("TransportationWaypoint successfully removed. TransportationWaypoint details: " + transportationWaypoint);
            return;
        }
        Constants.showErrorMessage("TransportationWaypoint with id \'" + id + "\' cannot be removed.");
    }

    public TransportationWaypoint getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        TransportationWaypoint transportationWaypoint = session.load(TransportationWaypoint.class, id);
        Constants.showMessage("TransportationWaypoint successfully loaded. TransportationWaypoint details: " + transportationWaypoint);
        return transportationWaypoint;
    }

    public List<TransportationWaypoint> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<TransportationWaypoint> transportationWaypointList = session.createQuery("from TransportationWaypoint").list();
        for (TransportationWaypoint transportationWaypoint : transportationWaypointList) {
            Constants.showMessage("TransportationWaypoint list element: " + transportationWaypoint);
        }
        return transportationWaypointList;
    }
}
