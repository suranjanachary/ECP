package com.masai.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.exception.ProductException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Product;
import com.masai.model.User;
import com.masai.model.UserType;
import com.masai.repository.CurrentUserSessionDao;
import com.masai.repository.ProductDao;
import com.masai.repository.UserDao;

@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;

	@Override
	public Product addProduct(Product product, String key) throws ProductException, LoginException {
		
		Optional<CurrentUserSession> cuss = currentUserSessionDao.findByUuid(key);
		
		if(cuss.isEmpty()) {
			
			throw new LoginException("Admin is not logged in !!!");
			
		}
		
		Optional<User> opt= userDao.findByUsername(cuss.get().getUserName());
		
		if(! opt.get().getUserType().equals(UserType.ADMIN)) {
			throw new LoginException("This Access is only given to Admin");
		}
		
		Product prod = productDao.save(product);
		
		return prod;
	}

	@Override
	public List<Product> viewAllProducts() throws ProductException {
		
		List<Product> products = productDao.findAll();
		
		if(products.size()==0) throw new ProductException("Product List is empty");
			
	    return products;
	}

	@Override
	public Product viewProductById(Integer id) throws ProductException {
		Optional<Product> opt = productDao.findById(id);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			
			throw new ProductException("No products found with this product ID ! Please Provide Valid ProductId");
		}
	}
	
	@Override
	public Product viewProductByName(String name) throws ProductException {
		
		Optional<Product> opt = productDao.findByProductName(name);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			
			throw new ProductException("No products found with this product ID ! Please Provide Valid ProductId");
		}
	}

	@Override
	public Product updateProductById(Product product,String key) throws ProductException, LoginException {
		
		Optional<CurrentUserSession> cuss = currentUserSessionDao.findByUuid(key);
		
		if(cuss.isEmpty()) {
			
			throw new LoginException("Admin is not logged in !!!");
			
		}
		
		Optional<User> opt= userDao.findByUsername(cuss.get().getUserName());
		
		//System.out.println(opt.get().getUserType());
		
		if(!opt.get().getUserType().equals(UserType.ADMIN)) {
			
			throw new LoginException("This Access is only given to Admin");
		}
		
		Optional<Product> opt2 = productDao.findById(product.getProductId());
		
		if(opt2.isEmpty()) {
			throw new ProductException("No products availabale to update with this productID !!!");
		}
		return productDao.save(product);
	}

	@Override
	public Product deleteProductById(Integer id,String key) throws ProductException, LoginException {
		
		Optional<CurrentUserSession> cuss = currentUserSessionDao.findByUuid(key);
		
		if(cuss.isEmpty()) {
			
			throw new LoginException("Admin is not logged in !!!");
			
		}
		
		Optional<User> opt= userDao.findByUsername(cuss.get().getUserName());
		
		if(! opt.get().getUserType().equals(UserType.ADMIN)) {
			
			throw new LoginException("This Access is only given to Admin");
		}
		
		Optional<Product> opt2 = productDao.findById(id);
		
		if(opt2.isPresent()) {
			
			return opt2.get();
		}
		else {
			throw new ProductException("No products availabale to delete with this productID !!!");
		}
	}

	@Override
	public List<Product> viewByPriceLowToHigh() throws ProductException, LoginException {
		
		List<Product> products = productDao.findAll();
		
		if(products.size()==0) throw new ProductException("Product List is empty");
			
	    return products;
	}

	@Override
	public List<Product> viewByPriceHighToLow() throws ProductException, LoginException {
		
		List<Product> products = productDao.findAll();
		
		if(products.size()==0) throw new ProductException("Product List is empty");
			
	    return products;
	}

	
}
