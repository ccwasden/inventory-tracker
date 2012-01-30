package model;

import java.sql.Timestamp;
import java.util.*; 

/**
 * Manager for items
 * 
 */
@SuppressWarnings("serial")
public class ItemManager extends Model {
    private ItemList _items;
    private HashMap<Item, StorageUnit> _itemToSUMap;
    private static ItemManager ref;
    
    /**
     * Constructs a new ItemManager
     *
     */
    private ItemManager(){}
    
    /**
     * Singleton instance
     * @return the instance
     */
    public static ItemManager getInstance(){
    	if(ref == null) ref = new ItemManager();
    	return ref;
    }
    
    public StorageUnit getStorageUnitOfItem(Item i){
    	return _itemToSUMap.get(i);
    }
    
    /**
     * Constructs a new ItemManager with specified Items 
     *
     */
    public ItemManager(ArrayList<Item> items){}
    
    /**
     * Retrieves a list of deleted items
     * @return ArrayList<Item> The deleted items
     *
     */
    public ArrayList<Item> getDeletedItems(){return null;}
    
    /**
     * Marks an item as deleted
     * @param item Item The deleted item
     *
     */
    public void markDeleted(Item item){}
    
    /**
     * Maps item to a storage unit
     * @param i Item to map
     * @param su StorageUnit to map to
     */
    public void putItemInStorageUnit(Item i, StorageUnit su){
    	_itemToSUMap.put(i, su);
    }
    
    public Item createItem(Barcode barcode, Product product, StorageUnit storageUnit, Timestamp expirationDate){
    	Item i = new Item(barcode, product, storageUnit, expirationDate);
    	_items.addItem(i);
    	return i;
    }
    
    public Item createItem(Barcode barcode, Product product, StorageUnit storageUnit, Timestamp expirationDate,
			Timestamp dateAdded, Timestamp dateRemoved){
    	Item i = new Item(barcode, product, storageUnit, expirationDate, dateAdded, dateRemoved);
    	_items.addItem(i);
    	return i;
    }
    
    /**
	* Static method for unit testing purposes.
	* @return true if success
	*/
	public static boolean Test(){
		return true;
	}
}
