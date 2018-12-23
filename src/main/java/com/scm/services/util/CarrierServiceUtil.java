package com.scm.services.util;

import com.scm.services.model.Carrier;
import com.scm.services.service.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarrierServiceUtil {
    private static CarrierService carrierService;

    public static Carrier addCarrier(Carrier carrier) {
        return carrierService.addCarrier(carrier);
    }

    public static void updateCarrier(Carrier carrier) {
        carrierService.updateCarrier(carrier);
    }

    public static void removeCarrier(int carrierId) {
        carrierService.removeCarrier(carrierId);
    }

    public static Carrier getCarrierById(int carrierId) {
        return carrierService.getCarrierById(carrierId);
    }

    public static List<Carrier> getAllCarriers() {
        return carrierService.getAllCarriers();
    }

    public static Carrier getCarrierByUserId(int userId) {
        return carrierService.getCarrierByUserId(userId);
    }

    @Autowired
    public void setCarrierService(CarrierService carrierService) {
        this.carrierService = carrierService;
    }
}
