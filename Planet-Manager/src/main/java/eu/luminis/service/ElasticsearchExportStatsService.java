package eu.luminis.service;

import eu.luminis.domain.KnownPlanet;
import eu.luminis.domain.Stats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ElasticsearchExportStatsService implements ExportStatsService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void export(KnownPlanet planet) {
        Stats stats = planet.getStats();
        log.debug("exporting stats: {}", stats);
    }
}
