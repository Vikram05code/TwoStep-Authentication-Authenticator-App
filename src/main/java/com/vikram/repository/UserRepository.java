package com.vikram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vikram.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	
}
