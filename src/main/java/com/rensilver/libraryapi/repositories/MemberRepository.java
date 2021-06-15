package com.rensilver.libraryapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rensilver.libraryapi.entities.Member;

public interface MemberRepository extends MongoRepository<Member, String> {

	
}
