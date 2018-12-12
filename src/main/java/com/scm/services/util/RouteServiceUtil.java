package com.scm.services.util;

import com.scm.services.model.Route;
import com.scm.services.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouteServiceUtil {
    private static RouteService routeService;

    @Autowired
    public void setRouteService(RouteService routeService) {
        this.routeService = routeService;
    }
    

    public static void addRoute(Route route){
        routeService.addRoute(route);
    }

    public static void updateRoute(Route route){
        routeService.updateRoute(route);
    }

    public static void removeRoute(int routeId){
        routeService.removeRoute(routeId);
    }

    public static Route getRouteById(int routeId){
        return routeService.getRouteById(routeId);
    }

    public static List<Route> getAllRoutes(){
        return routeService.getAllRoutes();
    }
}
