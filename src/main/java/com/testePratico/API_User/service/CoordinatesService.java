package com.testePratico.API_User.service;

import com.testePratico.API_User.model.Coordinates;
import com.testePratico.API_User.repository.CoordinatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinatesService {

    @Autowired
    private CoordinatesRepository coordinatesRepository;

    public Coordinates save(Coordinates coordinates){
        return coordinatesRepository.save(coordinates);
    }
}
