package com.testePratico.API_User.service;

import com.testePratico.API_User.model.Timezone;
import com.testePratico.API_User.repository.TimezoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimezoneService {

    @Autowired
    private TimezoneRepository timezoneRepository;

    public Timezone save(Timezone timezone){
        return timezoneRepository.save(timezone);
    }
}
