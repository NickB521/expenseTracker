package com.nicolasblackson.expenseTracker.domain.Expense.services;

import com.nicolasblackson.expenseTracker.domain.Expense.models.Expense;
import com.nicolasblackson.expenseTracker.exceptions.ResourceCreationException;
import com.nicolasblackson.expenseTracker.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ExpensesService {
    Expense createExpense(Expense expense) throws ResourceCreationException;
    Expense getExpenseById(Long id) throws ResourceNotFoundException;
    List<Expense> getAll();
    Expense updateExpense(Long id, Expense expenseDetails) throws ResourceNotFoundException;
    Boolean deleteExpense(Long id) throws ResourceNotFoundException;
}
