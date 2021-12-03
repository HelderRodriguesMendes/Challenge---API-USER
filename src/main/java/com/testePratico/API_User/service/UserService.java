package com.testePratico.API_User.service;

import com.testePratico.API_User.model.User;
import com.testePratico.API_User.repository.UserRepository;
import com.testePratico.API_User.service.exceptions.ObjectNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @CacheEvict(value = "getLastImport", allEntries = true)
    public User save(User user){
        return userRepository.save(user);
    }

    public Page<User> getAll (Pageable pageable){
        return userRepository.getAllUsersPublished(pageable);
    }

    @CacheEvict(value = "checkDatabaseNull", allEntries = true)
    public void deleteAll(){
        userRepository.deleteAll();
    }

    public void deleteById(Long id){
        userRepository.delete(id);
    }

    public User getUserId(Long userId){
        return userRepository.getUserId(userId).orElseThrow(() ->
                new ObjectNotFoundExceptions("Usuario não encontrado"));
    }

    @Cacheable(value = "checkDatabaseNull")
    public User checkDatabaseNull(){
        Optional<User> optionalUser = userRepository.checkDatabaseNull();
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }else return null;
    }
}
