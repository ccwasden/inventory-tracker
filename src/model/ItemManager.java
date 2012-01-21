package model;

import java.util.*; 

/**
 * Manager for items
 * 
 */
public class ItemManager {
    private ArrayList<Item> _items;
    
    /**
     * Constructs a new ItemManager
     *
     */
    public ItemManager(){}
    
    /**
     * Constructs a new ItemManager with specified Items 
     *
     */
    public ItemManager(ArrayList<Item> items){}
    
    /**
     * Retrieves a list of deleted items
     * 
     * @return ArrayList<Item> The deleted items
     *
     */
    public ArrayList<Item> getDeletedItems(){return null;}
    
    /**
     * Marks an item as deleted
     * 
     * @param item Item The deleted item
     *
     */
    public void markDeleted(Item item){}
}
