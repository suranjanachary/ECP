package com.masai.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.masai.model.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]{3,25}", message = "length must be >=3")
	private String username;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]{3,25}", message = "length must be >=3")
	private String password;
	
	@NotNull
	private UserType userType;
}
