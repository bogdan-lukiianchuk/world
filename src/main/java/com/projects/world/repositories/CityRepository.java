package com.projects.world.repositories;

import com.projects.world.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    List<City> findAllByName(String name);

    List<City> findTop30ByOrderByPopulationDesc();

    List<City> findTop30ByPopulationGreaterThanOrderByName(int population);
}
