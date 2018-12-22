package com.scm.services.service;

import com.scm.services.model.DeliveryMethod;

import java.util.List;

public interface DeliveryMethodService {
    DeliveryMethod addDeliveryMethod(DeliveryMethod deliveryMethod);

    void updateDeliveryMethod(DeliveryMethod deliveryMethod);

    void removeDeliveryMethod(int id);

    DeliveryMethod getDeliveryMethodById(int id);

    List<DeliveryMethod> getAllDeliveryMethods();
}
