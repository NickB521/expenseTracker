package com.nicolasblackson.expenseTracker.domain.Programs.controllers;

import com.nicolasblackson.expenseTracker.domain.Expense.models.Expense;
import com.nicolasblackson.expenseTracker.domain.Programs.models.Programs;
import com.nicolasblackson.expenseTracker.domain.Programs.services.ProgramsService;
import com.nicolasblackson.expenseTracker.exceptions.ResourceCreationException;
import com.nicolasblackson.expenseTracker.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programs")
@CrossOrigin(origins = "*")
public class ProgramController {

    private ProgramsService programsService;
    @Autowired
    public ProgramController(ProgramsService programsService){this.programsService = programsService;}

    @GetMapping("")
    public ResponseEntity<List<Programs>> getAll(){
        List<Programs> programs = programsService.getAll();
        return new ResponseEntity<>(programs, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Programs> createProgram(@RequestBody Programs program) throws ResourceCreationException {
        program = programsService.createProgram(program);
        return new ResponseEntity<>(program, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Programs> getProgramById(@PathVariable("id") Long id){
        Programs program = programsService.getProgramById(id);
        return new ResponseEntity<>(program, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Expense> updateProgram(@PathVariable("id") Long id, @RequestBody Programs programDetails){
        try{
            Programs updatedProgram = programsService.updateProgram(id, programDetails);
            ResponseEntity response = new ResponseEntity(updatedProgram, HttpStatus.OK);
            return response;
        } catch (ResourceCreationException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletedProgram(@PathVariable("id") Long id){
        try {
            programsService.deleteProgram(id);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
}
