package com.demo.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.demo.cart.Items;

public class Basket {

	private static Map<String, Items> itemMap = new HashMap<String, Items>();
	private static ArrayList<String> itemNames = new ArrayList<String>();

	// Initializing List Items
	static {
		itemNames.add("BANANA");
		itemNames.add("ORANGE");
		itemNames.add("APPLE");
		itemNames.add("LEMON");
		itemNames.add("PEACH");
	}

	public static ArrayList<String> getItemNames() {
		return itemNames;
	}

	public boolean addItem(Items item) throws Exception {
		boolean isAdded = false;
		if (!itemNames.contains(item.getName().toUpperCase()))
			throw new Exception("This item does not exist.");

		if (itemMap.get(item.getName()) != null) {
			Items tempItm = itemMap.get(item.getName());
			tempItm.setQuantity(tempItm.getQuantity() + item.getQuantity());

			isAdded = true;
		} else {
			itemMap.put(item.getName(), item);
			isAdded = true;
		}
		return isAdded;
	}

	public boolean removeItem(String itemName) {
		boolean isRemoved = false;
		if (itemMap.get(itemName) != null) {
			itemMap.remove(itemName);
			System.out.println("Item removed.");
			isRemoved = true;
		} else {
			System.out.println("Item " + itemName + " does not exist.");
		}
		return isRemoved;
	}

	public double printTotalForAllItems() {
		double netTotal = 0;

		Set<String> keyName = itemMap.keySet();
		Iterator<String> itr = keyName.iterator();
		while (itr.hasNext()) {
			Items item = itemMap.get(itr.next());
			System.out.println(item.toString() + " : Total : "
					+ item.getQuantity() * item.getPricePerUnit());
			netTotal += item.getQuantity() * item.getPricePerUnit();
		}
		System.out
				.println("====================================================Net AMount : "
						+ netTotal);
		return netTotal;
	}
}
