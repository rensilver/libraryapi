package com.rensilver.libraryapi.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rensilver.libraryapi.entities.Member;

@RestController
@RequestMapping(value = "/members")
public class MemberController {

	@GetMapping
	public ResponseEntity<List<Member>> findAll() {
		Member maria = new Member("1", "Maria Paula", "12456678903");
		Member gustavo = new Member("2", "Gustavo Silva", "05644799802");
		List<Member> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, gustavo));
		return ResponseEntity.ok().body(list);
	}
}
