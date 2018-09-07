package com.projects.world.controllers;

import com.projects.world.model.City;
import com.projects.world.repositories.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RequestMapping(value = "/cities", method = RequestMethod.GET,
        consumes = "application/json", produces = "application/json")
@RestController
public class CityController {
    private final CityRepository cityRepository;

    @RequestMapping("/findByName")
    public List<City> findByName(@RequestParam(name = "name") String name) {
        return cityRepository.findAllByName(name);
    }

    @RequestMapping("/findById")
    public City findById(@RequestParam(name = "id") int id) {
        return cityRepository.findById(id)
                .orElseThrow(NullPointerException::new);
    }

    @RequestMapping("findTop30")
    public List<City> findTop30() {
        return cityRepository.findTop30ByOrderByPopulationDesc();
    }

    @RequestMapping("findGreaterThan")
    public List<City> findGreaterThan(@RequestParam(name = "population") int population) {
        return cityRepository.findTop30ByPopulationGreaterThanOrderByName(population);
    }


}
