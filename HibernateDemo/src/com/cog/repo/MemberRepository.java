package com.cog.repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cog.entity.Member;


public class MemberRepository {
	
	SessionFactory sesssionFactory = new Configuration().configure().buildSessionFactory();
	public static void main(String[] args) {
		Member member = new Member("priya2@gmail.com", "dskg");
		MemberRepository repository =  new MemberRepository();
		
//		repository.addMember(member);
		
		repository.fetchMember(2);
	}
	
	public void fetchMember(int id){
		Session session = sesssionFactory.openSession();
		Member member = (Member) session.get(Member.class, id);
		System.out.println(member);
	}
	
	public boolean addMember(Member member) {
		
		
		Session session = sesssionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		
		session.save(member);
		
		
		transaction.commit();
		session.close();
	// JDBC Template Code
		/*String SQL = "insert into member (email, password) values (?,?)";
		int count = jdbcTemplate.update(SQL, member.getEmail(), member.getPassword());
		if(count>=1){
			return true;
		}
		return false;*/
		//Hibernate code
		
		
		
		return false;
	}
	

}
