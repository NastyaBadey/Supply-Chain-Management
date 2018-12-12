package com.scm.services.service.impl;

import com.scm.services.dao.CargoOwnerDao;
import com.scm.services.model.CargoOwner;
import com.scm.services.service.CargoOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CargoOwnerServiceImpl implements CargoOwnerService {

    @Autowired
    private CargoOwnerDao cargoOwnerDao;

    @Transactional
    public void addCargoOwner(CargoOwner cargoOwner) {
        cargoOwnerDao.add(cargoOwner);
    }

    @Transactional
    public void updateCargoOwner(CargoOwner cargoOwner) {
        cargoOwnerDao.update(cargoOwner);
    }

    @Transactional
    public void removeCargoOwner(int cargoOwnerId) {
        cargoOwnerDao.remove(cargoOwnerId);
    }

    public CargoOwner getCargoOwnerById(int cargoOwnerId) {
        return cargoOwnerDao.getById(cargoOwnerId);
    }

    public List<CargoOwner> getAllCargoOwners() {
        return cargoOwnerDao.getAll();
    }
}
