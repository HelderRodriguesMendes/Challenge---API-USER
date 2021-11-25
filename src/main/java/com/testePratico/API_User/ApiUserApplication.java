package com.testePratico.API_User;

import com.testePratico.API_User.requests.service.UserServiceRequest;
import com.testePratico.API_User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class ApiUserApplication implements CommandLineRunner {

	@Autowired
	UserServiceRequest request;

	public static void main(String[] args) {
		SpringApplication.run(ApiUserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		request.checkNextImport();
	}
}
