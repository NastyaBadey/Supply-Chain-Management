package com.scm.services.service;

import com.scm.services.model.Carrier;

import java.util.List;

public interface CarrierService {
    Carrier addCarrier(Carrier carrier);

    void updateCarrier(Carrier carrier);

    void removeCarrier(int id);

    Carrier getCarrierById(int id);

    List<Carrier> getAllCarriers();

    Carrier getCarrierByUserId(int userId);
}
