package com.scm.services.service;

import com.scm.services.model.RateDeliveryMethod;

import java.util.List;

public interface RateDeliveryMethodService {
    void addRateDeliveryMethod(RateDeliveryMethod rateDeliveryMethod);
    void updateRateDeliveryMethod(RateDeliveryMethod rateDeliveryMethod);
    void removeRateDeliveryMethod(int id);
    RateDeliveryMethod getRateDeliveryMethodById(int id);
    List<RateDeliveryMethod> getAllRateDeliveryMethods();
}
