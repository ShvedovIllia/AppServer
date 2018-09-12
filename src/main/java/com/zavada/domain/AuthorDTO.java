package com.zavada.domain;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorDTO {

	@JsonIgnore
	private Long id;
	private String authorId;
	private String firstName;
	private String lastName;
	private String email;
	private String imageUrl;
	private LocalDate dateOfBirth;
	private List<BookDTO> books;
	
}
