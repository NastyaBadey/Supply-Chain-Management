package com.scm.services.service.impl;

import com.scm.services.dao.CarrierDao;
import com.scm.services.model.Carrier;
import com.scm.services.service.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarrierServiceImpl implements CarrierService {

    @Autowired
    private CarrierDao carrierDao;

    @Transactional
    public void addCarrier(Carrier carrier) {
        carrierDao.add(carrier);
    }

    @Transactional
    public void updateCarrier(Carrier carrier) {
        carrierDao.update(carrier);
    }

    @Transactional
    public void removeCarrier(int carrierId) {
        carrierDao.remove(carrierId);
    }

    public Carrier getCarrierById(int carrierId) {
        return carrierDao.getById(carrierId);
    }

    public List<Carrier> getAllCarriers() {
        return carrierDao.getAll();
    }
}
