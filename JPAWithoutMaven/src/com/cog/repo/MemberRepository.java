package com.cog.repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cog.entity.Address;
import com.cog.entity.Employee;
import com.cog.entity.Member;

public class MemberRepository {

	EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("mypersistanceunit");

	// SessionFactory sesssionFactory = new
	// Configuration().configure().buildSessionFactory();
	public static void main(String[] args) {
		MemberRepository repository = new MemberRepository();
		/*Member member = new Member("priya2@gmail.com", "dskg");
		repository.addMember(member);*/
		
		Address address = new Address(13, "GK", "Delhi");
		Employee emp = new Employee(null, address);
		
//		repository.addEmployee(emp);
		repository.findEmployee(1);

		// repository.fetchMember(2);
	}

	private void findEmployee(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		
		Employee employee = em.find(Employee.class, id);
		System.out.println(employee);
		
		
		
		transaction.commit();
		em.close();
		
		employee.setName("Ravi");
		
	}

	public void addEmployee(Employee emp) {
		EntityManager em = emf.createEntityManager();
		// Session session = sesssionFactory.openSession();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		em.persist(emp);

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
