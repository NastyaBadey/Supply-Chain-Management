package com.scm.services.dao.impl;

import com.scm.services.dao.DeliveryMethodDao;
import com.scm.services.model.DeliveryMethod;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeliveryMethodDaoImpl implements DeliveryMethodDao {
    private static final Logger logger = LoggerFactory.getLogger(DeliveryMethodDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    public void add(DeliveryMethod deliveryMethod) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(deliveryMethod);
        logger.info("DeliveryMethod successfully added. DeliveryMethod details: ", deliveryMethod);
    }

    public void update(DeliveryMethod deliveryMethod) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(deliveryMethod);
        logger.info("DeliveryMethod successfully updated. DeliveryMethod details: ", deliveryMethod);
    }

    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        DeliveryMethod deliveryMethod = session.load(DeliveryMethod.class, id);
        if (deliveryMethod != null) {
            session.delete(deliveryMethod);
            logger.info("DeliveryMethod successfully removed. DeliveryMethod details: ", deliveryMethod);
            return;
        }
        logger.error("DeliveryMethod with id \'" + id + "\' cannot be removed.");
    }

    public DeliveryMethod getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        DeliveryMethod deliveryMethod = session.load(DeliveryMethod.class, id);
        System.out.println("DeliveryMethod successfully loaded. DeliveryMethod details: " + deliveryMethod);
        return deliveryMethod;
    }

    public List<DeliveryMethod> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<DeliveryMethod> deliveryMethodList = session.createQuery("from DeliveryMethod").list();
        for (DeliveryMethod deliveryMethod : deliveryMethodList) {
            logger.info("DeliveryMethod list element: ", deliveryMethod);
        }
        return deliveryMethodList;
    }
}
