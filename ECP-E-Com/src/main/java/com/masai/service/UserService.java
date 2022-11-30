package com.masai.service;

import java.util.List;

import com.masai.dto.LoginDTO;
import com.masai.exception.UserException;
import com.masai.model.CurrentUserSession;
import com.masai.model.User;

public interface UserService {

	public User registerUser(User user) throws UserException;
	
	public CurrentUserSession loginUser(LoginDTO user) throws UserException;
	
	public String logoutUser(String key) throws UserException;
	
	public User deleteCustomer(Integer customerId) throws UserException;
		
	public User viewCustomerById(Integer customerId) throws UserException;
	
	public List<User> viewAllCustomer() throws UserException;
	
	
 
}
