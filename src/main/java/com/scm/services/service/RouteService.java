package com.scm.services.service;

import com.scm.services.model.Route;

import java.util.List;

public interface RouteService {
    void addRoute(Route route);
    void updateRoute(Route route);
    void removeRoute(int id);
    Route getRouteById(int id);
    List<Route> getAllRoutes();
}
