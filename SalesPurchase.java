/**
 * The purpose of Program1 is to develop a system for a fruit vendor to sell fruit, 
 * and to track the total purchases for the day. The purpose of SalesPurchase is to
 * track the list of total items sold per customer sale. 
 * 
 * @author Jeremy Hunton
 */
package edu.tridenttech.cpt237.Hunton.Program1;

//import ArrayList
import java.util.ArrayList;

public class SalesPurchase 
{
	//declare class variables
	ArrayList<PurchaseItem> itemList = new ArrayList<PurchaseItem>();
	
	//declare class constructor
	public SalesPurchase() 
	{
		
	}//end class constructor
	
	//start of SETTER methods
	
	//addItem adds a new PurchaseItem from the PurchaseItem class to our itemList
	public void addItem(PurchaseItem purchaseItem)
	{
		
		itemList.add(purchaseItem);
		
	}//end addItem method
	
	//end of SETTER methods
	
	//start of GETTER methods
	
	//getItemList returns the current list of items that have been added to the itemsList ArrayList
	public ArrayList<PurchaseItem> getItemList()
	{
		return new ArrayList<PurchaseItem>(itemList);
		
	}//end getItemList method
	
	//getTotalCost returns the total cost of all purchased items from our PurchaseItems class
	public double getTotalCost()
	{
		//declare local variable to add to the total cost
		double cost = 0.0;
		
		//use an enhanced for loop to cycle the itemList
		for (PurchaseItem itemList : itemList)
		{
			//add the cost of each object to the current cost
			cost += itemList.calculateCost();
		}//end enhanced for loop
		
		//return the total cost
		return cost;
		
	}//end getTotalCost
	
	//getItemCount gets the item counts from our PurchaseItems counts
	public int getItemCount()
	{
		//the item count is the size of our array since each line item represents a different fruit order.
		return itemList.size();
		
	}//end getItemCount
	
	//getTotalAmount gets the total amount from our PurchaseItems fruit sales and adds them together.
	public double getTotalAmount()
	{
		//declare a local variable to account for our total weight
		double weight = 0.0;
		
		//use an enhanced for loop to cycle the itemList
		for (PurchaseItem itemList : itemList)
		{
			//add the weight of each object to the total weight
			weight += itemList.getAmount();
		}//end enhanced for loop
		
		//return the total weight
		return weight;
	}//end getTotalAmount

}//end of SalesPurchase
