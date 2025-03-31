package com.btamayo.A1_Student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class A1StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(A1StudentApplication.class, args);
	}

	private int id;
	private String firstName;
	private String lastName;

	public A1StudentApplication() {}

	public A1StudentApplication(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }

	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
}
