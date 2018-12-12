package com.scm.services.util;

import com.scm.services.model.Locality;
import com.scm.services.service.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocalityServiceUtil {
    private static LocalityService localityService;

    @Autowired
    public void setLocalityService(LocalityService localityService) {
        this.localityService = localityService;
    }
    

    public static void addLocality(Locality locality){
        localityService.addLocality(locality);
    }

    public static void updateLocality(Locality locality){
        localityService.updateLocality(locality);
    }

    public static void removeLocality(int localityId){
        localityService.removeLocality(localityId);
    }

    public static Locality getLocalityById(int localityId){
        return localityService.getLocalityById(localityId);
    }

    public static List<Locality> getAllLocalities(){
        return localityService.getAllLocalities();
    }
}
