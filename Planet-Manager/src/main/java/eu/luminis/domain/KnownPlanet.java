package eu.luminis.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by gerardverbeek on 03/09/16.
 */
public class KnownPlanet extends Planet {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private boolean started;

    public KnownPlanet(Planet planet) {
        super(planet.getName(), planet.getUrl());
    }

    public boolean isStarted() {return started;}
    public void setStarted(boolean started) {this.started = started;}

    @Override
    public String toString() {
        return "KnownPlanet{" +
                "started=" + started +
                '}';
    }

    public void startLife(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseStatus response = restTemplate.getForObject(this.getUrl()+Actions.START, ResponseStatus.class);
        if(response.isSuccessful()){
            this.setStarted(true);
            log.info("{} is started!:", this.getName());
        }
    }

    enum Actions{
        START ("/startPlanet"),
        STATS ("/currentStats");

        private final String value;
        Actions(String s) {value = s;}
        public String toString() {return this.value;}
    }
}
