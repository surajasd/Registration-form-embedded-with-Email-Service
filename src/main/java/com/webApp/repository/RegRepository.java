package com.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webApp.entity.Registration;


public interface RegRepository extends JpaRepository<Registration, Long> {
	
}
