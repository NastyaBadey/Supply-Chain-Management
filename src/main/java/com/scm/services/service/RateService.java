package com.scm.services.service;

import com.scm.services.model.Rate;

import java.util.List;

public interface RateService {
    Rate addRate(Rate rate);

    void updateRate(Rate rate);

    void removeRate(int id);

    Rate getRateById(int id);

    List<Rate> getAllRates();

    List<Rate> getAllRatesByCarrierId(int carrierId);
}
