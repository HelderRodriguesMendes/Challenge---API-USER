package com.testePratico.API_User.service;

import com.testePratico.API_User.model.Login;
import com.testePratico.API_User.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public Login save(Login login){
        return loginRepository.save(login);
    }
}
