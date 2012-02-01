package model;

import java.util.TreeSet;

import manager.StorageUnitManager;

/**
 * A StorageUnit is a room, closet, pantry, cupboard, or some other
 * enclosed area where items can be stored.
 */
@SuppressWarnings("serial")
public class StorageUnit extends ProductContainer {
	
	private TreeSet<Item> _items;
	private StorageUnitManager _sUnitManager;
	
	// Constructors
	/**
	 * Constructs a new instance of StorageUnit
	 */
	public StorageUnit(String name) {
		super(name);
		_items = new TreeSet<Item>();
		_sUnitManager = StorageUnitManager.inst();
	}	
	
	// Accessors
	/**
	 * @return The Items this StorageUnit contains
	 */
	public TreeSet<Item> getItems() {
		return _items;
	}	
	
	// Mutators
	/**
	 * Sets the Items this StorageUnit contains
	 */
	public void setItems(TreeSet<Item> items) {
		_items = items;
	}	
	
	// Class Methods
	/**
	 * Adds Items to this StorageUnit
	 * @param items The collection of items to be added
	 * @return The number of items that were added
	 */
	public int addItems(TreeSet<Item> items) {
		int prevSize = _items.size();
		_items.addAll(items);
		return (_items.size() - prevSize);
	}	
	
	/**
	 * Adds Item to this StorageUnit
	 * @param item The item to be added
	 * @return false if not added
	 */
	public boolean addItem(Item item) {
		_ensureProductIsInSubUnit(item.getProduct());
		return _items.add(item);
	}	
	
	private void _ensureProductIsInSubUnit(Product p){
		boolean notYetAssociated = (null == _sUnitManager.getProductContainerOfSUProd(this, p));
		if(notYetAssociated) _sUnitManager.putStorageUnitProductInContainer(this, p, this);
	}
	/**
	 * Checks to see if a particular collection of Items can be added
	 * @param items The collection of Items to check if they can be added
	 * @return true if the items can be added, otherwise false
	 */
	public boolean canAddItems(TreeSet<Item> items) {
		// As far as the model is concerned, I'm pretty sure you can always add items
		return true;
	}	
	
	/**
	 * Edits the attributes of this StorageUnit
	 * @param items The new set of items to be associated with this
	 * StorageUnit
	 * @param name The new name to be associated with this StorageUnit
	 */
	public void editStorageUnit(String name, TreeSet<Item> items) {
		try {
			setName(name);
			setItems(items);
		}
		catch (InvalidDataException e) { }
	}	
	
	/**
	 * Checks to see if this StorageUnit can be edited in a particular way
	 * @return true if this StorageUnit can be edited, otherwise false
	 */
	public boolean canEditStorageUnit(String name) {
		if (name == "")
			return false;
		// Make sure to also have a check above this to make sure that there
		// are no other StorageUnits with the same name
		return true;
	}	
	
	/**
	 * Removes an Item from this StorageUnit
	 * @param item The Item to be removed
	 */
	public void removeItem(Item item) {
		if (canRemoveItem(item))
			_items.remove(item);
	}	
	
	/**
	 * Checks to see if an Item can be removed from this StorageUnit
	 * @param item The Item to check if it can be removed
	 * @return true if item can be removed, otherwise false
	 */
	public boolean canRemoveItem(Item item) {
		// I'm pretty sure you can always remove an item without checking anything
		return true;
	}	
	
	/**
	 * Adds a new product to this StorageUnit, and is called when an item 
	 * is trying to be added but has no product associated with it yet.
	 * @param product The product to be added
	 */
	public void addProduct(Product product) {
		getProducts().add(product);
	}	
	
	/**
	 * Transfers a collection of Items to a different ProductContainer
	 * @param items The collection of Items to be transferred
	 * @param productContainer The ProductContainer where items should be 
	 * transferred
	 */
	public int transferItems(TreeSet<Item> items, 
			ProductContainer productContainer) {

		return 0;
	}	
		
	/**
	 * @param product The Product to return all of its associated Items
	 * @return the Items associated with a given Product
	 */
	public TreeSet<Item> getItemsOfProduct(Product product) {
		return null;
	}
	
	/**
	 * Return all the Items in this StorageUnit that apply to a filter
	 * @param itemFilter The filter to apply to the Items
	 * @return A collection of Items that apply to itemFilter
	 */
	public TreeSet<Item> getItemsOfFilter(ItemFilter itemFilter) {
		return null;
	}

	/**
	* Static method for unit testing purposes.
	* @return true if success
	*/
	public static boolean Test(){
		return true;
	}

	public String toXML() {
		return null;
	}
}
