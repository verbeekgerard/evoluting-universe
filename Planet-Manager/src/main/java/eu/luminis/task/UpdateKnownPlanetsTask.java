package eu.luminis.task;

import eu.luminis.domain.KnownPlanet;
import eu.luminis.domain.Planet;
import eu.luminis.service.PlanetDiscoveryService;
import eu.luminis.service.PlanetRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UpdateKnownPlanetsTask {

    @Autowired
    PlanetRegisterService planetRegisterService;
    @Autowired
    PlanetDiscoveryService planetDiscoveryService;

    @Scheduled(fixedDelayString = "${application.task.updateKnownPlanets.interval}")
    private void updateKnownPlanetsRegistry(){
        List<Planet> discoveredPlanets = planetDiscoveryService.getDiscoverdPlanets();
        List<KnownPlanet> knownPlanets = planetRegisterService.getKnownPlanets();

        //Add new discovered planets
        List<Planet> newPlanets = getNotRegisterdPlanets(discoveredPlanets, knownPlanets);
        newPlanets.stream().forEach(p-> planetRegisterService.addPlanetToRegister(p));

        //Remove vanished planets
        List<KnownPlanet> removedPlanets = getRemovedPlanets(discoveredPlanets, knownPlanets);
        removedPlanets.stream().forEach(p-> planetRegisterService.removePlanetFromRegistry(p));

    }

    private List<KnownPlanet> getRemovedPlanets(List<Planet> discoveredPlanets, List<KnownPlanet> knownPlanets){
        List<String> discoveredNames = discoveredPlanets.stream().map(Planet::getName).collect(Collectors.toList());

        return knownPlanets.stream()
                .filter(kp-> !discoveredNames.contains(kp.getName()))
                .collect(Collectors.toList());
    }

    private List<Planet> getNotRegisterdPlanets(List<Planet> discoveredPlanets, List<KnownPlanet> knownPlanets){
        List<String> knownNames = knownPlanets.stream().map(Planet::getName).collect(Collectors.toList());

        return discoveredPlanets.stream()
                .filter(dp -> !knownNames.contains(dp.getName()))
                .collect(Collectors.toList());
    }

}
