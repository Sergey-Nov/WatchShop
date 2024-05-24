package org.example.repository;

import org.example.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetJPARepository extends
        JpaRepository<Planet, String> {
    Planet getPlanetByName(String name);

}
