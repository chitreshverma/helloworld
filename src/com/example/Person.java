package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Person {

	@Id
	private int personId;
	private String name;
	private int age;


	@ElementCollection
	private Collection<Address> address=new ArrayList<Address>();
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setAddress(Collection<Address> address) {
		this.address = address;
	}
	public Collection<Address> getAddress() {
		return address;
	}
	
	
}
