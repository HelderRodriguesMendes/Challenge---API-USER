package com.testePratico.API_User.service;

import com.testePratico.API_User.model.Name;
import com.testePratico.API_User.repository.NameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NameService {
    @Autowired
    private NameRepository nameRepository;

    public Name save(Name name){
        return nameRepository.save(name);
    }
}
