package com.scm.services.service.impl;

import com.scm.services.dao.TransportationWaypointDao;
import com.scm.services.model.TransportationWaypoint;
import com.scm.services.service.TransportationWaypointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransportationWaypointServiceImpl implements TransportationWaypointService {

    @Autowired
    private TransportationWaypointDao transportationWaypointDao;

    @Transactional
    public TransportationWaypoint addTransportationWaypoint(TransportationWaypoint transportationWaypoint) {
        return transportationWaypointDao.add(transportationWaypoint);
    }

    @Transactional
    public void updateTransportationWaypoint(TransportationWaypoint transportationWaypoint) {
        transportationWaypointDao.update(transportationWaypoint);
    }

    @Transactional
    public void removeTransportationWaypoint(int transportationWaypointId) {
        transportationWaypointDao.remove(transportationWaypointId);
    }

    @Transactional
    public TransportationWaypoint getTransportationWaypointById(int transportationWaypointId) {
        return transportationWaypointDao.getById(transportationWaypointId);
    }

    @Transactional
    public List<TransportationWaypoint> getAllTransportationWaypoints() {
        return transportationWaypointDao.getAll();
    }
}
