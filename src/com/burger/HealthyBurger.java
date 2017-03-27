package com.burger;

import java.util.ArrayList;

public class HealthyBurger<T> extends Baseburger {

	public HealthyBurger(boolean meat) {
		super(false);
		this.basePrice = 2.60 ;
		this.rollType = "brown rye bread" ; 
		this.burgerName = "Healthy Burger" ;
		
		this.meatType = new ArrayList<>() ;
		meatType.add(new Meat("tofu", 2.30)) ;
		meatType.add(new Meat("salmon", 2.80)) ;
		
		this.additions = new ArrayList<>() ;
		additions.add(new Addition("avocado", 1.24)) ;
		additions.add(new Addition("coconut cream", 2.10)) ;
		additions.add(new Addition("berries", 1.65)) ;
	}	
}
