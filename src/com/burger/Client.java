package com.burger;

public class Client {
	private String name ; 
	private int burgerType ; 
	private int[] additions ; 
	
	public Client(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBurgerType() {
		return burgerType;
	}

	public void setBurgerType(int burgerType) {
		this.burgerType = burgerType;
	}

	public int[] getAdditions() {
		return additions;
	}

	public void setAdditions(int[] additions) {
		this.additions = additions;
	}
}
