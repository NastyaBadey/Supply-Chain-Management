package com.scm.services.service.impl;

import com.scm.services.dao.TransportationDao;
import com.scm.services.model.Transportation;
import com.scm.services.service.TransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransportationServiceImpl implements TransportationService {

    @Autowired
    private TransportationDao transportationDao;

    @Transactional
    public Transportation addTransportation(Transportation transportation) {
        return transportationDao.add(transportation);
    }

    @Transactional
    public void updateTransportation(Transportation transportation) {
        transportationDao.update(transportation);
    }

    @Transactional
    public void removeTransportation(int transportationId) {
        transportationDao.remove(transportationId);
    }

    @Transactional
    public Transportation getTransportationById(int transportationId) {
        return transportationDao.getById(transportationId);
    }

    @Transactional
    public List<Transportation> getAllTransportations() {
        return transportationDao.getAll();
    }
}
