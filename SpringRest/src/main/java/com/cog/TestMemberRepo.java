package com.cog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cog.entity.Member;
import com.cog.repo.MemberRepository;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestMemberRepo {
	
	@Autowired
	private MemberRepository repo;

	

//	@Test
	public void testAddMember(){
		Member member = new Member("Ravi");
		repo.addMember(member);
		System.out.println("Test Finished");
	}
	

}
