package com.scm.services.dao.impl;

import com.scm.services.dao.TransportationDao;
import com.scm.services.model.Transportation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransportationDaoImpl implements TransportationDao {
    private static final Logger logger = LoggerFactory.getLogger(TransportationDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    public void add(Transportation transportation) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(transportation);
        logger.info("Transportation successfully added. Transportation details: ", transportation);
    }

    public void update(Transportation transportation) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(transportation);
        logger.info("Transportation successfully updated. Transportation details: ", transportation);
    }

    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Transportation transportation = session.load(Transportation.class, id);
        if (transportation != null) {
            session.delete(transportation);
            logger.info("Transportation successfully removed. Transportation details: ", transportation);
            return;
        }
        logger.error("Transportation with id \'" + id + "\' cannot be removed.");
    }

    public Transportation getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Transportation transportation = session.load(Transportation.class, id);
        System.out.println("Transportation successfully loaded. Transportation details: " + transportation);
        return transportation;
    }

    public List<Transportation> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Transportation> transportationList = session.createQuery("from Transportation").list();
        for (Transportation transportation : transportationList) {
            logger.info("Transportation list element: ", transportation);
        }
        return transportationList;
    }
}
