package com.rensilver.libraryapi.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class LoanDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private LocalDate dateIssued;
	private LocalDate dueDate;
	private LocalDate dateReturned;
	private LoanAuthorDTO loanAuthor;
	
	public LoanDTO() {
	}

	public LoanDTO(LocalDate dateIssued, LocalDate dueDate, LocalDate dateReturned, LoanAuthorDTO loanAuthor) {
		this.dateIssued = dateIssued;
		this.dueDate = dueDate;
		this.dateReturned = dateReturned;
		this.loanAuthor = loanAuthor;
	}

	public LocalDate getDateIssued() {
		return dateIssued;
	}

	public void setDateIssued(LocalDate dateIssued) {
		this.dateIssued = dateIssued;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getDateReturned() {
		return dateReturned;
	}

	public void setDateReturned(LocalDate dateReturned) {
		this.dateReturned = dateReturned;
	}

	public LoanAuthorDTO getLoanAuthor() {
		return loanAuthor;
	}

	public void setLoanAuthor(LoanAuthorDTO loanAuthor) {
		this.loanAuthor = loanAuthor;
	}
}
