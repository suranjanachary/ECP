package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CategoryException;
import com.masai.exception.LoginException;
import com.masai.exception.ProductException;
import com.masai.model.Category;
import com.masai.model.CurrentUserSession;
import com.masai.model.Product;
import com.masai.model.User;
import com.masai.model.UserType;
import com.masai.repository.CategoryDao;
import com.masai.repository.CurrentUserSessionDao;
import com.masai.repository.ProductDao;
import com.masai.repository.UserDao;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;
	
	@Autowired
	private UserDao userDao;


	@Override
	public List<Category> viewAllCatagories() throws CategoryException, LoginException {
		
		List<Category> categories = categoryDao.findAll();
		
		if(categories.size()==0) throw new CategoryException("Category List is empty");
			
	    return categories;
	}

	@Override
	public List<Product> viewProductsCatagoryWise(String category) throws ProductException, LoginException, CategoryException {
		
		List<Product> products = categoryDao.viewProductsCatagoryWise(category);
		
		if(products.size()==0) throw new CategoryException("product List is empty");
			
	    return products;
	}

	@Override
	public Category addCategory(Category category, String key) throws CategoryException, LoginException {
		Optional<CurrentUserSession> cuss = currentUserSessionDao.findByUuid(key);
		
		if(cuss.isEmpty()) {
			
			throw new LoginException("Admin is not logged in !!!");
			
		}
		
		Optional<User> opt= userDao.findByUsername(cuss.get().getUserName());
		
		if(! opt.get().getUserType().equals(UserType.ADMIN)) {
			throw new LoginException("This Access is only given to Admin");
		}
		
		Category newcategory = categoryDao.save(category);
		
		return newcategory;

    }

}
