package com.rensilver.libraryapi.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rensilver.libraryapi.dto.LoanAuthorDTO;
import com.rensilver.libraryapi.dto.LoanDTO;
import com.rensilver.libraryapi.entities.Book;
import com.rensilver.libraryapi.entities.Member;
import com.rensilver.libraryapi.repositories.BookRepository;
import com.rensilver.libraryapi.repositories.MemberRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
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
		
		LocalDate dateIssuedOne = LocalDate.parse("10/06/2021", formatter);
		LocalDate dateIssuedTwo = LocalDate.parse("10/07/2021", formatter);
		LocalDate dueDateOne = LocalDate.parse("10/07/2021", formatter);
		LocalDate dueDateTwo = LocalDate.parse("10/08/2021", formatter);
		LocalDate dateReturnedOne = LocalDate.parse("28/06/2021", formatter);
		LocalDate dateReturnedTwo = LocalDate.parse("19/07/2021", formatter);
		LoanDTO loanOne = new LoanDTO(dateIssuedOne, dueDateOne, dateReturnedOne, new LoanAuthorDTO(maria));
		LoanDTO loanTwo = new LoanDTO(dateIssuedTwo, dueDateTwo, dateReturnedTwo, new LoanAuthorDTO(maria));
		
		bookOne.getLoans().addAll(Arrays.asList(loanOne, loanTwo));
		
		bookRepository.saveAll(Arrays.asList(bookOne, bookTwo));
		
		maria.getBooks().addAll(Arrays.asList(bookOne, bookTwo));
		memberRepository.save(maria);
	}
}
