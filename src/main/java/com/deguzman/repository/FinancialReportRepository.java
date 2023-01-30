package com.deguzman.repository;

import com.deguzman.domain.Expense;
import com.deguzman.domain.Revenue;
import com.deguzman.dto.ExpenseDTO;
import com.deguzman.dto.RevenueDTO;

import java.util.List;

public interface FinancialReportRepository {

    public List<RevenueDTO> getAllRevenues();

    public List<ExpenseDTO> getAllExpenses();

    public List<RevenueDTO> getRevenuesByQuarter(String startDate, String endDate);

    public List<RevenueDTO> getRevenuesByMonth(String startDate, String endDate);

    public List<RevenueDTO> getRevenuesByYear(String startDate, String endDate);

    public List<ExpenseDTO> getExpensesByQuarter(String startDate, String endDate);

    public List<ExpenseDTO> getExpensesByMonth(String startDate, String endDate);

    public List<ExpenseDTO> getExpensesByYear(String startDate, String endDate);

    public int addRevenue(Revenue revenue);

    public int addExpense(Expense expense);

    public int updateRevenue(int revenueId,Revenue revenue);

    public int updateExpense(int expenseId,Expense expense);
}
