package com.scm.services.service;

import com.scm.services.model.Waypoint;

import java.util.List;

public interface WaypointService {
    void addWaypoint(Waypoint waypoint);
    void updateWaypoint(Waypoint waypoint);
    void removeWaypoint(int id);
    Waypoint getWaypointById(int id);
    List<Waypoint> getAllWaypoints();
}
