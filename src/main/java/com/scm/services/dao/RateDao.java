package com.scm.services.dao;

import com.scm.services.model.Rate;

import java.util.List;

public interface RateDao extends Dao<Rate> {
    List<Rate> getAllRatesByCarrierId(int id);
    Rate addRate(Rate rate);
}
