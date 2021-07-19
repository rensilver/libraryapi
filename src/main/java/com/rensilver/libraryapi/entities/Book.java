package com.rensilver.libraryapi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.rensilver.libraryapi.dto.LoanAuthorDTO;
import com.rensilver.libraryapi.dto.LoanDTO;

@Document
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String title;
	private String author;
	private String status;
	private LoanAuthorDTO loanAuthor;
	
	private List<LoanDTO> loans = new ArrayList<>();
	
	public Book() {
	}

	public Book(String id, String title, String author, String status, LoanAuthorDTO loanAuthor) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.status = status;
		this.loanAuthor = loanAuthor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LoanAuthorDTO getLoanAuthor() {
		return loanAuthor;
	}

	public void setLoanAuthor(LoanAuthorDTO loanAuthor) {
		this.loanAuthor = loanAuthor;
	}
	
	public List<LoanDTO> getLoans() {
		return loans;
	}

	public void setLoans(List<LoanDTO> loans) {
		this.loans = loans;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
