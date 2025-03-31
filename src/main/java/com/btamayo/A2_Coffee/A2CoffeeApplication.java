package com.btamayo.A2_Coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class A2CoffeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(A2CoffeeApplication.class, args);
	}

	private int id;
	private String name;
	private String type;

	public A2CoffeeApplication() {}

	public A2CoffeeApplication(int id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getType() { return type; }
	public void setType(String type) { this.type = type; }
}

