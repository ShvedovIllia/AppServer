package com.zavada.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zavada.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

	BookEntity findByBookId(String id);
	
	boolean existsByBookId(String bookId);
}
