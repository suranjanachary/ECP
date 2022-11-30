package com.masai.service;

import java.util.List;

import com.masai.exception.CategoryException;
import com.masai.exception.LoginException;
import com.masai.exception.ProductException;
import com.masai.model.Category;
import com.masai.model.Product;

public interface CategoryService {

	public List<Category> viewAllCatagories() throws CategoryException,LoginException;
	
	public List<Product> viewProductsCatagoryWise(String category) throws ProductException,LoginException,CategoryException;

    public Category addCategory(Category category, String key) throws CategoryException,LoginException;
	
}
