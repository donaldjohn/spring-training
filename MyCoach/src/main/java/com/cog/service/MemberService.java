package com.cog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cog.entity.Member;
import com.cog.repo.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository memberRepository;
	
	public boolean addMember(Member member){
		
		return memberRepository.addMember(member);
		
		
	}
	
	
	public Member fetchMember(String email){
		return memberRepository.fetchMember(email);
	}

}
