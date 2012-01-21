package model;

import java.util.*; 

class Barcode{ } // DELETE THIS LINE WHEN HAVE A BARCODE CLASS
/**
 * Manager for all storage units
 * 
 */
public class StorageUnitManager {
    private ItemManager _itemManager;
    private ProductManager _productManager;
    private ArrayList<StorageUnit> _storageUnits;
    
    /**
     * Constructs a new StorageUnitManager
     *
     */
    public StorageUnitManager(){}
    
    /**
     * Retrieves the length of the document (number of characters)
     * 
     * @param unit (StorageUnit) The unit to add to the list
     * 
     * @return true if successfully added, else false
     *
     */
    public boolean addStorageUnit(StorageUnit unit){return false;}
    
    /**
     * Removes StorageUnit specified
     * 
     * @param unit (StorageUnit) The unit to delete
     *
     */    
    public void deleteStorageUnit(StorageUnit unit){}
    
    /**
     * Retrieves the storage unit of the associated name
     * 
     * @param name (String) The name of the storage unit to get
     * 
     * @return StorageUnit The unit with the passed in name
     *
     */    
    public StorageUnit getStorageUnit(String name){return null;}
    
    /**
     * Retrieves all Storage Units 
     *
     * @return ArrayList<StorageUnit> The list of all storage units
     */    
    public ArrayList<StorageUnit> getAllStorageUnits(){return null;}
    
    /**
     * Getter for the product manager
     *
     * @return ProductManager The Product Manager
     */
    public ProductManager getProductManager(){return null;}
    
    /**
     * Getter for the item manager
     *
     * @return ItemManager The Item Manager
     */
    public ItemManager getItemManager(){return null;}
    
    /**
     * Removes Item
     * 
     * @param item (Item) The item to remove
     *
     */    
    public void removeItem(Item item){}
    
    /**
     * Get Item of associated barcode
     * 
     * @param barcode (Barcode) The barcode of the item to retrieve
     *
     * @return Item The item of the barcode passed in
     */    
    public Item getItem(Barcode barcode){return null;}
    
    /**
     * Retrieves all items that apply to the filter
     * 
     * @param filter (ItemFilter) The filter to run on each item
     *
     * @return ArrayList<Item> The list of items that apply to the filter
     */    
    public ArrayList<Item> getItemsOfFilter(ItemFilter filter){return null;}
    
}
