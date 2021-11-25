package com.testePratico.API_User.requests.service;

import com.testePratico.API_User.model.ResponseRequest;
import com.testePratico.API_User.model.Status;
import com.testePratico.API_User.model.User;
import com.testePratico.API_User.repository.UserRepository;
import com.testePratico.API_User.requests.BaseURL;
import com.testePratico.API_User.requests.repositoryRequest.UserserviceRequest;
import com.testePratico.API_User.service.UserService;
import com.testePratico.API_User.util.ConfigImport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;



@Service
public class UserServiceRequest {

    private ConfigImport configImport = new ConfigImport();
    private BaseURL baseURL = new BaseURL();

    @Autowired
    UserServiceRequest request;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserService userService;

    public void checkNextImport() throws IOException {

        User user = userService.checkDatabaseNull();
        if(user == null){
            request.importUsers();
        }else{
            LocalDateTime nextImport = dateTimeNextImport();
            LocalDateTime dateCurrent = configImport.getLocalDateTimeCurrent();
            if(nextImport.equals(dateCurrent) || dateCurrent.isAfter(nextImport)) request.importUsers();
        }
    }

    public LocalDateTime dateTimeNextImport(){
        LocalDateTime lastImport = userRepository.getLastImport();
        LocalDate dateLastImport = lastImport.toLocalDate();
        LocalTime nextTimeImport = LocalTime.of(11, 35);
        return LocalDateTime.of(dateLastImport.plusDays(1), nextTimeImport);
    }

    public void importUsers() throws IOException {
        UserserviceRequest request = baseURL.baseURL().create(UserserviceRequest.class);
        Call<ResponseRequest> call = request.getUsers();
        Response<ResponseRequest> response = call.execute();
        ResponseRequest responseRequest = response.body();

        responseRequest.getUserApiList().forEach(userApi -> {
            userApi.setImported_t(configImport.getLocalDateTimeCurrent());
            userApi.setStatus(Status.PUBLISHED);
            userService.save(userApi);
        });
    }
}
