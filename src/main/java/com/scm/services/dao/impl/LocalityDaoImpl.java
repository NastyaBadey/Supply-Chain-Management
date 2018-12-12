package com.scm.services.dao.impl;

import com.scm.services.dao.LocalityDao;
import com.scm.services.model.Locality;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocalityDaoImpl implements LocalityDao {
    private static final Logger logger = LoggerFactory.getLogger(LocalityDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    public void add(Locality locality) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(locality);
        logger.info("Locality successfully added. Locality details: ", locality);
    }

    public void update(Locality locality) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(locality);
        logger.info("Locality successfully updated. Locality details: ", locality);
    }

    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Locality locality = session.load(Locality.class, id);
        if (locality != null) {
            session.delete(locality);
            logger.info("Locality successfully removed. Locality details: ", locality);
            return;
        }
        logger.error("Locality with id \'" + id + "\' cannot be removed.");
    }

    public Locality getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Locality locality = session.load(Locality.class, id);
        System.out.println("Locality successfully loaded. Locality details: " + locality);
        return locality;
    }

    public List<Locality> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Locality> localityList = session.createQuery("from Locality").list();
        for (Locality locality : localityList) {
            logger.info("Locality list element: ", locality);
        }
        return localityList;
    }
}
