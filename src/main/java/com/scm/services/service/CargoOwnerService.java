package com.scm.services.service;

import com.scm.services.model.CargoOwner;

import java.util.List;

public interface CargoOwnerService {
    CargoOwner addCargoOwner(CargoOwner cargoOwner);

    void updateCargoOwner(CargoOwner cargoOwner);

    void removeCargoOwner(int id);

    CargoOwner getCargoOwnerById(int id);

    List<CargoOwner> getAllCargoOwners();
}
