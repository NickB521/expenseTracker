package com.nicolasblackson.expenseTracker.domain.Expense.controllers;

import com.nicolasblackson.expenseTracker.domain.Expense.models.Expense;
import com.nicolasblackson.expenseTracker.domain.Expense.services.ExpensesService;
import com.nicolasblackson.expenseTracker.exceptions.ResourceCreationException;
import com.nicolasblackson.expenseTracker.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpensesController {

    private ExpensesService expensesService;

    @Autowired
    public ExpensesController(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }

    @GetMapping("")
    public ResponseEntity<List<Expense>> getAll(){
        List<Expense> expenses = expensesService.getAll();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) throws ResourceCreationException {
        expense = expensesService.createExpense(expense);
        return new ResponseEntity<>(expense, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Expense> getExpensesById(@PathVariable("id") Long id){
        Expense expense = expensesService.getExpenseById(id);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Expense> updateExpenses(@PathVariable("id") Long id, @RequestBody Expense expenseDetails){
        try{
            Expense updatedExpenses = expensesService.updateExpenses(id, expenseDetails);
            ResponseEntity response = new ResponseEntity(updatedExpenses, HttpStatus.OK);
            return response;
        } catch (ResourceCreationException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletedExpense(@PathVariable("id") Long id){
        try {
            expensesService.deleteExpense(id);
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
