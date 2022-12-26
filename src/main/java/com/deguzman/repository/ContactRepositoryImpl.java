package com.deguzman.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.deguzman.domain.Contact;

@Repository
public class ContactRepositoryImpl implements ContactRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	String GET_ALL_CONTACT_INFORMATION = "SELECT CONTACT_ID"
			+ "CONTACT_TYPE_ID "
			+ "EMAIL "
			+ "FIRSTNAME "
			+ "LASTNAME "
			+ "MIDDLE_INITIAL "
			+ "PHONE "
			+ "FROM CONTACT";
	
	String GET_CONTACT_BY_ID_SQL = "SELECT CONTACT_ID"
			+ "CONTACT_TYPE_ID "
			+ "EMAIL "
			+ "FIRSTNAME "
			+ "LASTNAME "
			+ "MIDDLE_INITIAL "
			+ "PHONE "
			+ "FROM CONTACT "
			+ "WHERE CONTACT_ID = ?";
	
	String GET_CONTACTS_BY_TYPE = "SELECT CONTACT_ID"
			+ "CONTACT_TYPE_ID "
			+ "EMAIL "
			+ "FIRSTNAME "
			+ "LASTNAME "
			+ "MIDDLE_INITIAL "
			+ "PHONE "
			+ "FROM CONTACT "
			+ "WHERE CONTACT_TYPE_ID = ?";
	
	String GET_CONTACT_BY_NAME = "SELECT CONTACT_ID"
			+ "CONTACT_TYPE_ID "
			+ "EMAIL "
			+ "FIRSTNAME "
			+ "LASTNAME "
			+ "MIDDLE_INITIAL "
			+ "PHONE "
			+ "FROM CONTACT "
			+ "WHERE FIRSTNAME = ? "
			+ "OR LASTNAME = ?";
	
	String ADD_CONTACT_INFORMATION_SQL = "INSERT INTO CONTACT "
			+ "VALUES (?,?,?,?,?,?)";
	
	String UPDATE_CONTACT_INFORMATION_SQL = "UPDATE CONTACT "
			+ "SET EMAIL = ?, FIRSTNAME = ?, LASTNAME = ?, MIDDLE_INITIAL = ?, PHONE = ? "
			+ "WHERE CONTACT_ID = ?";
	
	String DELETE_CONTACT_INFORMATION_SQL = "DELETE FROM CONTACT WHERE CONTACT_ID = ?";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContactRepositoryImpl.class);
	
	@Override
	public List<Contact> findAllContacts() {
		List<Contact> list = jdbcTemplate.query(GET_ALL_CONTACT_INFORMATION, BeanPropertyRowMapper.newInstance(Contact.class));
		
		LOGGER.info("Retrieving all contact information...");
		
		return list;
	}

	@Override
	public List<Contact> findContactByType(int contactTypeId) {
		List<Contact> list = jdbcTemplate.query(GET_CONTACTS_BY_TYPE, 
				(rs, rowNum) -> new Contact(rs.getInt("CONTACT_ID"),
						rs.getInt("CONTACT_TYPE_ID"),
						rs.getString("EMAIL"),
						rs.getString("FIRSTNAME"),
						rs.getString("LASTNAME"),
						rs.getString("MIDDLE_INITIAL"),
						rs.getString("PHONE")), contactTypeId);
		
		LOGGER.info("Retrieving list of contacts based off contactTypeId: " + contactTypeId);
		
		return list;
	}

	@Override
	public List<Contact> findContactByName(String firstname, String lastname) {
		List<Contact> list = jdbcTemplate.query(GET_CONTACT_BY_NAME, 
				(rs, rowNum) -> new Contact(rs.getInt("CONTACT_ID"),
						rs.getInt("CONTACT_TYPE_ID"),
						rs.getString("EMAIL"),
						rs.getString("FIRSTNAME"),
						rs.getString("LASTNAME"),
						rs.getString("MIDDLE_INITIAL"),
						rs.getString("PHONE")), firstname,lastname);
		
		LOGGER.info("Retrieving list of contacts based off name...");
		
		return list;
	}

	@Override
	public int addContactInformation(Contact contact) {
		
		int result;
		
		int contactTypeId = contact.getContactTypeId();
		String email = contact.getEmail();
		String firstname = contact.getFirstname();
		String lastname = contact.getLastname();
		String middleInitial = contact.getMiddleInitial();
		String phone = contact.getPhone();
		
		result = jdbcTemplate.update(ADD_CONTACT_INFORMATION_SQL, new Object[] {
				contactTypeId, email, firstname, lastname, middleInitial, phone
		});
		
		LOGGER.info("Adding new contact information...");
		
		return result;
	}

	@Override
	public int updateContactInformation(Contact contactDetails, int contactId) {
		int result = 0;
		
		Contact contact = jdbcTemplate.queryForObject(GET_CONTACT_BY_ID_SQL, 
				BeanPropertyRowMapper.newInstance(Contact.class), contactId);
		
		if (contact != null) {
			contact.setContactTypeId(contactDetails.getContactTypeId());
			contact.setEmail(contactDetails.getEmail());
			contact.setFirstname(contactDetails.getFirstname());
			contact.setLastname(contactDetails.getLastname());
			contact.setMiddleInitial(contactDetails.getMiddleInitial());
			contact.setPhone(contactDetails.getPhone());
			
			result = jdbcTemplate.update(UPDATE_CONTACT_INFORMATION_SQL, new Object[] {
					contact.getContactTypeId(),
					contact.getEmail(),
					contact.getFirstname(),
					contact.getLastname(),
					contact.getMiddleInitial(),
					contact.getPhone()
			});
			
		}
		
		LOGGER.info("Updating contact information based off contactId: " + contactId);
		
		return result;
	}

	@Override
	public int deleteContactById(long contactId) {
		int result = 0;
		
		if (contactId != 0) {
			result = jdbcTemplate.update(DELETE_CONTACT_INFORMATION_SQL);
			LOGGER.info("Deleting contact information based off contactId: " + contactId);
		}
		
		return result;
	}

	@Override
	public Contact searchContactById(long contactIdl) {
		Contact contact = new Contact();
		contact = jdbcTemplate.queryForObject(GET_CONTACT_BY_ID_SQL, BeanPropertyRowMapper.newInstance(Contact.class), contactIdl);
		
		return contact;
	}
}
