package com.zavada.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zavada.entity.AuthorEntity;

public interface AuthorRepositroy extends JpaRepository<AuthorEntity, Long> {

	AuthorEntity findByAuthorId(String id);
	
	boolean existsByAuthorId(String authorId);
	
	boolean existsByEmail(String email);
}
