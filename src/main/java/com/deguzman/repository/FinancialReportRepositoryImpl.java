package com.deguzman.repository;

import com.deguzman.domain.Expense;
import com.deguzman.domain.Revenue;
import com.deguzman.dto.ExpenseDTO;
import com.deguzman.dto.RevenueDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public class FinancialReportRepositoryImpl implements FinancialReportRepository {

    private final String GET_ALL_REVENUES = "SELECT R.REVENUE_ID,R.AMOUNT,R.SETTLEMENT_DATE,RT.DESCR FROM REVENUE R,REVENUE_TYPE RT WHERE R.REVENUE_ID = RT.REVENUE_ID";
    private final String GET_ALL_EXPENSES = "SELECT E.EXPENSE_ID,E.AMOUNT,E.PAYMENT_DATE,E.DESCR FROM EXPENSE E,EXPENSE_TYPE ET";
    private final String GET_REVENUES_BY_QUARTER = "SELECT R.REVENUE_ID,R.AMOUNT,R.SETTLEMENT_DATE,RT.DESCR FROM REVENUE R,REVENUE_TYPE RT WHERE R.REVENUE_ID = RT.REVENUE_ID WHERE SETTLEMENT_DATE IN (?,?)";
    private final String GET_ALL_EXPENSES_BY_QUARTER = "SELECT E.EXPENSE_ID,E.AMOUNT,E.PAYMENT_DATE,E.DESCR FROM EXPENSE E,EXPENSE_TYPE ET WHERE SETTLEMENT_DATE IN (?,?)";
    private final String GET_REVENUES_BY_MONTH = "SELECT R.REVENUE_ID,R.AMOUNT,R.SETTLEMENT_DATE,RT.DESCR FROM REVENUE R,REVENUE_TYPE RT WHERE R.REVENUE_ID = RT.REVENUE_ID WHERE SETTLEMENT_DATE IN (?,?)";
    private final String GET_ALL_EXPENSES_BY_MONTH = "SELECT E.EXPENSE_ID,E.AMOUNT,E.PAYMENT_DATE,E.DESCR FROM EXPENSE E,EXPENSE_TYPE ET WHERE SETTLEMENT_DATE IN (?,?)";
    private final String GET_REVENUES_BY_YEAR = "SELECT R.REVENUE_ID,R.AMOUNT,R.SETTLEMENT_DATE,RT.DESCR FROM REVENUE R,REVENUE_TYPE RT WHERE R.REVENUE_ID = RT.REVENUE_ID WHERE SETTLEMENT_DATE IN (?,?)";
    private final String GET_ALL_EXPENSES_BY_YEAR = "SELECT E.EXPENSE_ID,E.AMOUNT,E.PAYMENT_DATE,E.DESCR FROM EXPENSE E,EXPENSE_TYPE ET WHERE SETTLEMENT_DATE IN (?,?)";
    private final String ADD_REVENUE = "INSERT INTO REVENUE(AMOUNT,SETTLEMENT_DATE,REVENUE_TYPE_ID) VALUES(?,?,?)";
    private final String ADD_EXPENSE = "INSERT INTO EXPENSE(AMOUNT,PAYMENT_DATE,EXPENSE_TYPE_ID) VALUES(?,?,?)";
    private final String UPDATE_EXPENSE = "UPDATE EXPENSE SET AMOUNT ?,PAYMENT_DATE = ?,EXPENSE_TYPE_ID = ? WHERE EXPENSE_ID = ?";
    private final String UPDATE_REVENUE = "UPDATE REVENUE SET AMOUNT = ?, SETTLEMENT_DATE = ?, REVENUE_TYPE_ID = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(FinancialReportRepositoryImpl.class);

    @Override
    public List<RevenueDTO> getAllRevenues() {
        List<RevenueDTO> list = jdbcTemplate.query(GET_ALL_REVENUES,
                BeanPropertyRowMapper.newInstance(RevenueDTO.class));

        LOGGER.info("Retrieving all revenues...");

        return list;
    }

    @Override
    public List<ExpenseDTO> getAllExpenses() {
        List<ExpenseDTO> list = jdbcTemplate.query(GET_ALL_EXPENSES,
                BeanPropertyRowMapper.newInstance(ExpenseDTO.class));

        LOGGER.info("Retrieving all expenses...");

        return list;
    }

    @Override
    public List<RevenueDTO> getRevenuesByQuarter(String startDate, String endDate) {
        List<RevenueDTO> list = jdbcTemplate.query(GET_REVENUES_BY_QUARTER,
                (rs,rowNum) -> new RevenueDTO(
                        rs.getInt("REVENUE_ID"),
                        rs.getDouble("AMOUNT"),
                        LocalDate.parse(rs.getString("SETTLEMENT_DATE")),
                        rs.getString("DESCR")
                ), startDate, endDate);

        LOGGER.info("Retrieving revenues by quarter: " + startDate + "-" + endDate);

        return list;
    }

    @Override
    public List<RevenueDTO> getRevenuesByMonth(String startDate, String endDate) {
        List<RevenueDTO> list = jdbcTemplate.query(GET_REVENUES_BY_MONTH,
                (rs,rowNum) -> new RevenueDTO(
                        rs.getInt("REVENUE_ID"),
                        rs.getDouble("AMOUNT"),
                        LocalDate.parse(rs.getString("SETTLEMENT_DATE")),
                        rs.getString("DESCR")
                ), startDate, endDate);

        LOGGER.info("Retrieving revenues by month: " + startDate + "-" + endDate);

        return list;
    }

    @Override
    public List<RevenueDTO> getRevenuesByYear(String startDate, String endDate) {
        List<RevenueDTO> list = jdbcTemplate.query(GET_REVENUES_BY_YEAR,
                (rs,rowNum) -> new RevenueDTO(
                        rs.getInt("REVENUE_ID"),
                        rs.getDouble("AMOUNT"),
                        LocalDate.parse(rs.getString("SETTLEMENT_DATE")),
                        rs.getString("DESCR")
                ), startDate, endDate);

        LOGGER.info("Retrieving revenues by year: " + startDate + "-" + endDate);

        return list;
    }

    @Override
    public List<ExpenseDTO> getExpensesByQuarter(String startDate, String endDate) {
        List<ExpenseDTO> list = jdbcTemplate.query(GET_ALL_EXPENSES_BY_QUARTER,
                (rs,rowNum) -> new ExpenseDTO(
                        rs.getInt("EXPENSE_ID"),
                        rs.getDouble("AMOUNT"),
                        LocalDate.parse(rs.getString("PAYMENT_DATE")),
                        rs.getString("DESCR")
                ), startDate, endDate);

        LOGGER.info("Retrieving expenses by quarter: " + startDate + "-" + endDate);

        return list;
    }

    @Override
    public List<ExpenseDTO> getExpensesByMonth(String startDate, String endDate) {
        List<ExpenseDTO> list = jdbcTemplate.query(GET_ALL_EXPENSES_BY_MONTH,
                (rs,rowNum) -> new ExpenseDTO(
                        rs.getInt("EXPENSE_ID"),
                        rs.getDouble("AMOUNT"),
                        LocalDate.parse(rs.getString("PAYMENT_DATE")),
                        rs.getString("DESCR")
                ), startDate, endDate);

        LOGGER.info("Retrieving expenses by month: " + startDate + "-" + endDate);

        return list;
    }

    @Override
    public List<ExpenseDTO> getExpensesByYear(String startDate, String endDate) {
        List<ExpenseDTO> list = jdbcTemplate.query(GET_ALL_EXPENSES_BY_YEAR,
                (rs,rowNum) -> new ExpenseDTO(
                        rs.getInt("EXPENSE_ID"),
                        rs.getDouble("AMOUNT"),
                        LocalDate.parse(rs.getString("PAYMENT_DATE")),
                        rs.getString("DESCR")
                ), startDate, endDate);

        LOGGER.info("Retrieving expenses by year: " + startDate + "-" + endDate);

        return list;
    }

    @Override
    public int addRevenue(Revenue revenue) {
        int result;

        int revenueTypeId = revenue.getRevenueTypeId();
        double amount = revenue.getAmount();
        LocalDate settlementDate = revenue.getSettlementDate();

        result = jdbcTemplate.update(ADD_REVENUE, amount,settlementDate,revenueTypeId);

        LOGGER.info("Add new revenue information...");

        return result;
    }

    @Override
    public int addExpense(Expense expense) {
        int result;

        int expenseTypeId = expense.getExpenseTypeId();
        double amount = expense.getAmount();
        Date paymentDate = expense.getPaymentDate();

        result = jdbcTemplate.update(ADD_EXPENSE, amount,paymentDate,expenseTypeId);

        LOGGER.info("Add new revenue information...");

        return result;
    }

    @Override
    public int updateRevenue(int revenueId,Revenue revenue) {
        return 0;
    }

    @Override
    public int updateExpense(int expenseId,Expense expense) {
        return 0;
    }
}
