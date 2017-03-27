package com.burger;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.javafx.geom.BaseBounds;

public class Main {
	private static Scanner scanner = new Scanner(System.in) ; 
	private static ArrayList<Baseburger> burgerMenu = new ArrayList<>() ;  
	
	public static void main(String[] args) {	
		burgerMenu.add(new Baseburger(true)) ;    
		burgerMenu.add(new HealthyBurger(true));
		burgerMenu.add(new DeluxeBurger() );
		
		Client betty = new Client("Betty Ross"); 
		int numberChosenByClient = show(burgerMenu); 
		Baseburger burger = getBurger(numberChosenByClient) ; 
		System.out.println(burger.getBurgerName());
		
		//MEAT TYPE 
		System.out.println("Choose meat type : ");
		int choicesOfClient = burger.chooseMeat();
		int meatTypeSelected = scanner.nextInt() ; 
		String meat = burger.processMeatTypeSelection(meatTypeSelected) ; 
		
		//ADDITIONS
		System.out.println("Choose additions : ");
		int numOfPossibleChoices = burger.chooseAdditions() ;
		ArrayList<Integer> selection = getAdditions(numOfPossibleChoices) ; 
		burger.processAdditions(selection) ;
		burger.finalize();
	}
		
	public static ArrayList<Integer> getAdditions(int possibleChoices){
		ArrayList<Integer> choices = new ArrayList<>() ; 
		System.out.println("Enter your choice of additions (1-" + possibleChoices  + ") : " ); 
		System.out.println("( X to finalize order)");
		
		for(int i = 1 ; i <= possibleChoices ; i++){
				if(scanner.hasNext("x")){
					System.out.println("Processing order...");
					break; 
				} 
				choices.add(scanner.nextInt() - 1 );   
			}
		return choices;
	}
	
	public static <E> int show(ArrayList<E> menuItems){
		int i = 1 ; 
		System.out.println("Enter your choice (1-" + menuItems.size()  + ") : "); 
		System.out.println("( X to cancel) " );
		System.out.println("---------------------------------");
		for (E item : menuItems) {
			System.out.println( i + ". " + item.toString() );
			i++ ; 
		}
		return scanner.nextInt();
	}
	
	public static <E> Baseburger getBurger(int i){
		switch (i) {
		case 1:
			return  new Baseburger(true) ; 
		case 2:
			return new HealthyBurger(true) ; 
		case 3:
			return new DeluxeBurger() ; 
		default:
			break;
		}
		return null;
	}
}
 