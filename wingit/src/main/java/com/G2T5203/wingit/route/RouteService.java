package com.G2T5203.wingit.route;

import com.G2T5203.wingit.entities.Route;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    private final RouteRepository repo;

    public RouteService(RouteRepository repo) { this.repo = repo; }

    public List<Route> getAllRoutes() { return repo.findAll(); }

    public List<Route> getAllRoutesWithDepartureDest(String departureDest) {
        return repo.findAllByDepartureDest(departureDest);
    }

    public Route getRoute(Integer routeId) {
        return repo.findById(routeId).orElse(null);
    }

    @Transactional
    public Route createRoute(Route newRoute) { return repo.save(newRoute); }

    @Transactional
    public void deleteRoute(Integer routeId) {
        if (repo.existsById(routeId)) {
            repo.deleteById(routeId);
        } else {
            throw new RouteNotFoundException(routeId);
        }
    }

    @Transactional
    public Route updateRoute(Route updatedRoute) {
        boolean routeExists = repo.existsById(updatedRoute.getRouteId());
        if (!routeExists) throw new RouteNotFoundException(updatedRoute.getRouteId());

        return repo.save(updatedRoute);
    }
}
