package com.scm.services.util;

import com.scm.services.model.TransportationWaypoint;
import com.scm.services.service.TransportationWaypointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransportationWaypointServiceUtil {
    private static TransportationWaypointService transportationWaypointService;

    public static TransportationWaypoint addTransportationWaypoint(TransportationWaypoint transportationWaypoint) {
        return transportationWaypointService.addTransportationWaypoint(transportationWaypoint);
    }

    public static void updateTransportationWaypoint(TransportationWaypoint transportationWaypoint) {
        transportationWaypointService.updateTransportationWaypoint(transportationWaypoint);
    }

    public static void removeTransportationWaypoint(int transportationWaypointId) {
        transportationWaypointService.removeTransportationWaypoint(transportationWaypointId);
    }

    public static TransportationWaypoint getTransportationWaypointById(int transportationWaypointId) {
        return transportationWaypointService.getTransportationWaypointById(transportationWaypointId);
    }

    public static List<TransportationWaypoint> getAllTransportationWaypoints() {
        return transportationWaypointService.getAllTransportationWaypoints();
    }

    @Autowired
    public void setTransportationWaypointService(TransportationWaypointService transportationWaypointService) {
        this.transportationWaypointService = transportationWaypointService;
    }
}
