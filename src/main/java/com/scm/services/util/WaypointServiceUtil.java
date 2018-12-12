package com.scm.services.util;

import com.scm.services.model.Waypoint;
import com.scm.services.service.WaypointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WaypointServiceUtil {
    private static WaypointService waypointService;

    @Autowired
    public void setWaypointService(WaypointService waypointService) {
        this.waypointService = waypointService;
    }


    public static void addWaypoint(Waypoint waypoint){
        waypointService.addWaypoint(waypoint);
    }

    public static void updateWaypoint(Waypoint waypoint){
        waypointService.updateWaypoint(waypoint);
    }

    public static void removeWaypoint(int waypointId){
        waypointService.removeWaypoint(waypointId);
    }

    public static Waypoint getWaypointById(int waypointId){
        return waypointService.getWaypointById(waypointId);
    }

    public static List<Waypoint> getAllWaypoints(){
        return waypointService.getAllWaypoints();
    }
}
