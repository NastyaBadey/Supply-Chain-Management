package com.scm.services.service;

import com.scm.services.model.TransportationWaypoint;

import java.util.List;

public interface TransportationWaypointService {
    TransportationWaypoint addTransportationWaypoint(TransportationWaypoint transportationWaypoint);

    void updateTransportationWaypoint(TransportationWaypoint transportationWaypoint);

    void removeTransportationWaypoint(int id);

    TransportationWaypoint getTransportationWaypointById(int id);

    List<TransportationWaypoint> getAllTransportationWaypoints();
}
