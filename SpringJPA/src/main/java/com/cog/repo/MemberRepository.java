package com.cog.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cog.entity.Member;

@Repository
public class MemberRepository {
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void addMember(Member member)
	{
		em.persist(member);
		System.out.println("After persist");
		
	}
	
	public Member findMember(long id)
	{
		Member member = em.find(Member.class, id);
		return member;
		
	}
	
	public Member findMemberByName(String name)
	{
		TypedQuery<Member> query = em.createNamedQuery("findMemberByName", Member.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}

}
