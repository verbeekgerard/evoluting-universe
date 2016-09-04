package eu.luminis.task;

import eu.luminis.domain.KnownPlanet;
import eu.luminis.service.PlanetRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gerardverbeek on 04/09/16.
 */
@Component
public class PlanetLifeTask {

    @Autowired
    PlanetRegisterService planetRegisterService;

    @Scheduled(fixedDelayString = "${application.task.updateKnownPlanets.interval}")
    private void StartNewPlanets(){
        List<KnownPlanet> notStartedPlanets = planetRegisterService
                .getKnownPlanets()
                .stream().filter(p-> !p.isStarted())
                .collect(Collectors.toList());

        notStartedPlanets.stream().forEach(KnownPlanet::startLife);
    }
}
