package com.nicolasblackson.expenseTracker.domain.Expense.models;

import com.nicolasblackson.expenseTracker.domain.Programs.models.Programs;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateOfExpense;
    private LocalDateTime lastUpdatedDateOfExpense;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String items;

    @NonNull
    private String purpose;

    @OneToMany
    @JoinColumn(name = "expense_id")
    private List<Programs> expensePrograms;

    private String dateNeeded;

    private boolean requester;

    private boolean requesterSupervisor;

    private boolean DOO;

    private boolean CEO;

    @Column(name = "users_id")
    private Long userId;

}
