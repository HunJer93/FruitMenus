/**
 * The purpose of Program1 is to develop a system for a fruit vendor to sell fruit, 
 * and to track the total purchases for the day. MainClass provides the inputs and 
 * outputs for the program.
 * 
 * @author Jeremy Hunton
 */

package edu.tridenttech.cpt237.Hunton.Program1;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass 
{
	
	//declare class CONSTANTS 
	public static final String[] FRUIT_MENU_OPTIONS = {"Apples", "Blueberries", "Cantaloupes", "Peaches", "Strawberries", "Complete the transaction"};
	public static final double[] FRUIT_PRICES = {2.00, 3.00, 3.25, 2.50, 2.00};
	public static final char[] FRUIT_MENU_CHARS = {'A', 'B', 'C', 'P', 'S', 'Q'};
	public static final char[] MAIN_MENU_CHARS = {'A', 'X'};
	public static final String[] MAIN_MENU_OPTIONS = {"Add a new Customer Purchase", "Exit the program"};

	public static void main(String[] args) 
	{
		//declare and initialize scanner object
		Scanner input = new Scanner(System.in);
		
		//declare class variables
		char menuSelection = ' ';
		double quantity = 0.0;
		int fruitListIndex = 0;
		
		//declare SalesPurchase ArrayList to store the sales purchases 
		ArrayList<SalesPurchase> totalSales = new ArrayList<SalesPurchase>();
		
	/**	//declare a new SalesPurchase class object
		SalesPurchase salesPurchase = new SalesPurchase(); **/
		
		//display welcome message
		displayWelcomeMessage();
		
		//main menu selection
		menuSelection = validateMainMenu(input);
		
		//while loop that the main menu exit option isn't selected. 
		while(menuSelection != 'X')
		{
			//declare a new SalesPurchase class object
			SalesPurchase salesPurchase = new SalesPurchase();
			
			//request inputs in fruit menu
			menuSelection = validatePurchaseMenu(input);
			
			//while loop repeating the purchase menu
			while(menuSelection != 'Q')
			{
				
				//request quantity of fruit 
				quantity = validateHowManyLbs(input);
				
				//selection structure for each menu option
				if(menuSelection == 'A')
				{
					//assign fruit list index to 0
					fruitListIndex = 0;
					
					//create a new purchase item object
					//pass the variables in the fruit menu, fruit price, and quantity
					PurchaseItem purchase = new PurchaseItem(FRUIT_MENU_OPTIONS[fruitListIndex], FRUIT_PRICES[fruitListIndex], quantity);
					
					//add this new item to the sales purchase array list
					salesPurchase.addItem(purchase); 
				}//end purchase menu selection A
				
				//else if menu selection B is selected
				else if(menuSelection == 'B')
				{
					//assign fruit list index to 1
					fruitListIndex = 1;
					
					//create a new purchase item object using the PurchaseItem constructor
					PurchaseItem purchase = new PurchaseItem(FRUIT_MENU_OPTIONS[fruitListIndex], FRUIT_PRICES[fruitListIndex], quantity);
					
					//add this new object to the sales purchase array list
					salesPurchase.addItem(purchase);
				}//end purchase menu selection B
				
				//else if menuSelection C is selected
				else if(menuSelection == 'C')
				{
					//assign fruit list index to 2
					fruitListIndex = 2;
					//create a new purchase item object using the PurchaseItem constructor
					PurchaseItem purchase = new PurchaseItem(FRUIT_MENU_OPTIONS[fruitListIndex], FRUIT_PRICES[fruitListIndex], quantity);
					
					//add this new object to the sales purchase array list
					salesPurchase.addItem(purchase);
				}//end purchase menu selection C
				
				//else if menuSelection P is selected
				else if(menuSelection == 'P')
				{
					//assign fruit list index to 3
					fruitListIndex = 3;
					
					//create a new purchase item object using the PurchaseItem constructor
					PurchaseItem purchase = new PurchaseItem(FRUIT_MENU_OPTIONS[fruitListIndex], FRUIT_PRICES[fruitListIndex], quantity);
					
					//add this new object to the sales purchase array list
					salesPurchase.addItem(purchase);
				}//end purchase menu selection P
				
				//else the menu selection is S
				else
				{
					//assign the fruit list index to 4
					fruitListIndex = 4;
					
					//create a new purchaseItem object using the PurchaseItem constructor
					PurchaseItem purchase = new PurchaseItem(FRUIT_MENU_OPTIONS[fruitListIndex], FRUIT_PRICES[fruitListIndex], quantity);
					
					//add this new object to the sales purchase array list
					salesPurchase.addItem(purchase);
				}//end else purchase menu selection S
				
				//redisplay purchase menu
				menuSelection = validatePurchaseMenu(input);
			}//end of purchase menu (aka fruit menu)
			
			//display the individuals purchase item list using displayPurchaseReceipt
			displayPurchaseReceipt(salesPurchase.getItemList());
			
			//add the salesPurchase to the totalSales ArrayList
			totalSales.add(salesPurchase);
			
			
			//re-display main menu
			menuSelection = validateMainMenu(input);
			
		}//end of main menu exit option
		
		//display the daily summary of fruit totals using the totalSales ArrayList
		displayDailySummary(totalSales);
		
		//display the final report 
		displayPurchaseHistory(totalSales);
		
		//display farewell message to end the program
		displayFarewell();
		
		//close the Scanner object
		input.close();
	}//end of Main Method

	
	//declare VOID METHODS 
	
	//displayWelcomeMessage displays a welcome message
	private static void displayWelcomeMessage()
	{
		System.out.println("~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~");
		System.out.println("Welcome to the fruit processor. Please use the following");
		System.out.println("menus to process the customer's order. At the end of each");
		System.out.println("order, a receipt will be printed out for the customer.");
		System.out.println("\nAt the end of the day, a final report will be printed");
		System.out.println("out that has the total items sold per fruit, the total");
		System.out.println("sales for the day, and a list of each individual sale.");
	}//end displayWelcomeMessage
	
	//displayMainMenu displays the main menu to be called in validateMainMenu VR method
	private static void displayMainMenu()
	{
		System.out.println("\n~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~");
		System.out.println("MAIN MENU");
		System.out.println("~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~");
		
		//for loop to cycle menu options
		for (int i=0; i < MAIN_MENU_CHARS.length; i++)
		{
			System.out.printf("%-2c%-2s%-28s\n", MAIN_MENU_CHARS[i], ")", MAIN_MENU_OPTIONS[i]);
		}//end for loop cycling menu options
	}//end displayMainMenu
	
	//displayPurchaseMenu displays the fruit purchase menu to be called in the validatePurchaseMenu VR method
	private static void displayPurchaseMenu()
	{
		//declare local index
		int index = 0;
		
		//display menu title
		System.out.println("\n~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~");
		System.out.println("PURCHASE MENU");
		System.out.println("~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~");
		
		//while loop to cycle the fruit menu. I am using a while loop vs a for loop to prevent an error with my loop
		//and the last menu option
		while(index < FRUIT_PRICES.length)
		{
			System.out.printf("%-2c%-2s%-12s%2s%4.2f\n", FRUIT_MENU_CHARS[index], ")", FRUIT_MENU_OPTIONS[index], "$", FRUIT_PRICES[index]);
			
			//increment index 
			index++;
		}//end fruit menu for loop
	
		//display quit menu option
		System.out.printf("%-2c%-2s%-25s\n", FRUIT_MENU_CHARS[index], ")", FRUIT_MENU_OPTIONS[index]);
	}//end displayPurchaseMenu
	
	//displayPurchaseReceipt displays the customer's purchase receipt
	private static void displayPurchaseReceipt(ArrayList<PurchaseItem> itemList)
	{
		//declare a local variable for the total sold
		double totalSold = 0.0;
		
		//display purchase receipt title
		System.out.println("\n~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~");
		System.out.println("PURCHASE RECEIPT");
		System.out.println("~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~");
		System.out.printf("%-14s%6s%8s%9s\n","Item", "Lbs", "Price", "Cost");
		
		// for loop cycling the purchase items in the itemList array
		for(int i = 0; i < itemList.size(); i++)
		{
			PurchaseItem purchase = itemList.get(i);
			//print out the line item at the index
			System.out.printf("%-14s%6.1f%2s%5.2f%2s%8.2f\n",purchase.getName(), purchase.getAmount(), "$",purchase.getPrice(), "$", purchase.calculateCost());
			
			//accumulate total sold to get grand total 
			totalSold += purchase.calculateCost();
		}//end of for loop cycling the itemList
		
		//display total amount and cost
		
		System.out.printf("\n%-14s%15s%8.2f\n", "Total:","$", totalSold);
	}//end displayPurchaseReceipt
	
	//displayDailySummary displays the fruit that was purchased throughout the day
	private static void displayDailySummary(ArrayList<SalesPurchase> totalSales)
	{
		//create local variables for each fruit type. These will be accumulated to get the fruit totals. 
		//also, create total weight and sales variables
		//apples
		double applesCost = 0.0;
		double applesWeight = 0.0 ;
		double applesSales = 0.0;
		//blueberries
		double blueberryCost= 0.0;
		double blueberryWeight = 0.0;
		double blueberrySales = 0.0;
		//cantaloupes
		double cantaCost = 0.0;
		double cantaWeight = 0.0;
		double cantaSales = 0.0;
		//peaches
		double peachesCost = 0.0;
		double peachesWeight = 0.0;
		double peachesSales = 0.0;
		//strawberries
		double strawCost = 0.0;
		double strawWeight = 0.0;
		double strawSales = 0.0;
		//totals
		double totalWeight = 0.0;
		double finalSalesTotal = 0.0;
		
		//print daily summary title
		System.out.println("\n~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~");
		System.out.println("Daily Summary");
		System.out.println("~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~\n");
		System.out.printf("%-14s%-7s%8s%14s\n", "Fruit", "Cost", "Lbs Sold", "Total Sales");
		
		//enhanced for loop cycling the totalSales ArrayList. Once each array is cycled, the purchase items can be retrieved from the 
		//PurchaseItems list and accumulated to the local variables above.
		for(SalesPurchase salesPurchase : totalSales)
		{
			//get the item list from each salesPurchase and assign it to the local receipt 
			ArrayList<PurchaseItem> localReceipt = salesPurchase.getItemList();
			
			//for loop cycling the purchases (fruit) in each SalesPurchase list
			for(int i = 0; localReceipt.size() > i; i++)
			{
				//selection structure to test if the item from the list is an apple
				if(localReceipt.get(i).getName() == FRUIT_MENU_OPTIONS[0])
				{
					//accumulate the value of the item to the local fruit Apple
					applesCost += localReceipt.get(i).getPrice();
					applesWeight += localReceipt.get(i).getAmount();
					applesSales += localReceipt.get(i).calculateCost();
					
					//accumulate the total weight and sales
					totalWeight += applesWeight;
					finalSalesTotal += applesSales;
				}//end item is an apple
				
				//selection structure to test if the item is a blueberry
				else if(localReceipt.get(i).getName() == FRUIT_MENU_OPTIONS[1])
				{
					//accumulate the value of the item to the local fruit Blueberry
					blueberryCost += localReceipt.get(i).getPrice();
					blueberryWeight += localReceipt.get(i).getAmount();
					blueberrySales += localReceipt.get(i).calculateCost();
					
					//accumulate the total weight and sales
					totalWeight += blueberryWeight;
					finalSalesTotal += blueberrySales;
				}//end item is a blueberry
				
				
				//selection structure to test if the item is a cantaloupe
				else if(localReceipt.get(i).getName() == FRUIT_MENU_OPTIONS[2])
				{
					//accumulate the value of the item to the local fruit Cantaloupe
					cantaCost += localReceipt.get(i).getPrice();
					cantaWeight += localReceipt.get(i).getAmount();
					cantaSales += localReceipt.get(i).calculateCost();
					
					//accumulate the total weight and sales
					totalWeight += cantaWeight;
					finalSalesTotal += cantaSales;
				}//end item is a cantaloupe
				
				//selection structure to test if the item is a Peach
				else if(localReceipt.get(i).getName() == FRUIT_MENU_OPTIONS[3])
				{
					//accumulate the value of the item to the local fruit Peaches
					peachesCost += localReceipt.get(i).getPrice();
					peachesWeight += localReceipt.get(i).getAmount();
					peachesSales += localReceipt.get(i).calculateCost();
					
					//accumulate the total weight and sales
					totalWeight += peachesWeight;
					finalSalesTotal += peachesSales;
				}//end item is a Peach
				
				//else selection structure to test if the item is a Strawberry
				else
				{
					//accumulate the value of the item to the local fruit Strawberry
					strawCost += localReceipt.get(i).getPrice();
					strawWeight += localReceipt.get(i).getAmount();
					strawSales += localReceipt.get(i).calculateCost();
					
					//accumulate the total weight and sales
					totalWeight += strawWeight;
					finalSalesTotal += strawSales;
				}//end item is a Strawberry
			}//end of SalesPurchase cycle
		}//end of for loop cycling each salesPurchase list
		
		//display fruit totals 
		System.out.printf("%-14s%2s%4.2f%8.1f%4s%10.2f\n", "Apples", "$", applesCost, applesWeight, "$", applesSales);
		System.out.printf("%-14s%2s%4.2f%8.1f%4s%10.2f\n", "Blueberries", "$", blueberryCost, blueberryWeight, "$", blueberrySales);
		System.out.printf("%-14s%2s%4.2f%8.1f%4s%10.2f\n", "Cantaloupes", "$", cantaCost, cantaWeight, "$", cantaSales);
		System.out.printf("%-14s%2s%4.2f%8.1f%4s%10.2f\n", "Peaches", "$", peachesCost, peachesWeight, "$", peachesSales);
		System.out.printf("%-14s%2s%4.2f%8.1f%4s%10.2f\n", "Strawberries", "$", strawCost, strawWeight, "$", strawSales);
		System.out.printf("\n%-14s%14.1f%4s%10.2f\n", "Total", totalWeight, "$", finalSalesTotal);
	}//end displayDailySummary
	
	//displayPurchaseHistory method displays the total purchase receipt for the day using the totalSales ArrayList
	private static void displayPurchaseHistory(ArrayList<SalesPurchase> totalSales)
	{
		//declare a local variable for the total cost
		int totalItems = 0;
		double grandTotalSales = 0;
		
		//display purchase receipt title
		System.out.println("\n~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~");
		System.out.println("Daily Summary (cont.)");
		System.out.println("~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~\n");
		System.out.println("Purchase History\n");
		System.out.printf("%-13s%9s\n","Amt Sold", "Purchase");
		
		//enhanced for loop cycling the totalSales ArrayList
		for(SalesPurchase salesPurchase : totalSales)
		{
			//display the purchase amount and the total cost of each order
			System.out.printf("%-13d%2s%7.2f\n", salesPurchase.getItemList().size(), "$", salesPurchase.getTotalCost());
			
			//accumulate the totalItems, and grandTotalSales
			totalItems += salesPurchase.getItemCount();
			grandTotalSales += salesPurchase.getTotalCost();
		}//end of enhanced for loop
		
		//display the final daily totals (using totalSales.size for total number of purchases)
		System.out.printf("\n%-23s\n", "Daily Totals");
		System.out.printf("\n%-23s%6d\n", "Total Items Purchased:", totalItems);
		System.out.printf("%-23s%6d\n", "Total Purchases:", totalSales.size());
		System.out.printf("%-21s%2s%6.2f\n", "Total Sales:", "$", grandTotalSales);
	}//end displayPurchaseHistory method
	
	
	//displayFarewell informs the user that the program has concluded
	private static void displayFarewell()
	{
		System.out.println("\n~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~");
		System.out.println("This concludes the program for the day. Now shutting down.");
		System.out.println("Have a great day!");
	}//end displayFarewell
	
	//end of VOID METHODS
	
	//start of VR methods
	
	//validateMainMenu calls the displayMainMenu and validates the input
	private static char validateMainMenu(Scanner input)
	{
		//declare local char
		char localSelection = ' ';
		
		//display main menu
		displayMainMenu();
		
		//request input
		System.out.print("\nPlease enter your selection here:");
		localSelection = input.next().toUpperCase().charAt(0);
		
		//validate input
		while(localSelection != 'A' && localSelection != 'X')
		{
			//display error
			System.out.println("\n~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~");
			System.out.println("ERROR. This is not a valid input. Returning to main menu.");
			System.out.println("~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~");
			
			//display main menu
			displayMainMenu();
			
			//request input
			System.out.print("\nPlease enter your selection here:");
			localSelection = input.next().toUpperCase().charAt(0);
		}//end validation loop
		
		//return localSelection 
		return localSelection;
	}//end validateMainMenu
	
	//validatePurchaseMenu displays and validates the purchase menu input
	private static char validatePurchaseMenu(Scanner input)
	{
		//declare local char
		char localSelection = ' ';
		
		//display purchase menu
		displayPurchaseMenu();
		
		//request input
		System.out.print("\nPlease enter your selection here:");
		localSelection = input.next().toUpperCase().charAt(0);
		
		//validate input
		while(localSelection != 'A' && localSelection != 'B' && localSelection != 'C' && localSelection != 'P' && localSelection != 'S' && localSelection != 'Q')
		{
			//display error
			System.out.println("\n~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~");
			System.out.println("ERROR. This is not a valid input. Returning to the purchase");
			System.out.println("menu.");
			System.out.println("~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~");
			
			//display purchase menu
			displayPurchaseMenu();
			
			//request input
			System.out.print("\nPlease enter your selection here:");
			localSelection = input.next().toUpperCase().charAt(0);
		}//end validation loop
		
		//return localSelection 
		return localSelection;
	}//end validatePurchaseMenu
	
	//validateHowManyLbs request and validates how many pounds of fruit are being purchased
	private static double validateHowManyLbs(Scanner input)
	{
		//declare local variable
		double howManyLbs = 0.0;
		
		//request input
		System.out.print("\nHow many pounds (lbs) do you wish to purchase:");
		howManyLbs = input.nextDouble();
		
		//validate the input
		while(howManyLbs <=0)
		{
			//display error
			System.out.println("\n~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~");
			System.out.println("ERROR. This is not a valid input. Returning to weight input.");
			System.out.println("~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~ ~~~~~");
			
			//request input
			System.out.print("\nHow many pounds (lbs) do you wish to purchase:");
			howManyLbs = input.nextDouble();
		}//end validation loop
		
		//return howManyLbs
		return howManyLbs;
	}//end validateHowManyLbs
}//end of MainClass
