package com.burger;

import java.util.ArrayList;

public class DeluxeBurger extends Baseburger {
	
	public DeluxeBurger() {
		super(true);
		this.rollType = "cheesy fried white bread" ; 
		this.burgerName = "Deluxe Burger" ;
		this.basePrice = 1.09 ;
		this.meatType = new ArrayList<>() ;
		meatType.add(new Meat("beacon", 1.99)) ;
		meatType.add(new Meat("pork sausage", 1.65)) ;
		
		this.additions = new ArrayList<>() ;
		additions.add(new Addition("cheese", .50)) ;
		additions.add(new Addition("double cheese", .55)) ;
		additions.add(new Addition("triple cheese deluxe", .70)) ;
		additions.add(new Addition("barbeque sause", .70)) ;
	}
}
