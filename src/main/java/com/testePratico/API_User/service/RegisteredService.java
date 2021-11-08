package com.testePratico.API_User.service;

import com.testePratico.API_User.model.Registered;
import com.testePratico.API_User.repository.RegisteredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisteredService {

    @Autowired
    private RegisteredRepository registeredRepository;

    public Registered save(Registered registered){
        return registeredRepository.save(registered);
    }
}
