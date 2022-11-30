package com.masai.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.dto.LoginDTO;
import com.masai.exception.UserException;
import com.masai.model.CurrentUserSession;
import com.masai.model.User;
import com.masai.repository.UserDao;
import com.masai.repository.CurrentUserSessionDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao UserDao;
	
	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;

	@Override
	public User registerUser(User user) throws UserException {
		
	  Optional<User> opt = UserDao.findByUsername(user.getUsername());
	
	  if(opt.isPresent()) {
		  throw new UserException("User Already exist with this User-Name");
	  }
	  return UserDao.save(user);
	}

	@Override
	public CurrentUserSession loginUser(LoginDTO User) throws UserException {
		Optional<CurrentUserSession> opt = currentUserSessionDao.findByUserName(User.getUsername());
		
		if(opt.isPresent()) {
			throw new UserException("User Already Logged in");
		}
		
		Optional<User> opt2 = UserDao.findByUsername(User.getUsername());
		
		if(opt2.isEmpty()) {
			throw new UserException("No User found with this username");
		}
		
		if(! opt2.get().getUserType().equals(User.getUserType())) {
			
			throw new UserException("No user type found");
		}
		
		CurrentUserSession ret= null;
		if(opt2.get().getUsername().equals(User.getUsername()) && opt2.get().getPassword().equals(User.getPassword())) {
			
			CurrentUserSession cuss = new CurrentUserSession();
			
			cuss.setLocalDateTime(LocalDateTime.now());
			cuss.setUuid(UUID.randomUUID().toString());
			cuss.setUserName(User.getUsername());
			
			ret= currentUserSessionDao.save(cuss);
		}
		else if(opt2.get().getUsername().equals(User.getUsername()) && ! opt2.get().getPassword().equals(User.getPassword())) {
			
			throw new UserException("Invalid Credentials !!!");
		}
		
	   return ret;
	}

	@Override
	public String logoutUser(String key) throws UserException {
		
		Optional<CurrentUserSession> opt = currentUserSessionDao.findByUuid(key);
		
		if(opt.isEmpty()) {
			throw new UserException("User is not logged-in");
		}
		
		currentUserSessionDao.delete(opt.get());
		
		return "Logged out Successfully !!!";
	}


	@Override
	public User deleteCustomer(Integer customerId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User viewCustomerById(Integer customerId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> viewAllCustomer() throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public User registerUser(User user) throws UserException {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	

	
}
