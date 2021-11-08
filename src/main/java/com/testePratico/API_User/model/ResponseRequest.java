package com.testePratico.API_User.model;

import java.util.ArrayList;
import java.util.List;

public class ResponseRequest {
    private List<User> results = new ArrayList<>();

    public List<User> getUserApiList() {
        return results;
    }

    public void setUserApiList(List<User> userApiList) {
        this.results = userApiList;
    }
}
