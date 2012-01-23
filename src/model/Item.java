package model;

import java.sql.Timestamp;
import java.util.*; 
import common.Result;

/**
 * A physical instance of a particular Product. An Item correpsronds to a physical
 * container with a barcode on it. For example, a case of soda might contain 24
 * cans of Diet Coke. In this case, the Product is, "Diet Coke, 12 fl oz," while
 * each phsyical can is a distinct Item.
 * 
 */
public class Item {
	private Barcode _barcode;
	private Timestamp _expirationDate;
	private Timestamp _dateAdded;
	private Timestamp _dateRemoved;
	private Product _product;
	private StorageUnit _storageUnit;


	/**
	 * Constructs a new Item
	 *
	 */
	public Item(Barcode barcode, Timestamp expirationDate){
		
	}

	public Item(Barcode barcode, Timestamp expirationDate, Timestamp dateAdded){
		
	}

	public Item(Barcode barcode, Timestamp expirationDate,
								Timestamp dateAdded, Timestamp dateRemoved ){
		
	}

	//////////////////////ACCESSORS/////////////////////////////

	/**
	* @return The Barcode associated for this Item.
	*/
	public Barcode getBarcode() {
		return _barcode;
	}

	/**
	* @return A Timestamp for the expiration date.
	*/
	public Timestamp getExpirationDate() {
		return _expirationDate;
	}

	/**
	* @return The Timestamp for the date added.
	*/
	public Timestamp getDateAdded() {
		return _dateAdded;
	}

	/**
	* @return The Timestamp for the date when removed, or null if not removed.
	*/
	public Timestamp getDateRemoved() {
		return _dateRemoved;
	}

	/**
	* @return The Product associated with this Item.
	*/
	public Product getProduct() {
		return _product;
	}

	/**
	* @return The StorageUnit that this Item is in.
	*/
	public StorageUnit getStorageUnit() {
		return _storageUnit;
	}

	/**
	* @return The ProductGroup this Item is associated with.
	*/
	public ProductGroup getProductGroup() {
		return _productGroup;
	}

	//////////////////////MODIFIERS/////////////////////////////
	/**
	* @param barcode The new Barcode for this Item.
	*/
	public void setBarcode(Barcode barcode) {
		_barcode = barcode;
	}

	/**
	* @param date The Timestamp for the Item's updated expiration date.
	*/
	public void setExpirationDate(Timestamp date) {
		_expirationDate = date;
	}

	/**
	* This function will only be called internally--date added will either be set in constructor
	* either as a parameter passed in, or created as part of the Item's initialization.
	* @param date The Timestamp for the Item's date added
	*/
	private void setDateAdded(Timestamp date) {
		_dateAdded = date;
	}

	/**
	* This function will only be called internally--date added will either be set in constructor
	* either as a parameter passed in, or will be set when remove() is called.
	* @param date The Timestamp for the Item's date removed, or null if not removed
	*/
	private void setDateRemoved(Timestamp date) {
		_dateRemoved = date;
	}

	/////////////////////////////////////////////////////////////

	/**
	* @return True if the Item has expired, else false.
	*/
	public boolean isExpired() {
		return false;
	}

	/**
	* @return True if the Item has been removed, else false.
	*/
	public boolean isRemoved() {
		return _expirationDate != null;
	}

	/**
	* Marks the Item as removed, setting the removed date and removing Item
	* from all ProductContainers.
	* @retun A Result indicating success or failure.
	* @post The object will no longer be associated with any ProductContainers and
	*		will have a removedDate.
	*/
	public Result remove() {
		return null;
	}

	/**
	* @param item An Item with the new desired values.
	* @return A Result indicating whether or not the paramater is a valid change,
	* 			and a message as to why not if invalid.
	* @post If was able to edit, this Item will now be updated with the values of the parameter.
	*/
	public Result editItem(Item item) {
		return null;
	}


	/**
	* @param item An Item with the new desired values.
	* @return A Result indicating whether or not the paramater is a valid change,
	* 			and a message as to why not if invalid.
	*/
	public Result canEditItem(Item item) {
		return null;
	}

	/**
	* @param container The new target ProductContainer
	*/
	public void moveItem(ProductContainer container) {

	}
}