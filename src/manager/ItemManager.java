package manager;

import java.util.*; 

import org.json.JSONArray;

import model.Item;
import model.Model;
import model.StorageUnit;

/**
 * Manager for items
 * 
 */
@SuppressWarnings("serial")
public class ItemManager extends Model {
    private TreeSet<Item> _items;
    private HashMap<Item, StorageUnit> _itemToSUMap;
    private static ItemManager ref;
    
    /**
     * Constructs a new ItemManager
     *
     */
    private ItemManager(){
    	_itemToSUMap = new HashMap<Item, StorageUnit>();
    	_items = new TreeSet<Item>();
    }
    
    /**
     * Singleton instance
     * @return the instance
     */
    public static ItemManager inst(){
    	if(ref == null) ref = new ItemManager();
    	return ref;
    }
    
    /**
     * Singleton instance
     * @return the instance
     */
    public static ItemManager inst(ItemManager im){
    	if(ref != null) ref = im;
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

	public static ItemManager fromJSON(JSONArray jsonArray) {
		// TODO Implement
		System.out.println("Implement ItemManager::fromJSON");
		return null;
	}
}
