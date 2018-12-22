package com.scm.services.util;

import com.scm.services.model.Cargo;
import com.scm.services.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CargoServiceUtil {
    private static CargoService cargoService;

    public static Cargo addCargo(Cargo cargo) {
        return cargoService.addCargo(cargo);
    }

    public static void updateCargo(Cargo cargo) {
        cargoService.updateCargo(cargo);
    }

    public static void removeCargo(int cargoId) {
        cargoService.removeCargo(cargoId);
    }

    public static Cargo getCargoById(int cargoId) {
        return cargoService.getCargoById(cargoId);
    }

    public static List<Cargo> getAllCargoes() {
        return cargoService.getAllCargoes();
    }

    @Autowired
    public void setCargoService(CargoService cargoService) {
        this.cargoService = cargoService;
    }
}
