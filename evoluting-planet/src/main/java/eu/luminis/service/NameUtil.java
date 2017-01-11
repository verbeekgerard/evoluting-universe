package eu.luminis.service;

import java.util.Random;
import java.util.UUID;

public class NameUtil {

    public static String getRandomName() {
        String planetName = PlanetName.values()[getRandomIndex()].toString();
        return planetName+"-"+ UUID.randomUUID().toString().split("-")[0];
    }


    private static int getRandomIndex() {
        Random r = new Random();
        int max = PlanetName.values().length-1;
        return r.nextInt((max - 0) + 1);
    }

    enum PlanetName {
        Mercury, Venus, Earth, Moon, Mars, Jupiter, Saturn, Uranus, Neptune, Pluto
    }

}
