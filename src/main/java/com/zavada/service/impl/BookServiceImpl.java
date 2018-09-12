package com.zavada.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zavada.domain.BookDTO;
import com.zavada.entity.BookEntity;
import com.zavada.repository.BookRepository;
import com.zavada.service.BookService;
import com.zavada.service.utils.ObjectMapperUtils;
import com.zavada.service.utils.StringUtils;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private ObjectMapperUtils objectMapper;

	@Autowired
	private StringUtils stringUtils;

	@Override
	public void create(BookDTO book) {
		String bookId = stringUtils.generate();
		
		if(!bookRepository.existsByBookId(bookId)) {
			BookEntity bookEntity = objectMapper.map(book, BookEntity.class);
			bookRepository.save(bookEntity);
		} else {
			// Exception
		}
	}

	@Override
	public BookDTO get(String bookId) {
		BookEntity bookEntity = bookRepository.findByBookId(bookId); 
		// if == null - Add exception
		return objectMapper.map(bookEntity, BookDTO.class);
	}

	@Override
	public List<BookDTO> getAll() {
		List<BookEntity> books = bookRepository.findAll();
		return objectMapper.mapAll(books, BookDTO.class);
	}

	@Override
	public void update(BookDTO book) {

	}

}
