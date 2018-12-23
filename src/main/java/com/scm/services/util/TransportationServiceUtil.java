package com.scm.services.util;

import com.scm.services.model.Transportation;
import com.scm.services.service.TransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransportationServiceUtil {
    private static TransportationService transportationService;

    public static Transportation addTransportation(Transportation transportation) {
        return transportationService.addTransportation(transportation);
    }

    public static void updateTransportation(Transportation transportation) {
        transportationService.updateTransportation(transportation);
    }

    public static void removeTransportation(int transportationId) {
        transportationService.removeTransportation(transportationId);
    }

    public static Transportation getTransportationById(int transportationId) {
        return transportationService.getTransportationById(transportationId);
    }

    public static List<Transportation> getAllTransportations() {
        return transportationService.getAllTransportations();
    }

    @Autowired
    public void setTransportationService(TransportationService transportationService) {
        this.transportationService = transportationService;
    }
}
