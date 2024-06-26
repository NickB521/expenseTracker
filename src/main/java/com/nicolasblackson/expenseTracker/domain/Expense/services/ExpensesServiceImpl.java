package com.nicolasblackson.expenseTracker.domain.Expense.services;

import com.nicolasblackson.expenseTracker.domain.Expense.models.Expense;
import com.nicolasblackson.expenseTracker.domain.Expense.repos.ExpensesRepo;
import com.nicolasblackson.expenseTracker.exceptions.ResourceCreationException;
import com.nicolasblackson.expenseTracker.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ExpensesServiceImpl implements ExpensesService {

    private ExpensesRepo expensesRepo;

    public ExpensesServiceImpl(ExpensesRepo expensesRepo){
        this.expensesRepo = expensesRepo;
    }

    @Override
    public Expense createExpense(Expense expense) throws ResourceCreationException {
        expense.setDateOfExpense(LocalDateTime.now());
        expense.setLastUpdatedDateOfExpense(LocalDateTime.now());
        expense.setReason("");
        expense.setReceipt("");
        expense.setPurchaser("");
        expense.setDateDelivered("");
        expense.setDOO(false);
        expense.setCEO(false);
        expense.setRequesterSupervisor(false);
        expense.setArchive(false);
        expense = expensesRepo.save(expense);
        return expense;
    }

    @Override
    public Expense getExpenseById(Long id) throws ResourceNotFoundException {
        Expense expense = expensesRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No post with id: " + id));
        return expense;
    }

    @Override
    public List<Expense> getAll() {
        return expensesRepo.findAll();
    }

    @Override
    public Expense updateExpense(Long id, Expense expensesDetails) throws ResourceNotFoundException {
        Expense expense = getExpenseById(id);
        expense.setDateDelivered(expensesDetails.getDateDelivered());
        expense.setPurchaser(expensesDetails.getPurchaser());
        expense.setDateOfExpense(expensesDetails.getDateOfExpense());
        expense.setLastUpdatedDateOfExpense(LocalDateTime.now());
        expense.setFirstName(expensesDetails.getFirstName());
        expense.setLastName(expensesDetails.getLastName());
        expense.setItems(expensesDetails.getItems());
        expense.setPurpose(expensesDetails.getPurpose());
        expense.setReason(expensesDetails.getReason());
        expense.setReceipt(expensesDetails.getReceipt());
        expense.setTotal(expensesDetails.getTotal());
        expense.setDateNeeded(expensesDetails.getDateNeeded());
//        expense.setRequester(expensesDetails.isRequester());
        expense.setRequesterSupervisor(expensesDetails.isRequesterSupervisor());
        expense.setDOO(expensesDetails.isDOO());
        expense.setCEO(expensesDetails.isCEO());
        expense.setRecurring(expensesDetails.isRecurring());
        expense.setArchive(expensesDetails.isArchive());
//        expense.setUserId(expensesDetails.getUserId());
        expense = expensesRepo.save(expense);
        return expense;
    }

    @Override
    public Boolean deleteExpense(Long id) throws ResourceNotFoundException {
        Optional<Expense> expense = expensesRepo.findById(id);
        if(expense.isEmpty()){
            throw new ResourceNotFoundException("Expense does not exists, can not delete");
        }
        Expense expensetodel = expense.get();
        expensesRepo.delete(expensetodel);
        return true;
    }
}
