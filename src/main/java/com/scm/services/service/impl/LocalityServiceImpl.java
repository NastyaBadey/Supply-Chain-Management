package com.scm.services.service.impl;

import com.scm.services.dao.LocalityDao;
import com.scm.services.model.Locality;
import com.scm.services.service.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LocalityServiceImpl implements LocalityService {

    @Autowired
    private LocalityDao localityDao;

    @Transactional
    public Locality addLocality(Locality locality) {
        return localityDao.add(locality);
    }

    @Transactional
    public void updateLocality(Locality locality) {
        localityDao.update(locality);
    }

    @Transactional
    public void removeLocality(int localityId) {
        localityDao.remove(localityId);
    }

    @Transactional
    public Locality getLocalityById(int localityId) {
        return localityDao.getById(localityId);
    }

    @Transactional
    public List<Locality> getAllLocalities() {
        return localityDao.getAll();
    }
}
