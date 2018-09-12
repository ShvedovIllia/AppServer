package com.zavada.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "books", indexes = @Index(columnList = "title"))
public class BookEntity extends BaseEntity {
	
	@Column(nullable = false, unique = true)
	private String bookId;
	
	@Column(length = 120, nullable = false)
	private String title;
	
	private String description;
	private String imageUrl;
	
	@Column(columnDefinition = "DECIMAL(6,2) DEFAULT '0.00'")
	private BigDecimal price;
	
	private LocalDate publicationYear;
	
	@ManyToMany(mappedBy = "books")
	private List<AuthorEntity> authors = new ArrayList<>();
	
}
