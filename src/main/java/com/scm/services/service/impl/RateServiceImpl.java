package com.scm.services.service.impl;

import com.scm.services.dao.RateDao;
import com.scm.services.model.Rate;
import com.scm.services.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RateServiceImpl implements RateService {

    @Autowired
    private RateDao rateDao;

    @Transactional
    public void addRate(Rate rate) {
        rateDao.add(rate);
    }

    @Transactional
    public void updateRate(Rate rate) {
        rateDao.update(rate);
    }

    @Transactional
    public void removeRate(int rateId) {
        rateDao.remove(rateId);
    }

    public Rate getRateById(int rateId) {
        return rateDao.getById(rateId);
    }

    public List<Rate> getAllRates() {
        return rateDao.getAll();
    }
}
