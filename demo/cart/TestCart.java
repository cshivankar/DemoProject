package com.demo.cart;

import java.util.*;

import junit.framework.Assert;

import org.junit.Test;

public class TestCart {

	@Test
	public void testAddItem() {
		Cart cart = new Cart();

		// Successful Test Case for Adding items
		try {
			Items item1 = new Items("Banana", 2, 3);
			Assert.assertTrue(cart.getBasket().addItem(item1));
			Items item2 = new Items("Orange", 5, 3);
			Assert.assertTrue(cart.getBasket().addItem(item2));
			Items item3 = new Items("Apple", 10, 3);
			Assert.assertTrue(cart.getBasket().addItem(item3));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Successful Test Case for Removing Items
	@Test
	public void testRemoveItem() {
		Cart cart = new Cart();

		Items item1 = new Items("Banana", 2, 3);
		try {
			Assert.assertTrue(cart.getBasket().addItem(item1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertTrue(cart.getBasket().removeItem("Banana"));

		Assert.assertEquals(false, cart.getBasket().removeItem("Banana"));
	}

	// Successful Test Case for Returning Total Cost
	@Test
	public void testTotalAmount() {
		Cart cart = new Cart();
		Items item1 = new Items("Banana", 2, 3);
		Items item2 = new Items("Orange", 5, 3);
		Items item3 = new Items("Apple", 10, 3);

		try {
			cart.getBasket().addItem(item1);
			cart.getBasket().addItem(item2);
			cart.getBasket().addItem(item3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertEquals(51, cart.getBasket().printTotalForAllItems(), 0);
	}

	//Test Case for Exception Handling whileadding Items
	@Test
	public void testAddItemException() {
		Cart cart = new Cart();
		Items item1 = new Items("Banana123", 2, 3);
		try {
			cart.getBasket().addItem(item1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
