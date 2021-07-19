package com.rensilver.libraryapi.dto;

import java.io.Serializable;

import com.rensilver.libraryapi.entities.Member;

public class LoanAuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	public LoanAuthorDTO() {
	}
	
	public LoanAuthorDTO(Member obj) {
		id = obj.getId();
		name = obj.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
