package com.scm.services.service.impl;

import com.scm.services.dao.RateDeliveryMethodDao;
import com.scm.services.model.RateDeliveryMethod;
import com.scm.services.service.RateDeliveryMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RateDeliveryMethodServiceImpl implements RateDeliveryMethodService {

    @Autowired
    private RateDeliveryMethodDao rateDeliveryMethodDao;

    @Transactional
    public void addRateDeliveryMethod(RateDeliveryMethod rateDeliveryMethod) {
        rateDeliveryMethodDao.add(rateDeliveryMethod);
    }

    @Transactional
    public void updateRateDeliveryMethod(RateDeliveryMethod rateDeliveryMethod) {
        rateDeliveryMethodDao.update(rateDeliveryMethod);
    }

    @Transactional
    public void removeRateDeliveryMethod(int rateDeliveryMethodId) {
        rateDeliveryMethodDao.remove(rateDeliveryMethodId);
    }

    @Transactional
    public RateDeliveryMethod getRateDeliveryMethodById(int rateDeliveryMethodId) {
        return rateDeliveryMethodDao.getById(rateDeliveryMethodId);
    }

    @Transactional
    public List<RateDeliveryMethod> getAllRateDeliveryMethods() {
        return rateDeliveryMethodDao.getAll();
    }
}
