package com.nicolasblackson.expenseTracker.domain.Users.services;



import com.nicolasblackson.expenseTracker.domain.Users.models.Users;
import com.nicolasblackson.expenseTracker.exceptions.ResourceCreationException;
import com.nicolasblackson.expenseTracker.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.UUID;

public interface UserService {

    Users createUser(Users users) throws ResourceCreationException;

    Users getUserById(Integer id) throws ResourceNotFoundException;
    Users getUserByUserName(String name) throws ResourceNotFoundException;
    List<Users> getAll();
    Users updateUser(Integer id, Users usersDetails) throws ResourceNotFoundException;
    Boolean deleteUser(Integer id) throws ResourceNotFoundException;
}
