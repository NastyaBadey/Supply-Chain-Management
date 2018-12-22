package com.scm.services.util;

import com.scm.services.model.Rate;
import com.scm.services.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RateServiceUtil {
    private static RateService rateService;

    @Autowired
    public void setRateService(RateService rateService) {
        this.rateService =rateService;
    }
    

    public static Rate addRate(Rate rate){
        return rateService.addRate(rate);
    }

    public static void updateRate(Rate rate){
        rateService.updateRate(rate);
    }

    public static void removeRate(int rateId){
        rateService.removeRate(rateId);
    }

    public static Rate getRateById(int rateId){
        return rateService.getRateById(rateId);
    }

    public static List<Rate> getAllRates(){
        return rateService.getAllRates();
    }

    public static List<Rate> getAllRatesByCarrierId(int carrierId){
        return rateService.getAllRatesByCarrierId(carrierId);
    }
}
