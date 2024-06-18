package com.nicolasblackson.expenseTracker.domain.Users.repos;

import com.nicolasblackson.expenseTracker.domain.Users.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String name);
    Optional<Users> findByEmail(String email);
}
