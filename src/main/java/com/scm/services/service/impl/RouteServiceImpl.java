package com.scm.services.service.impl;

import com.scm.services.dao.RouteDao;
import com.scm.services.model.Route;
import com.scm.services.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteDao routeDao;

    @Transactional
    public Route addRoute(Route route) {
        return routeDao.add(route);
    }

    @Transactional
    public void updateRoute(Route route) {
        routeDao.update(route);
    }

    @Transactional
    public void removeRoute(int routeId) {
        routeDao.remove(routeId);
    }

    @Transactional
    public Route getRouteById(int routeId) {
        return routeDao.getById(routeId);
    }

    @Transactional
    public List<Route> getAllRoutes() {
        return routeDao.getAll();
    }
}
