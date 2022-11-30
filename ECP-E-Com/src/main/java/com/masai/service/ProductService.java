package com.masai.service;

import java.util.List;

import com.masai.exception.LoginException;
import com.masai.exception.ProductException;
import com.masai.model.Product;

public interface ProductService {

	public Product addProduct(Product product, String key) throws ProductException,LoginException;
	
	public List<Product> viewAllProducts() throws ProductException,LoginException;
	
	public Product viewProductById (Integer id) throws ProductException,LoginException;
	
	public Product viewProductByName (String name) throws ProductException,LoginException;
	
	public Product updateProductById (Product product, String key) throws ProductException,LoginException;
	
	public Product deleteProductById (Integer id, String key) throws ProductException,LoginException;
	
	public List<Product> viewByPriceLowToHigh() throws ProductException,LoginException;
	
	public List<Product> viewByPriceHighToLow() throws ProductException,LoginException;

}
