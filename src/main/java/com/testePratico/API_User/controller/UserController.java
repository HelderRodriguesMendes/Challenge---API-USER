package com.testePratico.API_User.controller;

import com.testePratico.API_User.model.User;
import com.testePratico.API_User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<String>get(){
        return ResponseEntity.ok().body("REST Back-end Challenge 20201209 Running");
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> update(@PathVariable Long userId, @RequestBody User user){
        user.setIdUserApi(userId);
        userService.save(user);
        User userUpdate = userService.getById(userId);
        return ResponseEntity.ok().body(userUpdate);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long userId){
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getById(@PathVariable Long userId){
        User user = userService.getById(userId);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll(){
        List<User> users = userService.getAll();
        return ResponseEntity.ok().body(users);
    }
}
