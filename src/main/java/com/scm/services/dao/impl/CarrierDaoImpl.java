package com.scm.services.dao.impl;

import com.scm.services.dao.CarrierDao;
import com.scm.services.model.Carrier;
import com.scm.util.Constants;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarrierDaoImpl implements CarrierDao {
    private static final Logger logger = LoggerFactory.getLogger(CarrierDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    public Carrier add(Carrier carrier) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(carrier);
        Constants.showMessage("Carrier successfully added. Carrier details: " + carrier);
        return carrier;
    }

    public void update(Carrier carrier) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(carrier);
        Constants.showMessage("Carrier successfully updated. Carrier details: " + carrier);
    }

    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Carrier carrier = session.load(Carrier.class, id);
        if (carrier != null) {
            session.delete(carrier);
            Constants.showMessage("Carrier successfully removed. Carrier details: " + carrier);
            return;
        }
        Constants.showErrorMessage("Carrier with id \'" + id + "\' cannot be removed.");
    }

    public Carrier getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Carrier carrier = session.load(Carrier.class, id);
        Constants.showMessage("Carrier successfully loaded. Carrier details: " + carrier);
        return carrier;
    }

    public List<Carrier> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Carrier> carrierList = session.createQuery("from Carrier").list();
        for (Carrier carrier : carrierList) {
            Constants.showMessage("Carrier list element: " + carrier);
        }
        return carrierList;
    }

    public Carrier getCarrierByUserId(int userId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Carrier> carriers = session.createQuery("from Carrier where userId = " + userId).list();
        if (carriers.isEmpty()) {
            Constants.showMessage("Carrier with userId \'" + userId + "\' not found.");
            return null;
        }
        Carrier carrier = carriers.get(0);
        Constants.showMessage("Carrier successfully loaded. Carrier details: " + carrier);
        return carrier;
    }
}
