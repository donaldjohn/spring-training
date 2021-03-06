import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cog.entity.Member;
import com.cog.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestMemberService {
	
	@Autowired
	private MemberService memberService;

//	@Test
	public void testAddMember(){
		Member member = new Member("ravi1@gmail.com", "kdskd");
	
		boolean result = memberService.addMember(member);
		System.out.println(result);
		assertEquals("member should be added", true, result);
		
	}
	
//	@Test
	public void testFetchMember(){
		String email = "ravi@gmail.com";
	
		Member result = memberService.fetchMember(email);
		System.out.println(result);
		assertEquals("member should be added", "kdskd", result.getPassword());
		
	}
	

	@Test(expected=Exception.class)
	public void testUniqueUser(){
		Member member = new Member("ravi1@gmail.com", "kdskd");
	
		boolean result = memberService.addMember(member);
		System.out.println(result);
		assertEquals("member should be added", true, result);
		
	}
	
	
	

}
