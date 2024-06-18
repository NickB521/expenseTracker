package com.nicolasblackson.expenseTracker.domain.Programs.repos;

import com.nicolasblackson.expenseTracker.domain.Programs.models.Programs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgramsRepo extends JpaRepository<Programs, Long> {
}
