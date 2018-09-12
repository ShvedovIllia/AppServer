package com.zavada.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zavada.domain.AuthorDTO;
import com.zavada.service.AuthorService;

@RestController
@RequestMapping("authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	/*
	{
		"firstName":"Джоан",
		"lastName":"Роулинг",
		"email":"joanne@gmail.com",
		"imageUrl":"https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/J._K._Rowling_2010.jpg/267px-J._K._Rowling_2010.jpg",
		"dateOfBirth":"1965-07-31"
	}
	
	{
		"firstName":"Сти́вен",
		"lastName":"Кинг",
		"email":"stephen@gmail.com",
		"imageUrl":"https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Stephen_King%2C_Comicon.jpg/250px-Stephen_King%2C_Comicon.jpg",
		"dateOfBirth":"1947-09-21"
	}
	*/
	@PostMapping
	public ResponseEntity<Void> addAuthor(@RequestBody AuthorDTO author) {
		authorService.create(author);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<AuthorDTO>> getAuthors() {
		List<AuthorDTO> authors = authorService.getAll();
		return new ResponseEntity<List<AuthorDTO>>(authors, HttpStatus.OK);
	}
	
	@GetMapping("{authorId}")
	public ResponseEntity<AuthorDTO> getAuthor(@PathVariable("authorId") String authorId) {
		AuthorDTO author = authorService.get(authorId);
		return new ResponseEntity<AuthorDTO>(author, HttpStatus.OK);
	}
	
	@GetMapping("check-email")
	public ResponseEntity<Boolean> checkAuthorEmail(@RequestParam("email") String email) {
		return new ResponseEntity<Boolean>(authorService.existsByEmail(email), HttpStatus.OK);
	}
	
	@PostMapping("image/{authorId}")
	public ResponseEntity<Void> uploadImage(
			@PathVariable("authorId") String authorId,
			@RequestParam("image") MultipartFile file) {
		
		authorService.uploadImage(file, authorId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
}