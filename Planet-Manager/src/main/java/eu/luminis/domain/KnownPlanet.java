package eu.luminis.domain;

/**
 * Created by gerardverbeek on 03/09/16.
 */
public class KnownPlanet extends Planet {
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
}
