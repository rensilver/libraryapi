package com.rensilver.libraryapi.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rensilver.libraryapi.dto.MemberDTO;
import com.rensilver.libraryapi.entities.Member;
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
}
