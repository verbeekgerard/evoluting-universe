package eu.luminis.task;

import eu.luminis.domain.KnownPlanet;
import eu.luminis.service.ExportStatsService;
import eu.luminis.service.PlanetRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExportStatsTask {

    @Autowired PlanetRegisterService planetRegisterService;
    @Autowired ExportStatsService exportStatsService;

    @Scheduled(fixedDelayString = "${application.task.exportStats.interval}")
    private void getStats(){
        List<KnownPlanet> startedPlanets = planetRegisterService.getStartedKnownPlanets();
        startedPlanets.stream().forEach(p-> exportStatsService.export(p));
    }
}
