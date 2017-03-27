package com.burger;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Baseburger<T> {
	protected String burgerName; 
	protected String rollType ; 
	protected boolean meat; 
	protected String meatTypeSelectedName;  
	//PRICE CALCULATION FIELDS :  
	protected double basePrice ;  
	protected double meatTypeSelectedPrice ; 
	protected double additionsSelectedPrice ; 
	protected int meatTypeSelected ; 
	protected ArrayList<Integer> additionsSelected; 
	protected ArrayList<Ingredient> additions ; 
	protected ArrayList<Ingredient> meatType;   
	protected ArrayList<Ingredient> chosenAdditions;

	public Baseburger(boolean meat) {
		super();
		this.burgerName = "Base Burger" ;
		this.rollType = "white bread" ; 
		this.basePrice = 2.40 ;   
		this.additionsSelectedPrice = 0.00 ; 
		this.meatTypeSelectedPrice = 0.00 ; 
		this.meat = meat ; 
		//MEATTYPE
		this.meatType = new ArrayList<>() ;  
		if(meat){
			meatType.add(new Meat("pork", 3.45)) ; 
			meatType.add(new Meat("chicken", 3.55)) ; 
			meatType.add(new Meat("turkey", 3.65)) ; 
			meatType.add(new Meat("lobster", 4.50)) ; 
			meatType.add(new Meat("fish", 2.50)) ; 
		}else{
			meatType = null  ; 
		}
		//ADDITIONS
		this.additions = new ArrayList<>() ;
		additions.add(new Addition("lettuce", 1.24)) ; 
		additions.add(new Addition("egg", 1.49)) ; 
		additions.add(new Addition("tomato", 1.89)) ; 
		additions.add(new Addition("ham", 2.19)) ; 
	}
	
	public String calculatePrice(){
		double price = this.basePrice +this.meatTypeSelectedPrice + this.additionsSelectedPrice ; 
		DecimalFormat formatPrice = new DecimalFormat("#.00");
		
		return formatPrice.format(price) ; 
	}
	
	public int chooseAdditions(){
		displayChoice(additions);
		return additions.size() ; 
	}
	
	public int chooseMeat(){
		displayChoice(meatType);
		return meatType.size() ; 
	}
	
	public void displayChoice(ArrayList<Ingredient> ingredientsArray){
		int i = 1 ; 
		for (Ingredient a : ingredientsArray) {
			System.out.println( i + ". " +  a.getName() + "...... $" + a.getPrice() );
			i++ ; 
		}
	}
	
	public  String processMeatTypeSelection(int selection){
		this.meatTypeSelected = selection - 1  ; 
		String meatTypeName = meatType.get(this.meatTypeSelected).getName() ;
		this.meatTypeSelectedPrice = meatType.get(this.meatTypeSelected).getPrice() ; 
		this.meatTypeSelectedName = meatTypeName ;  
		
		return  meatTypeName ; 
	}
	
	public void processAdditions(ArrayList<Integer> selection) {
		this.additionsSelected = selection ;
		for (Integer i : selection) {
			//System.out.println(additions.get(i).getName());
			this.additionsSelectedPrice += additions.get(i).getPrice() ; 
		}
	}
	
	public void showAddtionsSelected(){
		for (Integer i : this.additionsSelected) {
			System.out.print(additions.get(i).getName()); 
			if (i == this.additionsSelected.size()-1){
				System.out.print(". ");
			}else{
				System.out.print(", ");
			}
		}
	}

	public String getBurgerName() {
		return burgerName;
	}

	public void finalize(){
		showFinalOrder() ; 
		System.out.println("\n" + "Price : $" + calculatePrice() );
	}
	
	public void showFinalOrder(){
		System.out.println("\n" + "Your order : ");
		System.out.println( this.getBurgerName() + " with " +  this.getRollType() + 
				 " with " + this.getMeatTypeSelectedName() + " and additions of ") ;  
		this.showAddtionsSelected() ;
	}
 	
	@Override
	public String toString() {
		return  burgerName ;
	}

	public ArrayList<Ingredient> getMeatType() {
		return meatType;
	}

	public void setMeatType(ArrayList<Ingredient> meatType) {
		this.meatType = meatType;
	}

	public int getMeatTypeSelected() {
		return meatTypeSelected;
	}

	public void setMeatTypeSelected(int meatTypeSelected) {
		this.meatTypeSelected = meatTypeSelected;
	}

	public String getMeatTypeSelectedName() {
		return meatTypeSelectedName;
	}

	public void setMeatTypeSelectedName(String meatTypeSelectedName) {
		this.meatTypeSelectedName = meatTypeSelectedName;
	}

	public String getRollType() {
		return rollType;
	}
}
