package com.zavada.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDTO {

	@JsonIgnore
	private Long id;
	private String bookId;
	private String title;
	private String description;
	private String imageUrl;
	private BigDecimal price;
	private LocalDate publicationYear;
	private List<AuthorDTO> authors;
}
