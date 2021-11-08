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
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


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

    public void importUsers() throws IOException {
        UserserviceRequest request = baseURL.baseURL().create(UserserviceRequest.class);
        Call<ResponseRequest> call = request.getUsers();
        Response<ResponseRequest> response = call.execute();
        ResponseRequest responseRequest = response.body();

        responseRequest.getUserApiList().forEach(userApi -> {
            userApi.setImported_t(configImport.getLocalDateTimeCurrent());
            userApi.setStatus(Status.PUBLISHED);

            updateStatus();
            userService.save(userApi);
        });
    }

    private void updateStatus(){
        List<User> userList = userService.getAll();
        if(!userList.isEmpty()){
            userList.forEach(user -> {
                user.setStatus(Status.TRASH);
                userService.save(user);
            });
        }
    }

    public void checkNextImport() throws IOException {
        if(!userService.getAll().isEmpty()){
            LocalDateTime dateCurrent = configImport.getLocalDateTimeCurrent();
            LocalDateTime lastImport = getLastImport().plusHours(24);
            if(dateCurrent.equals(lastImport) || dateCurrent.isAfter(lastImport)){
                request.importUsers();
            }
        }else{
            request.importUsers();
        }
    }

    public LocalDateTime getLastImport(){
         return userRepository.getLastImport();
    }
}
