package com.nicolasblackson.expenseTracker.domain.Programs.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Programs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String programName;
    @NonNull
    private Double cost;

    @Column(name = "expense_id")
    private Long expenseId;
}
