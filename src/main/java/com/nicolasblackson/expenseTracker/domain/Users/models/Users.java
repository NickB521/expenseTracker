package com.nicolasblackson.expenseTracker.domain.Users.models;

import com.nicolasblackson.expenseTracker.domain.Expense.models.Expense;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String uid;

    private String name;

    private Boolean admin;

    @OneToMany
    @JoinColumn(name = "users_id")
    private List<Expense> userExpenses;

}
