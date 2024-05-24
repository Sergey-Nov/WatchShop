package org.example.repository;

import org.example.entity.Planet;

import java.util.List;

public interface PlanetRepository {
    List<Planet> findAll();

    Planet getPlanetByName(String name);

    Planet save(Planet planet);

    Planet delete(Planet planet);
}
