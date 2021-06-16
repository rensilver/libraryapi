package com.rensilver.libraryapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rensilver.libraryapi.entities.Member;
import com.rensilver.libraryapi.exceptions.MemberNotFoundException;
import com.rensilver.libraryapi.repositories.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	public List<Member> findAll() {
		return memberRepository.findAll();
	}
	
	public Member findById(String id) throws MemberNotFoundException {
		Member member = memberRepository.findById(id)
				.orElseThrow(() -> new MemberNotFoundException(id));
		return member;
	}
}
