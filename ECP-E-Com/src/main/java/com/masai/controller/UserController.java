package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.LoginDTO;
import com.masai.exception.CategoryException;
import com.masai.exception.LoginException;
import com.masai.exception.ProductException;
import com.masai.exception.UserException;
import com.masai.model.Category;
import com.masai.model.CurrentUserSession;
import com.masai.model.Product;
import com.masai.model.User;
import com.masai.service.CategoryService;
import com.masai.service.ProductService;
import com.masai.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UserController {
	
	@Autowired
	private UserService UserService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/reg/User")
	public ResponseEntity<User> regUserHandler (@Valid @RequestBody User a1) throws UserException{
		User user= UserService.registerUser(a1);
		
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/login/User")
	public ResponseEntity<CurrentUserSession> loginUserHandler (@Valid @RequestBody LoginDTO logdto) throws UserException{
		CurrentUserSession cuss= UserService.loginUser(logdto);
		
		return new ResponseEntity<CurrentUserSession>(cuss, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/logout/User")
	public ResponseEntity<String> logoutUserHandler (@RequestParam String key) throws UserException{
		String cuss= UserService.logoutUser(key);
		
		return new ResponseEntity<String>(cuss, HttpStatus.OK);
	}
	
	
	@GetMapping("/view/allproducts")
	public ResponseEntity<List<Product>> viewAllProducts() throws ProductException, LoginException{
		
		List<Product> products= productService.viewAllProducts();
		
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@GetMapping("/view/products/{id}")
	public ResponseEntity<Product> viewProductById(@PathVariable Integer id) throws ProductException, LoginException{
		
		Product product= productService.viewProductById(id);
		
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@GetMapping("/view/products/{name}")
	public ResponseEntity<Product> viewProductByName(@PathVariable String name) throws ProductException, LoginException{
		
		Product product= productService.viewProductByName(name);
		
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	
	@GetMapping("/view/allcatagory")
	public ResponseEntity<List<Category>> viewAllCategory() throws CategoryException, LoginException{
		
		List<Category> catagories= categoryService.viewAllCatagories();
		
		return new ResponseEntity<List<Category>>(catagories,HttpStatus.OK);
	}
	
	@GetMapping("/view/products/catagorywise/{category}")
	public ResponseEntity<List<Product>> viewAllCategory(@PathVariable String category) throws CategoryException, LoginException, ProductException{
		
		List<Product> catagories= categoryService.viewProductsCatagoryWise(category);
		
		return new ResponseEntity<List<Product>>(catagories,HttpStatus.OK);
	}
	
	@GetMapping("/view/products/pricehightolow")
	public ResponseEntity<List<Product>> viewProductsByPriceHighToLow() throws CategoryException, LoginException, ProductException{
		
		List<Product> products= productService.viewByPriceHighToLow();
		
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@GetMapping("/view/products/pricelowtohigh")
	public ResponseEntity<List<Product>> viewProductsByPriceLowToHigh() throws CategoryException, LoginException, ProductException{
		
		List<Product> products= productService.viewByPriceLowToHigh();
		
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	

}
