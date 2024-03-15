package com.nicolasblackson.expenseTracker.domain.Users.services;

import com.nicolasblackson.expenseTracker.domain.Users.models.Users;
import com.nicolasblackson.expenseTracker.domain.Users.repos.UserRepo;
import com.nicolasblackson.expenseTracker.exceptions.ResourceCreationException;
import com.nicolasblackson.expenseTracker.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    @Override
    public Users createUser(Users users) throws ResourceCreationException {
        Optional<Users> optional = userRepo.findByUid(users.getUid());
        if(optional.isPresent())
            throw new ResourceCreationException("User already exist: " + users.getId());
        users = userRepo.save(users);
        return users;
    }

    @Override
    public Users getUserById(Integer id) throws ResourceNotFoundException {
        Users users = userRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No User with id: " + id));
        return users;
    }

    @Override
    public List<Users> getAll() {
        return userRepo.findAll();
    }

    @Override
    public Users updateUser(Integer id, Users usersDetails) throws ResourceNotFoundException {
        Users users = getUserById(id);
        users.setName(usersDetails.getName());
        users.setUserExpenses(usersDetails.getUserExpenses());
        users.setAdmin(usersDetails.getAdmin());
        users = userRepo.save(users);
        return users;
    }

    @Override
    public Boolean deleteUser(Integer id) throws ResourceNotFoundException {
        Optional<Users> userOptional = userRepo.findById(id);
        if(userOptional.isEmpty()){
            throw new ResourceNotFoundException("User does not exists, can not delete");
        }
        Users usersToDel = userOptional.get();
        userRepo.delete(usersToDel);
        return true;
    }
}
