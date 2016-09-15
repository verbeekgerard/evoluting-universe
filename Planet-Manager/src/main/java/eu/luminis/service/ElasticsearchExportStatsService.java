package eu.luminis.service;

import eu.luminis.config.ElasticsearchConfig;
import eu.luminis.domain.KnownPlanet;
import eu.luminis.domain.Stats;
import org.elasticsearch.client.transport.NoNodeAvailableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.net.UnknownHostException;

@Service
public class ElasticsearchExportStatsService implements ExportStatsService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${elasticsearch.stats.indexName}")
    private String INDEX_NAME;

    @Autowired
    private ElasticsearchConfig elasticSearchConfig;
    private ElasticsearchTemplate template;


    @PostConstruct
    public void initIndex() {
        try {
            template = elasticSearchConfig.elasticsearchTemplate();
            if (!template.indexExists(INDEX_NAME)) {
                template.createIndex(INDEX_NAME);
            }
            template.putMapping(Stats.class);
            template.refresh(INDEX_NAME);
        } catch (NoNodeAvailableException e) {
            log.error("No elasticsearch node available!", e);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void export(KnownPlanet planet) {
        Stats stats = planet.getStats();
        IndexQuery query = new IndexQuery();
        query.setIndexName(INDEX_NAME);
        query.setType(planet.getName());
        query.setObject(stats);
        try {
            template.index(query);
            log.debug("exporting stats: {}", stats);
        }catch (NoNodeAvailableException e){
            log.warn("No stats exported to ElasticSearch! Check if the node(s) are available.");
        }
    }

}
