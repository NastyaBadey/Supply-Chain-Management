package com.scm.services.util;

import com.scm.services.model.CargoOwner;
import com.scm.services.service.CargoOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CargoOwnerServiceUtil {
    private static CargoOwnerService cargoOwnerService;

    @Autowired
    public void setCargoOwnerService(CargoOwnerService cargoOwnerService) {
        this.cargoOwnerService = cargoOwnerService;
    }


    public static void addCargoOwner(CargoOwner cargoOwner) {
        cargoOwnerService.addCargoOwner(cargoOwner);
    }

    public static void updateCargoOwner(CargoOwner cargoOwner) {
        cargoOwnerService.updateCargoOwner(cargoOwner);
    }

    public static void removeCargoOwner(int cargoOwnerId) {
        cargoOwnerService.removeCargoOwner(cargoOwnerId);
    }

    public static CargoOwner getCargoOwnerById(int cargoOwnerId) {
        return cargoOwnerService.getCargoOwnerById(cargoOwnerId);
    }

    public static List<CargoOwner> getAllCargoOwners() {
        return cargoOwnerService.getAllCargoOwners();
    }
}