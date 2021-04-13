/**
 * The purpose of Program1 is to develop a system for a fruit vendor to sell fruit, 
 * and to track the total purchases for the day. The purpose of PurchaseItem class is to
 * create individual purchase items for each purchase the customer makes. 
 * 
 * @author Jeremy Hunton
 */
package edu.tridenttech.cpt237.Hunton.Program1;

public class PurchaseItem
{
	//declare class variables
	private String name = "";
	private double price = 0.0;
	private double amount = 0.0;
	
	//declare class constructor. The constructor will be accepting arguments passed by the user
	//inputs in MainClass to create the individual purchase orders
	public PurchaseItem(String fruitName, double fruitPrice, double fruitAmount)
	{
		//assign constructor variables to our object
		this.name = fruitName;
		this.price = fruitPrice;
		this.amount = fruitAmount;
		
	}//end of class constructor PurchaseItem
	
	//start of GETTER methods
	
	//getName returns the name of the item purchased 
	public String getName() 
	{
		return name;
	}//end getName method
	
	//getPrice method returns the price of the item purchased 
	public double getPrice()
	{
		return price;
	}//end getPrice method

	//getAmount method returns the amount (in lbs) of fruit being purchased
	public double getAmount()
	{
		return amount;
	}//end getAmount method
	
	//calculateCost returns the calculated cost of the amount times the price of the item purchased
	public double calculateCost()
	{
		return price * amount;
	}//end calculateCost method
}//end of PurchaseItem
