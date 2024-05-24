package org.example.controller;


import org.example.entity.Planet;
import org.example.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planet")
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    //CRUD ->
    // READ
    @GetMapping()
    public List<Planet> getPlanetList() {
        return planetService.getPlanetList();
    }

    //CRUD -> READ
    @GetMapping(params = "planetName")
    public Planet getPlanetByName(@RequestParam String planetName) {
        return planetService.getPlanetByName(planetName);
    }

    //CRUD -> READ
    @GetMapping("/{planetName}")
    public Planet getPlanetByNameFromURL(
            @PathVariable String planetName) {
        return planetService.getPlanetByName(planetName);
    }

    //CRUD -> CREATE
    @PostMapping()
    public ResponseEntity<Planet> createNewPlanet(@RequestBody Planet planet) {
        Planet savedPlanet = planetService.savePlanet(planet);
        ResponseEntity<Planet> responseEntity = savedPlanet!=null ?
                ResponseEntity.ok(planetService.getPlanetByName(planet.getName())) :
                ResponseEntity.status(400).body(new Planet());
        return responseEntity;
    }

    //CRUD -> UPDATE
    @PutMapping
    public Planet updatePlanet(@RequestBody Planet planet) {
        planetService.updatePlanet(planet);
        return planetService.getPlanetByName(planet.getName());
    }

    //CRUD -> DELETE
    @DeleteMapping("/{planetName}")
    public Planet deletePlanetByName(@PathVariable String planetName) {
        return planetService.deletePlanetByName(planetName);
    }
}
