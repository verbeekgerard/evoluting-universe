package eu.luminis.service;

import eu.luminis.domain.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PlanetSource implements Source {
    @Autowired
    private DiscoveryClient discoveryClient;

    public List<Planet> getPlanets(){
        List<Planet> planets;
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("evoluting-wolrd-service");
        planets = serviceInstances.stream().map(this::createPlanet).collect(Collectors.toList());
        return planets;
    }

    public List<String> getPlanetNames(){
        return discoveryClient.getServices();
    }

    private Planet createPlanet(ServiceInstance serviceInstance){
        return new Planet(serviceInstance.getServiceId(), serviceInstance.getUri().toString());
    }

}
