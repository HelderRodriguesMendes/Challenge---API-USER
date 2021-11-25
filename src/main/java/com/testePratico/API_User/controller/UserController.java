package com.testePratico.API_User.controller;

import com.testePratico.API_User.model.User;
import com.testePratico.API_User.requests.service.UserServiceRequest;
import com.testePratico.API_User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    UserServiceRequest request;

    @GetMapping
    public ResponseEntity<String>get() throws IOException {
        request.checkNextImport();
        return ResponseEntity.ok().body("REST Back-end Challenge 20201209 Running");
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> update(@PathVariable Long userId, @RequestBody User user) throws IOException {
        request.checkNextImport();
        return ResponseEntity.ok().body(userService.save(user));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long userId) throws IOException {
        request.checkNextImport();
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getById(@PathVariable Long userId) throws IOException {
        request.checkNextImport();
        User user = userService.getUserId(userId);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/users")
    public ResponseEntity<Page<User>> getAll(@PageableDefault(sort = "id_user_api", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao) throws IOException {
        request.checkNextImport();
        Page<User> users = userService.getAll(paginacao);
        return ResponseEntity.ok().body(users);
    }
}
