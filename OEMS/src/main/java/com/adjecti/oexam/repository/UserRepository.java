package com.adjecti.oexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adjecti.oexam.entity.*;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public User findByUserId(String id);

	public User findByUserName(String username);
	
}
