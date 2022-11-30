package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CategoryException;
import com.masai.exception.LoginException;
import com.masai.exception.ProductException;
import com.masai.model.Category;
import com.masai.model.Product;
import com.masai.service.CategoryService;
import com.masai.service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AdminController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProductHandler (@Valid @RequestBody Product p1, @RequestParam String key) throws ProductException, LoginException{
		Product product= productService.addProduct(p1,key);
		
		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update/product")
	public ResponseEntity<Product> updateProductHandler(@Valid @RequestBody Product product, @RequestParam String key) throws ProductException, LoginException{
		
		Product updProduct = productService.updateProductById(product, key);
		
		return new ResponseEntity <Product>(updProduct,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/products/{id}")
	public ResponseEntity<Product> deleteProductById(@PathVariable Integer id, @RequestParam String key) throws ProductException, LoginException{
		
		Product product= productService.deleteProductById(id, key);
		
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	
	// add category
	
	@PostMapping("/add/category")
	public ResponseEntity<Category> addCategoryHandler (@Valid @RequestBody Category c1, @RequestParam String key) throws CategoryException, LoginException{
		Category category= categoryService.addCategory(c1, key);
		
		return new ResponseEntity<Category>(category, HttpStatus.CREATED);
	}
	


}
