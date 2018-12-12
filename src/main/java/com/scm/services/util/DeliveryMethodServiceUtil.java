package com.scm.services.util;

import com.scm.services.model.DeliveryMethod;
import com.scm.services.service.DeliveryMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeliveryMethodServiceUtil {
    private static DeliveryMethodService deliveryMethodService;

    @Autowired
    public void setDeliveryMethodService(DeliveryMethodService deliveryMethodService) {
        this.deliveryMethodService = deliveryMethodService;
    }
    

    public static void addDeliveryMethod(DeliveryMethod deliveryMethod){
        deliveryMethodService.addDeliveryMethod(deliveryMethod);
    }

    public static void updateDeliveryMethod(DeliveryMethod deliveryMethod){
        deliveryMethodService.updateDeliveryMethod(deliveryMethod);
    }

    public static void removeDeliveryMethod(int deliveryMethodId){
        deliveryMethodService.removeDeliveryMethod(deliveryMethodId);
    }

    public static DeliveryMethod getDeliveryMethodById(int deliveryMethodId){
        return deliveryMethodService.getDeliveryMethodById(deliveryMethodId);
    }

    public static List<DeliveryMethod> getAllDeliveryMethods(){
        return deliveryMethodService.getAllDeliveryMethods();
    }
}
