package com.scm.services.service.impl;

import com.scm.services.dao.CargoDao;
import com.scm.services.model.Cargo;
import com.scm.services.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoDao cargoDao;

    @Transactional
    public void addCargo(Cargo cargo) {
        cargoDao.add(cargo);
    }

    @Transactional
    public void updateCargo(Cargo cargo) {
        cargoDao.update(cargo);
    }

    @Transactional
    public void removeCargo(int cargoId) {
        cargoDao.remove(cargoId);
    }

    @Transactional
    public Cargo getCargoById(int cargoId) {
        return cargoDao.getById(cargoId);
    }

    @Transactional
    public List<Cargo> getAllCargoes() {
        return cargoDao.getAll();
    }
}
