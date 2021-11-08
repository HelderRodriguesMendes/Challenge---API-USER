package com.testePratico.API_User.service;

import com.testePratico.API_User.model.User;
import com.testePratico.API_User.repository.UserRepository;
import com.testePratico.API_User.service.exceptions.ObjectNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginService loginService;

    @Autowired
    private NameService nameService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private DobService dobService;

    @Autowired
    private RegisteredService registeredService;

    @Autowired
    private IdEntityService idEntityService;

    @Autowired
    private PictureService pictureService;

    public void save(User user){

        if(user.getName() != null){
            user.setName(nameService.save(user.getName()));
        }

        if(user.getLocation() != null){
            user.setLocation(locationService.save(user.getLocation()));
        }

        if(user.getLogin() != null){
            user.setLogin(loginService.save(user.getLogin()));
        }

        if(user.getDob() != null){
            user.setDob(dobService.save(user.getDob()));
        }

        if(user.getRegistered() != null){
            user.setRegistered(registeredService.save(user.getRegistered()));
        }

        if(user.getIdEntity() != null){
            user.setIdEntity(idEntityService.save(user.getIdEntity()));
        }

        if(user.getPicture() != null){
            user.setPicture(pictureService.save(user.getPicture()));
        }
        userRepository.save(user);
    }

    public List<User> getAll (){
        return userRepository.getAllUsersPublished();
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public User getById(Long userId){
        return userRepository.findById(userId).orElseThrow(() ->
                new ObjectNotFoundExceptions("Usuario não encontrado"));
    }
}
