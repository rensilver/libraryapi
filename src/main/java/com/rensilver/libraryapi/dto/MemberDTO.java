package com.rensilver.libraryapi.dto;

import java.io.Serializable;

import com.rensilver.libraryapi.entities.Member;

public class MemberDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String cpf;
	
	public MemberDTO() {
	}
	
	public MemberDTO(Member entity) {
		id = entity.getId();
		name = entity.getName();
		cpf = entity.getCpf();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
