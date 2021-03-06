package com.cog.mappings.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="emp_id")
	private Long id;
	
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL,
			fetch = FetchType.EAGER,
			mappedBy="employee")
	Set<Address> addresses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	/*@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", addresses="
				+ addresses + "]";
	}*/
	
	

}
