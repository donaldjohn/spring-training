package com.cog.mappings.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class MappingTest {

	EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("mypersistanceunit");

	
	public static void main(String[] args) {
		MappingTest repository = new MappingTest();
		
		Address address1 = new Address();
		address1.setLocation("Hitech");
		
		Address address2 = new Address();
		address2.setLocation("Madhapur");
		
		Set<Address> addresses = new HashSet<>();
		addresses.add(address1);
		addresses.add(address2);
		
		Employee emp = new Employee();
		emp.setName("Ravi");
		emp.setAddresses(addresses);
		repository.addEmployee(emp);

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

	
}
