package com.rensilver.libraryapi.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rensilver.libraryapi.entities.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Book> searchTitle(String text);
	
	List<Book> findByTitleContainingIgnoreCase(String text);
}
