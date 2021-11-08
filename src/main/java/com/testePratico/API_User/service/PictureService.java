package com.testePratico.API_User.service;

import com.testePratico.API_User.model.Picture;
import com.testePratico.API_User.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    public Picture save(Picture picture){
        return pictureRepository.save(picture);
    }
}
