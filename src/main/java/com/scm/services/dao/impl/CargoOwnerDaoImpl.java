package com.scm.services.dao.impl;

import com.scm.services.dao.CargoOwnerDao;
import com.scm.services.model.CargoOwner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CargoOwnerDaoImpl implements CargoOwnerDao {
    private static final Logger logger = LoggerFactory.getLogger(CargoOwnerDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    public void add(CargoOwner cargoOwnerOwner) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(cargoOwnerOwner);
        logger.info("CargoOwner successfully added. CargoOwner details: ", cargoOwnerOwner);
    }

    public void update(CargoOwner cargoOwnerOwner) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(cargoOwnerOwner);
        logger.info("CargoOwner successfully updated. CargoOwner details: ", cargoOwnerOwner);
    }

    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CargoOwner cargoOwner = session.load(CargoOwner.class, id);
        if (cargoOwner != null) {
            session.delete(cargoOwner);
            logger.info("CargoOwner successfully removed. CargoOwner details: ", cargoOwner);
            return;
        }
        logger.error("CargoOwner with id \'" + id + "\' cannot be removed.");
    }

    public CargoOwner getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CargoOwner cargoOwner = session.load(CargoOwner.class, id);
        System.out.println("CargoOwner successfully loaded. CargoOwner details: " + cargoOwner);
        return cargoOwner;
    }

    public List<CargoOwner> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<CargoOwner> cargoOwnerList = session.createQuery("from CargoOwner").list();
        for (CargoOwner cargoOwner : cargoOwnerList) {
            logger.info("CargoOwner list element: ", cargoOwner);
        }
        return cargoOwnerList;
    }
}
