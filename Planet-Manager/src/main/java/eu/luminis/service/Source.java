package eu.luminis.service;

import eu.luminis.domain.Planet;

import java.util.List;

/**
 * Created by gerardverbeek on 02/09/16.
 */
public interface Source {
    List<Planet> getPlanets();
    List<String> getPlanetNames();
}
