package org.example.service;

import org.example.entity.Planet;

import java.util.List;

public interface PlanetService {
    List<Planet> getPlanetList();
    Planet getPlanetByName(String name);
    Planet savePlanet(Planet planet);
    void updatePlanet(Planet planet);
    Planet deletePlanetByName(String planetName);
}
