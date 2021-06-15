package com.rensilver.libraryapi.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rensilver.libraryapi.entities.Member;
import com.rensilver.libraryapi.repositories.MemberRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		memberRepository.deleteAll();
		
		Member maria = new Member(null, "Maria Paula", "12455788903");
		Member gustavo = new Member(null, "Gustavo Silva", "07899811405");
		Member rodrigo = new Member(null, "Rodrigo Mendes", "74888936501");
		
		memberRepository.saveAll(Arrays.asList(maria, gustavo, rodrigo));
		
	}

}
