package com.scm.services.dao.impl;

import com.scm.services.dao.LocalityDao;
import com.scm.services.model.Locality;
import com.scm.util.Constants;
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


    public Locality add(Locality locality) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(locality);
        Constants.showMessage("Locality successfully added. Locality details: " + locality);
        return locality;
    }

    public void update(Locality locality) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(locality);
        Constants.showMessage("Locality successfully updated. Locality details: " + locality);
    }

    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Locality locality = session.load(Locality.class, id);
        if (locality != null) {
            session.delete(locality);
            Constants.showMessage("Locality successfully removed. Locality details: " + locality);
            return;
        }
        Constants.showErrorMessage("Locality with id \'" + id + "\' cannot be removed.");
    }

    public Locality getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Locality locality = session.load(Locality.class, id);
        Constants.showMessage("Locality successfully loaded. Locality details: " + locality);
        return locality;
    }

    public List<Locality> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Locality> localityList = session.createQuery("from Locality").list();
        for (Locality locality : localityList) {
            Constants.showMessage("Locality list element: " + locality);
        }
        return localityList;
    }
}
