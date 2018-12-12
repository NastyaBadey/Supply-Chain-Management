package com.scm.services.service;

import com.scm.services.model.Cargo;

import java.util.List;

public interface CargoService {
    void addCargo (Cargo cargo);
    void updateCargo (Cargo cargo);
    void removeCargo (int id);
    Cargo getCargoById (int id);
    List<Cargo> getAllCargoes();
}
