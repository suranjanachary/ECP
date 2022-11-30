package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.masai.model.Category;
import com.masai.model.Product;


public interface CategoryDao extends JpaRepository<Category, Integer> {

	@Query("from Product p where p.categoryName =?1")
	public List<Product> viewProductsCatagoryWise(String category);
}
