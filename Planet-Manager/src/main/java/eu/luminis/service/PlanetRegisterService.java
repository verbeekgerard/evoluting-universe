package eu.luminis.service;

import eu.luminis.domain.KnownPlanet;
import eu.luminis.domain.Planet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gerardverbeek on 03/09/16.
 */
@Service
public class PlanetRegisterService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    List<KnownPlanet> knownPlanets = new ArrayList<>();

    public List<KnownPlanet>getKnownPlanets(){
        return knownPlanets;
    }

    public void removePlanetFromRegistry(KnownPlanet knownPlanet){
        knownPlanets.remove(knownPlanet);
        log.info("Planet '{}' removed location: '{}'", knownPlanet.getName(), knownPlanet.getUrl());
    }

    public void addPlanetToRegister(Planet planet){
        KnownPlanet knownPlanet = new KnownPlanet(planet);
        knownPlanets.add(knownPlanet);
        log.info("Planet '{}' added. Location: '{}'", knownPlanet.getName(), knownPlanet.getUrl());
    }
}
