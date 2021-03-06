package com.cog.mappings.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cog.repo.HotelRoom;


public class MappingTest {

	EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("mypersistanceunit");

	
	public static void main(String[] args) {
		MappingTest repository = new MappingTest();
		
		Employee emp = new Employee();
		emp.setName("Ravi");
		
		Address address1 = new Address();
		address1.setLocation("Hitech");
		address1.setEmployee(emp);
		
		Address address2 = new Address();
		address2.setLocation("Madhapur");
		address2.setEmployee(emp);
		
		Set<Address> addresses = new HashSet<>();
		addresses.add(address1);
		addresses.add(address2);
		
		
		emp.setAddresses(addresses);
//		repository.addAddress(address1);
//		repository.addEmployee(emp);
//		repository.findEmployee(1l);
		
		
		
		repository.bookRoom();
	}
	
	public void bookRoom() {
		EntityManager em = emf.createEntityManager();
		// Session session = sesssionFactory.openSession();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		/*HotelRoom room = new HotelRoom();
		room.setRoomsLeft(2);*/
		
		HotelRoom room = em.find(HotelRoom.class, 1);
		room.setRoomsLeft(room.getRoomsLeft() - 1);
		
		transaction.commit();
		em.close();
	}
	
	public void findEmployee(long id) {
		
		EntityManager em = emf.createEntityManager();
		// Session session = sesssionFactory.openSession();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		Employee employee = em.find(Employee.class, id);
		System.out.println(employee.getName());
		
//		System.out.println(employee.getAddresses()); 
		
		/*employee.setName("Kumar");
		Set<Address> addresses = employee.addresses;
	
		Address newAddress = new Address();
		newAddress.setLocation("GK");
		addresses.add(newAddress);*/

		transaction.commit();
		em.close();
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
	
	public void addAddress(Address address) {
		EntityManager em = emf.createEntityManager();
		// Session session = sesssionFactory.openSession();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		em.persist(address);

		transaction.commit();
		em.close();
	}

	
}
