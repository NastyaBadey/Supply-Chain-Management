package com.scm.services.dao.impl;

import com.scm.services.dao.RateDao;
import com.scm.services.model.Rate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RateDaoImpl implements RateDao {
    private static final Logger logger = LoggerFactory.getLogger(RateDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    public void add(Rate rate) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(rate);
        logger.info("Rate successfully added. Rate details: ", rate);
    }

    public void update(Rate rate) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(rate);
        logger.info("Rate successfully updated. Rate details: ", rate);
    }

    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Rate rate = session.load(Rate.class, id);
        if (rate != null) {
            session.delete(rate);
            logger.info("Rate successfully removed. Rate details: ", rate);
            return;
        }
        logger.error("Rate with id \'" + id + "\' cannot be removed.");
    }

    public Rate getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Rate rate = session.load(Rate.class, id);
        System.out.println("Rate successfully loaded. Rate details: " + rate);
        return rate;
    }

    public List<Rate> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Rate> rateList = session.createQuery("from Rate").list();
        for (Rate rate : rateList) {
            logger.info("Rate list element: ", rate);
        }
        return rateList;
    }

    public List<Rate> getAllRatesByCarrierId(int carrierId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Rate> rateList = session.createQuery("from Rate where carrierId = " + carrierId).list();
        for (Rate rate : rateList) {
            logger.info("Rate list element: ", rate);
        }
        return rateList;
    }
}
