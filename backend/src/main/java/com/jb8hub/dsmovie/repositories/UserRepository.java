package com.jb8hub.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jb8hub.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
	
}
