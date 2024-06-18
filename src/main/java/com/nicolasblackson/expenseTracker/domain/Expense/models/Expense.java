package com.nicolasblackson.expenseTracker.domain.Expense.models;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    //    @JsonFormat(pattern="MM-dd-yyyy")
    private LocalDateTime dateOfExpense;

    @JsonFormat(pattern="MM-dd-yyyy HH:mm:ss")
    private LocalDateTime lastUpdatedDateOfExpense;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String items;

    @NonNull
    private String purpose;

    @NonNull
    private String reason;

    @NonNull
    @Column(columnDefinition="TEXT")
    private String receipt;

    @OneToMany
    @JoinColumn(name = "expense_id")
    private List<Programs> expensePrograms;

    @NonNull
    private double total;

    //    @JsonFormat(pattern="MM-dd-yyyy")
    private String dateNeeded;

    //    @JsonFormat(pattern="MM-dd-yyyy")
    private String dateDelivered;

    private boolean requester;

    private boolean requesterSupervisor;

    private boolean DOO;

    private boolean CEO;

    private boolean recurring;

    private boolean archive;

    private String purchaser;

    @Column(name = "users_id")
    private Long userId;

}
