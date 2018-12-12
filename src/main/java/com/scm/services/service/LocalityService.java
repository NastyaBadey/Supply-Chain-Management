package com.scm.services.service;

import com.scm.services.model.Locality;

import java.util.List;

public interface LocalityService {
    void addLocality(Locality locality);
    void updateLocality(Locality locality);
    void removeLocality(int id);
    Locality getLocalityById(int id);
    List<Locality> getAllLocalities();
}
