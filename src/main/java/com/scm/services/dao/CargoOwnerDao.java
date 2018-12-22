package com.scm.services.dao;

import com.scm.services.model.CargoOwner;

public interface CargoOwnerDao extends Dao<CargoOwner> {
    CargoOwner getCargoOwnerByUserId(int userId);
}
