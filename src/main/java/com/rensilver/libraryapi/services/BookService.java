package com.rensilver.libraryapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rensilver.libraryapi.entities.Book;
import com.rensilver.libraryapi.exceptions.BookNotFoundException;
import com.rensilver.libraryapi.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public Book findById(String id) throws BookNotFoundException {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new BookNotFoundException(id));
		return book;
	}
	
	public List<Book> findByTitle(String text) {
		return bookRepository.findByTitleContainingIgnoreCase(text);
	}
}
