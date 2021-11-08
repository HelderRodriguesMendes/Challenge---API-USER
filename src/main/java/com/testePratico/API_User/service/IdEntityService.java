package com.testePratico.API_User.service;

import com.testePratico.API_User.model.IdEntity;
import com.testePratico.API_User.repository.IdEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdEntityService {

    @Autowired
    private IdEntityRepository idEntityRepository;

    public IdEntity save(IdEntity idEntity){
        return idEntityRepository.save(idEntity);
    }
}
