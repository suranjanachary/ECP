package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.exception.ProductException;
import com.masai.model.Product;

public interface CartService {

	public Product addToCart(Product product, String key) throws ProductException,LoginException;
	
	public Product updateCart (Product product, String key) throws ProductException,LoginException;
	
	public Product viewCart() throws ProductException,LoginException;
	
	public Product checkOutCart() throws ProductException,LoginException;
	
	public Product calcUnitPrice() throws ProductException,LoginException;
	
	public Product calcTotalPrice() throws ProductException,LoginException;
}
