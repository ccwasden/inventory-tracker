package manager;

import java.util.*; 

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tools.ImportException;

import model.*;

/**
 * Manager for items
 * 
 */
@SuppressWarnings("serial")
public class ItemManager extends Model {
    private TreeSet<Item> _items;
    private TreeSet<Item> _deletedItems;
    private HashMap<Item, StorageUnit> _itemToSUMap;
    private HashMap<Barcode, Item> _barcodeItemMap;
    private static ItemManager ref;
    
    /**
     * Constructs a new ItemManager
     *
     */
    private ItemManager(){
    	_items = new TreeSet<Item>();
    	_deletedItems = new TreeSet<Item>();
    	_itemToSUMap = new HashMap<Item, StorageUnit>();
    	_barcodeItemMap = new HashMap<Barcode, Item>();
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
    public TreeSet<Item> getDeletedItems(){
    	return _deletedItems;
    }
    
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

	public int getNumberItems(){
		return _items.size();
	}
	
    public String toXML() {
        return null;
    }

	public static ItemManager fromJSON(JSONArray jsonArray) throws ImportException, JSONException {
		ItemManager im = inst();
//		System.out.println(im.getNumberItems());
		for(int i = 0; i < jsonArray.length(); i++){
			JSONObject json = jsonArray.getJSONObject(i);
			Item item = Item.fromJSONToSU(json, null, true);
			im.addItem(item);
		}
		return im;
	}

	public void addItem(Item i) {
		if(i.getStorageUnit() == null) _deletedItems.add(i);
		else _items.add(i);
		_barcodeItemMap.put(i.getBarcode(), i);
	}
}
