package com.scm.services.service;

import com.scm.services.model.Transportation;

import java.util.List;

public interface TransportationService {
    Transportation addTransportation(Transportation transportation);

    void updateTransportation(Transportation transportation);

    void removeTransportation(int id);

    Transportation getTransportationById(int id);

    List<Transportation> getAllTransportations();
}
