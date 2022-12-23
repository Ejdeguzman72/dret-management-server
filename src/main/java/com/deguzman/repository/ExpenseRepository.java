package com.deguzman.repository;

import java.util.Date;
import java.util.List;

import com.deguzman.domain.Expense;

public interface ExpenseRepository {

	public List<Expense> getAllExpenseInformation();
	
	public List<Expense> getExpensesByIncurredDate(Date incurredDate);
	
	public List<Expense> getExpensesByPaymentDate(Date paymentDate);
	
	public Expense getExpenseById(long expenseId);
	
	public int addExpense(Expense expense);
	
	public int updateExpenseInformation(long expenseId, Expense expenseInfor);
	
	public int deleteExpenseInformation(long expenseId);
}
