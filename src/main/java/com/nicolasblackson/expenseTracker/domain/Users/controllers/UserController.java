package com.nicolasblackson.expenseTracker.domain.Users.controllers;

import com.nicolasblackson.expenseTracker.domain.Users.models.Users;
import com.nicolasblackson.expenseTracker.domain.Users.services.UserService;
import com.nicolasblackson.expenseTracker.exceptions.ResourceCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAll(){
        List<Users> users = userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Users> createUser(@RequestBody Users users) throws ResourceCreationException {
        users = userService.createUser(users);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") Integer id){
        Users users = userService.getUserById(id);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateUser(@PathVariable("id") Integer id, @RequestBody Users usersDetails){
        try{
            Users updatedUsers = userService.updateUser(id, usersDetails);
            ResponseEntity response = new ResponseEntity(updatedUsers, HttpStatus.OK);
            return response;
        } catch (ResourceCreationException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletedUser(@PathVariable("id") Integer id){
        try {
            userService.deleteUser(id);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } catch (ResourceCreationException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .build();
        }
    }

}
