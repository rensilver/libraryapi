package com.rensilver.libraryapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rensilver.libraryapi.dto.MemberDTO;
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
	
	public Member insertMember(Member entity) {
		return memberRepository.insert(entity);
	}
	
	public Member update(Member entity) throws MemberNotFoundException {
		Member obj = findById(entity.getId());
		updateData(obj, entity);
		return memberRepository.save(obj);
	}

	public void deleteById(String id) throws MemberNotFoundException {
		findById(id);
		memberRepository.deleteById(id);
	}
	
	private void updateData(Member obj, Member entity) {
		obj.setName(entity.getName());
		obj.setCpf(entity.getCpf());
	}
	
	public Member fromDTO(MemberDTO memberDto) {
		return new Member(memberDto.getId(), memberDto.getName(), memberDto.getCpf());
	}
}
