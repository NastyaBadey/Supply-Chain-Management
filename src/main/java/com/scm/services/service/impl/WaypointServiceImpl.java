package com.scm.services.service.impl;

import com.scm.services.dao.WaypointDao;
import com.scm.services.model.Waypoint;
import com.scm.services.service.WaypointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WaypointServiceImpl implements WaypointService {

    @Autowired
    private WaypointDao waypointDao;

    @Transactional
    public void addWaypoint(Waypoint waypoint) {
        waypointDao.add(waypoint);
    }

    @Transactional
    public void updateWaypoint(Waypoint waypoint) {
        waypointDao.update(waypoint);
    }

    @Transactional
    public void removeWaypoint(int waypointId) {
        waypointDao.remove(waypointId);
    }

    public Waypoint getWaypointById(int waypointId) {
        return waypointDao.getById(waypointId);
    }

    public List<Waypoint> getAllWaypoints() {
        return waypointDao.getAll();
    }
}
