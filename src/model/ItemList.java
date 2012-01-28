package model;

import java.util.SortedSet;

@SuppressWarnings("serial")
public class ItemList extends Model {

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
	
	/**
	 * @return the number of items in this list
	 */
	public int size() {
		return _items.size();
	}
	
	public void addAll(ItemList items) {
		SortedSet<Item> itemSet = items.getItems();
		_items.addAll(itemSet);
	}
		
	public void remove(Item item) {
		_items.remove(item);
	}
	
	/**
	* Static method for unit testing purposes.
	* @return true if success
	*/
	public static boolean Test(){
		return true;
	}
}
