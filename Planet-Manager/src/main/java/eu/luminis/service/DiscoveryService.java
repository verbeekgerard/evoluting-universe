package eu.luminis.service;

import eu.luminis.domain.Planet;

import java.util.List;

/**
 * Created by gerardverbeek on 02/09/16.
 */
public interface DiscoveryService {
    List<Planet> getDiscoverdPlanets();
    List<String> getPlanetsNames();
}
