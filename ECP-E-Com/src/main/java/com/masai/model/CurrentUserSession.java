package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class CurrentUserSession {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String userName;
	
	private LocalDateTime localDateTime;
	
	private String uuid;

	public CurrentUserSession(String userName, LocalDateTime localDateTime, String uuid) {
		super();
		this.userName = userName;
		this.localDateTime = localDateTime;
		this.uuid = uuid;
	}
	
	
}
