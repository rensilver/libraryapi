package com.rensilver.libraryapi.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rensilver.libraryapi.dto.LoanAuthorDTO;
import com.rensilver.libraryapi.entities.Book;
import com.rensilver.libraryapi.entities.Member;
import com.rensilver.libraryapi.repositories.BookRepository;
import com.rensilver.libraryapi.repositories.MemberRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		memberRepository.deleteAll();
		bookRepository.deleteAll();
		
		Member maria = new Member(null, "Maria Paula", "12455788903");
		Member gustavo = new Member(null, "Gustavo Silva", "07899811405");
		Member rodrigo = new Member(null, "Rodrigo Mendes", "74888936501");
		
		memberRepository.saveAll(Arrays.asList(maria, gustavo, rodrigo));
		
		Book bookOne = new Book(null, "Harry Potter e o Cálice de Fogo", "J.K. Rowling", "Emprestado", new LoanAuthorDTO(maria));
		Book bookTwo = new Book(null, "O Senhor dos Anéis - O Retorno do Rei", "J.R.R. Tolkien", "Emprestado", new LoanAuthorDTO(maria));
		
		bookRepository.saveAll(Arrays.asList(bookOne, bookTwo));
		
		maria.getBooks().addAll(Arrays.asList(bookOne, bookTwo));
		memberRepository.save(maria);
	}

}
