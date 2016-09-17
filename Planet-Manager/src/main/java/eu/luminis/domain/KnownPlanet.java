package eu.luminis.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

@Data
@Slf4j
public class KnownPlanet extends Planet {
    private boolean started;

    public KnownPlanet(Planet planet) {
        super(planet.getName(), planet.getUrl());
    }

    /**
     * Start this planet
     */
    public void startPlanet(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseStatus response = restTemplate.postForObject(this.getUrl() + Action.START, null, ResponseStatus.class);
        if(response.isSuccessful()){
            this.setStarted(true);
            log.info("{} is started!:", this.getName());
        }
    }

    /**
     * Stop this planet
     */
    public void stopPlanet(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseStatus response = restTemplate.postForObject(this.getUrl()+ Action.STOP, null, ResponseStatus.class);
        if(response.isSuccessful()){
            this.setStarted(true);
            log.info("{} is started!:", this.getName());
        }
    }

    /**
     * Get the current stats of this planet
     * @return Stats object
     */
    public Stats getStats(){
        RestTemplate restTemplate = new RestTemplate();
        //TODO: Make 'Stats' class available in some sort of commons project so it can be shared between the projects.
        Stats stats = restTemplate.getForObject(this.getUrl() + Action.STATS, Stats.class);
        return stats;
    }

    enum Action {
        START ("/startPlanet"),
        STOP ("/stopPlanet"),
        STATS ("/currentStats");

        private final String value;
        Action(String s) {value = s;}
        public String toString() {return this.value;}
    }
}
