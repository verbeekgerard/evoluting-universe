package eu.luminis.service;

import eu.luminis.domain.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PlanetDiscoveryService implements PlanetSource {
    @Autowired
    private DiscoveryClient discoveryClient;


    public List<Planet> getDiscoverdPlanets(){
        List<Planet> planets;
        List<ServiceInstance> serviceInstances = new ArrayList<>();

        getPlanetsNames().stream().forEach(name-> serviceInstances.addAll(discoveryClient.getInstances(name)));
        planets = serviceInstances.stream().map(this::createPlanet).collect(Collectors.toList());

        return planets;
    }

    /**
     * Get all the planets names
     * @return List of planet names
     */
    public List<String> getPlanetsNames(){
        return discoveryClient.getServices();
    }

    /**
     * Create a Planet instance based upon a ServiceInstance
     * @param serviceInstance
     * @return Planet
     */
    private Planet createPlanet(ServiceInstance serviceInstance){
        return new Planet(serviceInstance.getServiceId(), serviceInstance.getUri().toString());
    }

}
