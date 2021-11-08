package com.testePratico.API_User.service;

import com.testePratico.API_User.model.Dob;
import com.testePratico.API_User.repository.DobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DobService {

    @Autowired
    private DobRepository dobRepository;

    public Dob save(Dob dob){
        return dobRepository.save(dob);
    }
}
