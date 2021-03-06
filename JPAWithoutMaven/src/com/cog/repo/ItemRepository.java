package com.cog.repo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cog.entity.Bid;
import com.cog.entity.Employee;
import com.cog.entity.Item;
import com.cog.entity.Member;

public class ItemRepository {

	EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("mypersistanceunit");

	// SessionFactory sesssionFactory = new
	// Configuration().configure().buildSessionFactory();
	public static void main(String[] args) {
		ItemRepository repository = new ItemRepository();
		/*Member member = new Member("priya2@gmail.com", "dskg");
		repository.addMember(member);*/
		Bid bid1 = new Bid();
		Bid bid2 = new Bid();
		
		
		Item item = new Item();
		item.setName("IPhone");
		
		bid1.setItem(item);
		bid2.setItem(item);
		
		Set<Bid> bids = new HashSet<>();
		bids.add(bid1);
		bids.add(bid2);
		
		item.setBids(bids);
		
		repository.addItem(item);
		
	}

	

	public void addItem(Item item) {
		EntityManager em = emf.createEntityManager();
		// Session session = sesssionFactory.openSession();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		em.persist(item);

		transaction.commit();
		em.close();
	}

	public void fetchMember(int id) {
		// Session session = sesssionFactory.openSession();

		EntityManager em = emf.createEntityManager();

		Member member = em.find(Member.class, id);
		System.out.println(member);
	}

	public boolean addMember(Member member) {

		EntityManager em = emf.createEntityManager();
		// Session session = sesssionFactory.openSession();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		em.persist(member);

		transaction.commit();
		em.close();
		// JDBC Template Code
		/*
		 * String SQL = "insert into member (email, password) values (?,?)"; int
		 * count = jdbcTemplate.update(SQL, member.getEmail(),
		 * member.getPassword()); if(count>=1){ return true; } return false;
		 */
		// Hibernate code

		return false;
	}

}
