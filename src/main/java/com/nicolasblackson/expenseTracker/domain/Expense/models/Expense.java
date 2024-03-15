package com.nicolasblackson.expenseTracker.domain.Expense.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;

    private LocalDateTime dateOfExpense;
    private LocalDateTime lastUpdatedDateOfExpense;

    @NonNull
    private String desc;

    @NonNull
    private Double amount;

    private String category;

    @Column(name = "users_id")
    private Long userId;

}
