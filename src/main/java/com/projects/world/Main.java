package com.projects.world;

import com.projects.world.repositories.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@AllArgsConstructor
@Component
public class Main {
    private final CityRepository cityRepository;

    @PostConstruct
    public void myMethod() {
        System.out.println(cityRepository.findAllByName("Vladivostok"));
    }
}
