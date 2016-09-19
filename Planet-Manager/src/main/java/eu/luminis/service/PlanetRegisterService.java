package eu.luminis.service;

import eu.luminis.domain.KnownPlanet;
import eu.luminis.domain.Planet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PlanetRegisterService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private List<KnownPlanet> knownPlanets = new ArrayList<>();

    /**
     *
     * @return All the planets that are started
     */
    public List<KnownPlanet> getStartedKnownPlanets(){
        return knownPlanets.stream().filter(KnownPlanet::isStarted).collect(Collectors.toList());
    }

    /**
     *
     * @return All the planets that are not started
     */
    public List<KnownPlanet> getNotStartedKnownPlanets(){
        return knownPlanets.stream().filter(p->!p.isStarted()).collect(Collectors.toList());
    }

    /**
     * Remove an existing planet from the register
     * @param knownPlanet
     */
    public void removePlanetFromRegistry(KnownPlanet knownPlanet){
        knownPlanets.remove(knownPlanet);
        log.info("Planet '{}' removed. Location: '{}'", knownPlanet.getName(), knownPlanet.getUrl());
    }

    /**
     * Add a new planet to the register
     * @param planet
     */
    public void addPlanetToRegister(Planet planet){
        KnownPlanet knownPlanet = new KnownPlanet(planet);
        knownPlanets.add(knownPlanet);
        log.info("Planet '{}' added. Location: '{}'", knownPlanet.getName(), knownPlanet.getUrl());
    }

    public List<KnownPlanet>getKnownPlanets(){
        return knownPlanets;
    }

}
