package com.nicolasblackson.expenseTracker.domain.Programs.services;

import com.nicolasblackson.expenseTracker.domain.Programs.models.Programs;
import com.nicolasblackson.expenseTracker.exceptions.ResourceCreationException;
import com.nicolasblackson.expenseTracker.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ProgramsService {
    Programs createProgram(Programs program) throws ResourceCreationException;
    Programs getProgramById(Long id) throws ResourceNotFoundException;
    List<Programs> getAll();
    Programs updateProgram(Long id, Programs programsDetails) throws ResourceNotFoundException;
    Boolean deleteProgram(Long id) throws ResourceNotFoundException;
}
