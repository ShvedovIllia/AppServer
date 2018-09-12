package com.zavada.service;

import java.util.List;

import com.zavada.domain.BookDTO;

public interface BookService {

	void create(BookDTO book);

	BookDTO get(String bookId);

	List<BookDTO> getAll();

	void update(BookDTO book);

}
