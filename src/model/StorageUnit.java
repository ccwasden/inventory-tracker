package model;

import java.util.SortedSet;

/**
 * A StorageUnit is a room, closet, pantry, cupboard, or some other
 * enclosed area where items can be stored.
 */
@SuppressWarnings("serial")
public class StorageUnit extends ProductContainer {
	
	private ItemList _items;
	private StorageUnitManager _storageUnitManager;
	
	// Constructors
	/**
	 * Constructs a new instance of StorageUnit
	 */
	public StorageUnit() {
		super("");
	}
	
	public StorageUnit(String name) {
		super(name);
	}	
	
	// Accessors
	/**
	 * @return The Items this StorageUnit contains
	 */
	public ItemList getItems() {
		return _items;
	}	
	
	/** 
	 * @return The StorageUnitManager this StorageUnit contains
	 */
	public StorageUnitManager getStorageUnitManager() {
		return _storageUnitManager;
	}
	
	// Mutators
	/**
	 * Sets the Items this StorageUnit contains
	 */
	public void setItems(ItemList items) {
		_items = items;
	}	
	
	/**
	 * Sets the StorageUnitManager this StorageUnit contains
	 */
	public void setStorageUnitManager(StorageUnitManager storageUnitManager) {
		_storageUnitManager = storageUnitManager;
	}
	
	// Class Methods
	/**
	 * Adds Items to this StorageUnit
	 * @param items The collection of items to be added
	 * @return The number of items that were added
	 */
	public int addItems(ItemList items) {
		int prevSize = _items.size();
		_items.addAll(items);
		return (_items.size() - prevSize);
	}	
	
	/**
	 * Checks to see if a particular collection of Items can be added
	 * @param items The collection of Items to check if they can be added
	 * @return true if the items can be added, otherwise false
	 */
	public boolean canAddItems(ItemList items) {
		return false;
	}	
	
	/**
	 * Edits the attributes of this StorageUnit
	 * @param items The new set of items to be associated with this
	 * StorageUnit
	 * @param name The new name to be associated with this StorageUnit
	 */
	public void editStorageUnit(String name, SortedSet<Item> items) {
		
	}	
	
	/**
	 * Checks to see if this StorageUnit can be edited in a particular way
	 * @return true if this StorageUnit can be edited, otherwise false
	 */
	public boolean canEditStorageUnit() {
		return false;
	}	
	
	/**
	 * Removes an Item from this StorageUnit
	 * @param item The Item to be removed
	 */
	public void removeItem(Item item) {
		_items.remove(item);
	}	
	
	/**
	 * Checks to see if an Item can be removed from this StorageUnit
	 * @param item The Item to check if it can be removed
	 * @return true if item can be removed, otherwise false
	 */
	public boolean canRemoveItem(Item item) {
		return false;
	}	
	
	/**
	 * Adds a new product to this StorageUnit, and is called when an item 
	 * is trying to be added but has no product associated with it yet.
	 * @param product The product to be added
	 */
	public void addProduct(Product product) {
		
	}	
	
	/**
	 * Transfers a collection of Items to a different ProductContainer
	 * @param items The collection of Items to be transferred
	 * @param productContainer The ProductContainer where items should be 
	 * transferred
	 */
	public int transferItems(SortedSet<Item> items, 
			ProductContainer productContainer) {
		return 0;
	}	
		
	/**
	 * @param product The Product to return all of its associated Items
	 * @return the Items associated with a given Product
	 */
	public SortedSet<Item> getItemsOfProduct(Product product) {
		return null;
	}
	
	/**
	 * Return all the Items in this StorageUnit that apply to a filter
	 * @param itemFilter The filter to apply to the Items
	 * @return A collection of Items that apply to itemFilter
	 */
	public SortedSet<Item> getItemsOfFilter(ItemFilter itemFilter) {
		return null;
	}	

	/**
	* Static method for unit testing purposes.
	* @return true if success
	*/
	public static boolean Test(){
		return true;
	}
}
