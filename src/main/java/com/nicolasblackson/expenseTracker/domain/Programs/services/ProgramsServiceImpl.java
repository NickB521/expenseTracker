package com.nicolasblackson.expenseTracker.domain.Programs.services;

import com.nicolasblackson.expenseTracker.domain.Programs.models.Programs;
import com.nicolasblackson.expenseTracker.domain.Programs.repos.ProgramsRepo;
import com.nicolasblackson.expenseTracker.exceptions.ResourceCreationException;
import com.nicolasblackson.expenseTracker.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProgramsServiceImpl implements ProgramsService {

    private ProgramsRepo programsRepo;

    public ProgramsServiceImpl(ProgramsRepo programsRepo){
        this.programsRepo = programsRepo;
    }
    @Override
    public Programs createProgram(Programs program) throws ResourceCreationException {
        program = programsRepo.save(program);
        return program;
    }

    @Override
    public Programs getProgramById(Long id) throws ResourceNotFoundException {
        Programs program = programsRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No program with id:" + id));
        return program;
    }

    @Override
    public List<Programs> getAll() {
        return programsRepo.findAll();
    }

    @Override
    public Programs updateProgram(Long id, Programs programsDetails) throws ResourceNotFoundException {
        Programs program = getProgramById(id);
        program.setProgramName(programsDetails.getProgramName());
        program.setCost(programsDetails.getCost());
        program.setExpenseId(program.getExpenseId());
        program = programsRepo.save(program);
        return program;
    }

    @Override
    public Boolean deleteProgram(Long id) throws ResourceNotFoundException {
        Optional<Programs> programs = programsRepo.findById(id);
        if(programs.isEmpty()){
            throw new ResourceNotFoundException("program does not exists, can not delete");
        }
        Programs programToDel = programs.get();
        programsRepo.delete(programToDel);
        return true;
    }
}
