package com.cni.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

import com.cni.api.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByNom(String nom);
	
	@Query("SELECT u FROM User u WHERE u.active = 1")
	List<User> findAllActiveUsers();
	
	@Query("SELECT u FROM User u WHERE u.active = 0")
	List<User> findAllInActiveUsers();
	
	List<User> findAllByActive(int active);
}
