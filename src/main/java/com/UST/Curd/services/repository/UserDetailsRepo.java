package com.UST.Curd.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.UST.Curd.services.dao.UserDetails;

public interface UserDetailsRepo extends JpaRepository<UserDetails, String> {
	@Query(value = "Select (`role`) from user_details where email = ?1", nativeQuery = true)
	public String findRoleByEmail(String email);
}
