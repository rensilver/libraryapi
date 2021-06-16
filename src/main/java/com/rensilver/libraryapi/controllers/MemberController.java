package com.rensilver.libraryapi.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rensilver.libraryapi.dto.MemberDTO;
import com.rensilver.libraryapi.entities.Member;
import com.rensilver.libraryapi.exceptions.MemberNotFoundException;
import com.rensilver.libraryapi.services.MemberService;

@RestController
@RequestMapping(value = "/members")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@GetMapping
	public ResponseEntity<List<MemberDTO>> findAll() {
		List<Member> list = memberService.findAll();
		List<MemberDTO> listDto = list.stream().map(x -> new MemberDTO(x)).collect((Collectors.toList()));
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MemberDTO> findById(@PathVariable String id) throws MemberNotFoundException {
		Member member = memberService.findById(id);
		return ResponseEntity.ok().body(new MemberDTO(member));
	}
	
	@PostMapping
	public ResponseEntity<Void> findById(@RequestBody MemberDTO memberDto) {
		Member member = memberService.fromDTO(memberDto);
		member = memberService.insertMember(member);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(member.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable String id) throws MemberNotFoundException {
		memberService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
