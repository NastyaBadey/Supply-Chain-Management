package com.scm.services.util;

import com.scm.services.model.RateDeliveryMethod;
import com.scm.services.service.RateDeliveryMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RateDeliveryMethodServiceUtil {
    private static RateDeliveryMethodService rateDeliveryMethodService;

    @Autowired
    public void setRateDeliveryMethodService(RateDeliveryMethodService rateDeliveryMethodService) {
        this.rateDeliveryMethodService = rateDeliveryMethodService;
    }
    

    public static void addRateDeliveryMethod(RateDeliveryMethod rateDeliveryMethod){
        rateDeliveryMethodService.addRateDeliveryMethod(rateDeliveryMethod);
    }

    public static void updateRateDeliveryMethod(RateDeliveryMethod rateDeliveryMethod){
        rateDeliveryMethodService.updateRateDeliveryMethod(rateDeliveryMethod);
    }

    public static void removeRateDeliveryMethod(int rateDeliveryMethodId){
        rateDeliveryMethodService.removeRateDeliveryMethod(rateDeliveryMethodId);
    }

    public static RateDeliveryMethod getRateDeliveryMethodById(int rateDeliveryMethodId){
        return rateDeliveryMethodService.getRateDeliveryMethodById(rateDeliveryMethodId);
    }

    public static List<RateDeliveryMethod> getAllRateDeliveryMethods(){
        return rateDeliveryMethodService.getAllRateDeliveryMethods();
    }
}
