package com.electric.auth.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electric.auth.entity.AuthUser;

public interface AuthRepository extends JpaRepository<AuthUser, Integer>{

	Optional<AuthUser> findByUsername(String username);
   // boolean existsByEmail(String username);
}
