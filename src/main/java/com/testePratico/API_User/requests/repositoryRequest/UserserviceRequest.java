package com.testePratico.API_User.requests.repositoryRequest;

import com.testePratico.API_User.model.ResponseRequest;
import retrofit2.Call;
import retrofit2.http.GET;


public interface UserserviceRequest {
    @GET("?results=2000")
    Call<ResponseRequest> getUsers();
}
