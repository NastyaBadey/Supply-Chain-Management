package com.scm.services.dao.impl;

import com.scm.services.dao.CargoDao;
import com.scm.services.model.Cargo;
import com.scm.util.Constants;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CargoDaoImpl implements CargoDao {
    private static final Logger logger = LoggerFactory.getLogger(CargoDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    public Cargo add(Cargo cargo) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(cargo);
        Constants.showMessage("Cargo successfully added. Cargo details: " + cargo);
        return cargo;
    }

    public void update(Cargo cargo) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(cargo);
        Constants.showMessage("Cargo successfully updated. Cargo details: " + cargo);
    }

    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Cargo cargo = session.load(Cargo.class, id);
        if (cargo != null) {
            session.delete(cargo);
            Constants.showMessage("Cargo successfully removed. Cargo details: " + cargo);
            return;
        }
        Constants.showErrorMessage("Cargo with id \'" + id + "\' cannot be removed.");
    }

    public Cargo getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Cargo cargo = session.load(Cargo.class, id);
        Constants.showMessage("Cargo successfully loaded. Cargo details: " + cargo);
        return cargo;
    }

    public List<Cargo> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Cargo> cargoList = session.createQuery("from Cargo").list();
        for (Cargo cargo : cargoList) {
            Constants.showMessage("Cargo list element: " + cargo);
        }
        return cargoList;
    }
}
