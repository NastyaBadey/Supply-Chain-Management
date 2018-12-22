package com.scm.services.dao.impl;

import com.scm.services.dao.RateDeliveryMethodDao;
import com.scm.services.model.DeliveryMethod;
import com.scm.services.model.RateDeliveryMethod;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RateDeliveryMethodDaoImpl implements RateDeliveryMethodDao {
    private static final Logger logger = LoggerFactory.getLogger(RateDeliveryMethodDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    public void add(RateDeliveryMethod rateDeliveryMethod) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(rateDeliveryMethod);
        logger.info("RateDeliveryMethod successfully added. RateDeliveryMethod details: ", rateDeliveryMethod);
    }

    public void update(RateDeliveryMethod rateDeliveryMethod) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(rateDeliveryMethod);
        logger.info("RateDeliveryMethod successfully updated. RateDeliveryMethod details: ", rateDeliveryMethod);
    }

    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        RateDeliveryMethod rateDeliveryMethod = session.load(RateDeliveryMethod.class, id);
        if (rateDeliveryMethod != null) {
            session.delete(rateDeliveryMethod);
            logger.info("RateDeliveryMethod successfully removed. RateDeliveryMethod details: ", rateDeliveryMethod);
            return;
        }
        logger.error("RateDeliveryMethod with id \'" + id + "\' cannot be removed.");
    }

    public RateDeliveryMethod getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        RateDeliveryMethod rateDeliveryMethod = session.load(RateDeliveryMethod.class, id);
        System.out.println("RateDeliveryMethod successfully loaded. RateDeliveryMethod details: " + rateDeliveryMethod);
        return rateDeliveryMethod;
    }

    public List<RateDeliveryMethod> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<RateDeliveryMethod> rateDeliveryMethodList = session.createQuery("from RateDeliveryMethod").list();
        for (RateDeliveryMethod rateDeliveryMethod : rateDeliveryMethodList) {
            logger.info("RateDeliveryMethod list element: ", rateDeliveryMethod);
        }
        return rateDeliveryMethodList;
    }

    public RateDeliveryMethod getRateDeliveryMethodByRateId(int rateId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<RateDeliveryMethod> deliveryMethodList = session.createQuery("from RateDeliveryMethod where rateId = " + rateId).list();
        if (deliveryMethodList.isEmpty()) {
            return null;
        }
        return deliveryMethodList.get(0);
    }
}
