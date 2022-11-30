package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.CurrentUserSession;

public interface CurrentUserSessionDao extends JpaRepository<CurrentUserSession, Integer> {

 public Optional<CurrentUserSession> findByUserName(String userName);
 
 public Optional<CurrentUserSession> findByUuid (String uuid);
}
