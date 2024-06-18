package com.nicolasblackson.expenseTracker.domain.Expense.repos;

import com.nicolasblackson.expenseTracker.domain.Expense.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpensesRepo extends JpaRepository<Expense, Long> {

}
