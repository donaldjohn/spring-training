package com.cog.repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cog.entity.Member;


public class MemberRepository {
	
	
	EntityManagerFactory emf = Persistence.
			 createEntityManagerFactory("mypersistanceunit");
    
//	SessionFactory sesssionFactory = new Configuration().configure().buildSessionFactory();
	public static void main(String[] args) {
		Member member = new Member("priya2@gmail.com", "dskg");
		MemberRepository repository =  new MemberRepository();
		
		repository.addMember(member);
		
//		repository.fetchMember(2);
	}
	
	public void fetchMember(int id){
//		Session session = sesssionFactory.openSession();
		
		EntityManager em = emf.createEntityManager();
	     
		Member member =  em.find(Member.class, id);
		System.out.println(member);
	}
	
	public boolean addMember(Member member) {
		
		EntityManager em = emf.createEntityManager();
//		Session session = sesssionFactory.openSession();
		EntityTransaction transaction = em.getTransaction();
		
		
		em.persist(member);
		
		
		transaction.commit();
		em.close();
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
