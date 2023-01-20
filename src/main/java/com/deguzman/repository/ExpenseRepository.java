package com.deguzman.repository;

import java.util.List;

import com.deguzman.domain.Expense;

public interface ExpenseRepository {

	List<Expense> getAllExpensesByYear();
}
