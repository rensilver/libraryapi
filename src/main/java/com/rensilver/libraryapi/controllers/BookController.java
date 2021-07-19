package com.rensilver.libraryapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rensilver.libraryapi.entities.Book;
import com.rensilver.libraryapi.exceptions.BookNotFoundException;
import com.rensilver.libraryapi.services.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> findById(@PathVariable String id) throws BookNotFoundException {
		Book book = bookService.findById(id);
		return ResponseEntity.ok().body(book);
	}
}
