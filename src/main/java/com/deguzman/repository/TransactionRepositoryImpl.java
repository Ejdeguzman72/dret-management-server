package com.deguzman.repository;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.deguzman.domain.Transaction;
import com.deguzman.dto.TransactionDTO;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContactRepositoryImpl.class);
	
	String GET_ALL_TRANSACTIONS_SQL = "SELECT TRANSACTION_ID, "
			+ "ADDRESS01, "
			+ "ADDRESS02, "
			+ "CITY, "
			+ "STATE, "
			+ "ZIP, "
			+ "TRANSACTION_TYPE_DESCR, "
			+ "AMOUNT, "
			+ "SETTLEMENT_DATE "
			+ "FROM TRANSACTION T, PROEPRTY P, TRANSACTION_TYPE TT "
			+ "WHERE T.TRANSACTION_TYPE_ID = TT.TRANSACTION_TYPE_ID "
			+ "AND T.PROPERTY_ID = P.PROPERTY_ID";
	
	String GET_ALL_TRANSACTIONS_BY_TYPE_SQL = "SELECT TRANSACTION_ID, "
			+ "ADDRESS01, "
			+ "ADDRESS02, "
			+ "CITY, "
			+ "STATE, "
			+ "ZIP, "
			+ "TRANSACTION_TYPE_DESCR, "
			+ "AMOUNT, "
			+ "SETTLEMENT_DATE "
			+ "FROM TRANSACTION T, PROEPRTY P, TRANSACTION_TYPE TT "
			+ "WHERE T.TRANSACTION_TYPE_ID = TT.TRANSACTION_TYPE_ID "
			+ "AND T.PROPERTY_ID = P.PROPERTY_ID "
			+ "AND T.TRANSACTION_TYPE_ID IN ?";
	
	String GET_ALL_TRANSACTIONS_BY_PROPERTY_SQL = "SELECT TRANSACTION_ID, "
			+ "ADDRESS01, "
			+ "ADDRESS02, "
			+ "CITY, "
			+ "STATE, "
			+ "ZIP, "
			+ "TRANSACTION_TYPE_DESCR, "
			+ "AMOUNT, "
			+ "SETTLEMENT_DATE "
			+ "FROM TRANSACTION T, PROEPRTY P, TRANSACTION_TYPE TT "
			+ "WHERE T.TRANSACTION_TYPE_ID = TT.TRANSACTION_TYPE_ID "
			+ "AND T.PROPERTY_ID = P.PROPERTY_ID "
			+ "AND T.PROPERTY_TYPE_ID IN ?";
	
	String ADD_TRANSACTION_INFORMATION_SQL = "INSERT INTO TRANSACTION(PROPERTY_ID, TRANSACTION_TYPE_ID, AMOUNT, SETTLEMENT_DATE) "
			+ "VALUES (?,?,?,?)";
	
	String UPDATE_TRANSACTION_INFORMATION_SQL = "UPDATE TRANSACTION "
			+ "SET VERIFIED = ? "
			+ "WHERE TRANSACTION_ID = ?";
	
	String DELETE_TRANSACTION_INFORMATION_SQL = "DELETE FROM TRANSASCTION WHERE TRANSACTION_ID = ?";
	
	@Override
	public List<TransactionDTO> getAllTransactionInformation() {
		List<TransactionDTO> list = jdbcTemplate.query(GET_ALL_TRANSACTIONS_SQL, BeanPropertyRowMapper.newInstance(TransactionDTO.class));
		
		return list;
	}

	@Override
	public List<TransactionDTO> getTransactionsByType(int transactionTypeId) {
		List<TransactionDTO> list = jdbcTemplate.query(GET_ALL_TRANSACTIONS_BY_TYPE_SQL, 
				(rs, rowNum) -> new TransactionDTO(
						rs.getLong("CONTACT_ID"),
						rs.getString("ADDRESS01"),
						rs.getString("ADDRESS02"),
						rs.getString("CITY"),
						rs.getString("STATE"),
						rs.getString("ZIP"),
						rs.getString("TRANSACTION_TYPE_DESCR"),
						rs.getDouble("AMOUNT"),
						LocalDate.parse(rs.getString("SETTLEMENT_DATE"))), transactionTypeId);
		
		return list;
	}

	@Override
	public List<TransactionDTO> getTransactionsByProperty(long propertyId) {
		List<TransactionDTO> list = jdbcTemplate.query(GET_ALL_TRANSACTIONS_BY_TYPE_SQL, 
				(rs, rowNum) -> new TransactionDTO(
						rs.getLong("CONTACT_ID"),
						rs.getString("ADDRESS01"),
						rs.getString("ADDRESS02"),
						rs.getString("CITY"),
						rs.getString("STATE"),
						rs.getString("ZIP"),
						rs.getString("TRANSACTION_TYPE_DESCR"),
						rs.getDouble("AMOUNT"),
						LocalDate.parse(rs.getString("SETTLEMENT_DATE"))), propertyId);
		
		return list;
	}

	@Override
	public int addTransactionInformation(Transaction transaction) {
		int result = 0;
		
		long propertyId = transaction.getPropertyId();
		int transactionTypeId = transaction.getTransactionTypeId();
		double amount = transaction.getAmount();
		LocalDate settlementDate = transaction.getSettlementDate();
		
		result = jdbcTemplate.update(ADD_TRANSACTION_INFORMATION_SQL, new Object[] {
				propertyId, transactionTypeId, amount, settlementDate
		});
		
		LOGGER.info("Adding new transaction information...");
		
		return result;
	}

	@Override
	public int updateTransactionInformation(long transactionId, Transaction transactionDetails) {
		// TODO Auto-generated method stub
		return 0;
	}

}
