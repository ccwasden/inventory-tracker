package model;

import java.util.SortedSet;

public class ItemList {

	private SortedSet<Item> _items;

	public ItemList(SortedSet<Item> items) {
		_items = items;
	}

	/**
	 * @return The items in this list
	 */
	public SortedSet<Item> getItems() {
		return _items;
	}

	/**
	 * Sets the items in this list
	 * @param items
	 */
	public void setItems(SortedSet<Item> items) {
		_items = items;
	}
	
}
