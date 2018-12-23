package com.scm.services.dao.impl;

import com.scm.services.dao.CargoOwnerDao;
import com.scm.services.model.CargoOwner;
import com.scm.util.Constants;
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


    public CargoOwner add(CargoOwner cargoOwnerOwner) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(cargoOwnerOwner);
        Constants.showMessage("CargoOwner successfully added. CargoOwner details: " + cargoOwnerOwner);
        return cargoOwnerOwner;
    }

    public void update(CargoOwner cargoOwnerOwner) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(cargoOwnerOwner);
        Constants.showMessage("CargoOwner successfully updated. CargoOwner details: " + cargoOwnerOwner);
    }

    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CargoOwner cargoOwner = session.load(CargoOwner.class, id);
        if (cargoOwner != null) {
            session.delete(cargoOwner);
            Constants.showMessage("CargoOwner successfully removed. CargoOwner details: " + cargoOwner);
            return;
        }
        Constants.showErrorMessage("CargoOwner with id \'" + id + "\' cannot be removed.");
    }

    public CargoOwner getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CargoOwner cargoOwner = session.load(CargoOwner.class, id);
        Constants.showMessage("CargoOwner successfully loaded. CargoOwner details: " + cargoOwner);
        return cargoOwner;
    }

    public List<CargoOwner> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<CargoOwner> cargoOwnerList = session.createQuery("from CargoOwner").list();
        for (CargoOwner cargoOwner : cargoOwnerList) {
            Constants.showMessage("CargoOwner list element: " + cargoOwner);
        }
        return cargoOwnerList;
    }

    public CargoOwner getCargoOwnerByUserId(int userId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<CargoOwner> cargoOwners = session.createQuery("from CargoOwner where userId = " + userId).list();
        if (cargoOwners.isEmpty()) {
            Constants.showMessage("CargoOwner with userId \'" + userId + "\' not found.");
            return null;
        }
        CargoOwner cargoOwner = cargoOwners.get(0);
        Constants.showMessage("CargoOwner successfully loaded. CargoOwner details: " + cargoOwner);
        return cargoOwner;
    }
}
