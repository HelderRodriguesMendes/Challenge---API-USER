package com.testePratico.API_User.service;

import com.testePratico.API_User.model.Street;
import com.testePratico.API_User.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreetService {

    @Autowired
    private StreetRepository streetRepository;

    public Street save(Street street){
        return streetRepository.save(street);
    }
}
