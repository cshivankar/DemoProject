package com.demo.cart;

import java.awt.event.ItemListener;
import java.io.ObjectInputStream.GetField;
import java.util.*;

public class Cart {
	private static Basket basket = new Basket();

	Scanner sc = new Scanner(System.in);

	public static Basket getBasket() {
		return basket;
	}

	public void displayInputOptions() {
		int choice;
		String tempChoice;
		do {
			System.out.println("1. Display the Item List");
			System.out.println("2. Add item to the cart");
			System.out.println("3. Remove item from the cart");
			System.out.println("4. Calculate total cost");
			System.out.println("5. Exit");
			choice = 0;

			System.out.println("\nEnter your choice :");
			tempChoice = sc.next();

			while (!isNumeric(tempChoice)) {
				System.out
						.println("\nEnter your choice as numeric value 1-5 :");
				tempChoice = sc.next();
				try {
					choice = Integer.parseInt(tempChoice);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}

			choice = Integer.parseInt(tempChoice);

			switch (choice) {
			case 1:
				displayList();
				break;
			case 2:
				addToCart();
				break;
			case 3:
				removeFromCart();
				break;
			case 4:
				calculateCost();
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Invalid selection...");
				break;
			}
		} while (true);

	}

	//To verify whether the entered choice is numeric or not
	public boolean isNumeric(String str) {
		boolean flag = false;
		try {
			Integer.parseInt(str);
			flag = true;
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public void displayList() {
		System.out.println("Item List : " + basket.getItemNames());
	}

	public void addToCart() {
		System.out.println("Enter the item name :");
		String name = sc.next();

		System.out.println("Enter the number of units required :");
		int quantity = sc.nextInt();

		System.out.println("Enter the price per unit :");
		double pricePerUnit = sc.nextDouble();
		Items item = new Items(name, pricePerUnit, quantity);
		try {
			basket.addItem(item);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void calculateCost() {
		basket.printTotalForAllItems();
	}

	private void removeFromCart() {
		// TODO Auto-generated method stub
		System.out.println("Enter the item name :");
		String name = sc.next();
		basket.removeItem(name);
	}
}
