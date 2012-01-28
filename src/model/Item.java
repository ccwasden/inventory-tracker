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
	private Product _product;
//	private StorageUnit _storageUnit;
	private Timestamp _expirationDate;
	private Timestamp _dateAdded;
	private Timestamp _dateRemoved;


	//////////////////////CONSTRUCTORS/////////////////////////////

	/**
	 * Constructor used to create for creating new Items.
	 * @param barcode The associated Barcode
	 * @param product The Product this Item belongs to
	 * @param storageUnit
	 * @param expirationDate
	 */
	public Item(Barcode barcode, Product product, StorageUnit storageUnit, Timestamp expirationDate) {
		setBarcode(barcode);
		setProduct(product);
		setStorageUnit(storageUnit);
		setExpirationDate(expirationDate);
	}


	/**
	 * Constructor used when loading Items from database.
	 * @param barcode The associated Barcode
	 * @param product The Product this Item belongs to
	 * @param storageUnit
	 * @param expirationDate
	 * @param dateAdded
	 * @param dateRemoved
	 */
	public Item(Barcode barcode, Product product, StorageUnit storageUnit, Timestamp expirationDate,
								Timestamp dateAdded, Timestamp dateRemoved ) {
		setBarcode(barcode);
		setProduct(product);
		setStorageUnit(storageUnit);
		setExpirationDate(expirationDate);
		setDateAdded(dateAdded);
		setDateRemoved(dateRemoved);
	}

	//////////////////////ACCESSORS/////////////////////////////

	/**
	* Gets the Item's Barcode.
	* @return The Barcode associated for this Item.
	*/
	public Barcode getBarcode() {
		return _barcode;
	}

	/**
	* Gets the Item's expiration date.
	* @return A Timestamp for the expiration date.
	*/
	public Timestamp getExpirationDate() {
		return _expirationDate;
	}

	/**
	* Gets the Item's date added.
	* @return The Timestamp for the date added.
	*/
	public Timestamp getDateAdded() {
		return _dateAdded;
	}

	/**
	* Gets the Item's date removed.
	* @return The Timestamp for the date when removed, or null if not removed.
	*/
	public Timestamp getDateRemoved() {
		return _dateRemoved;
	}

	/**
	* Gets the Item's Product.
	* @return The Product associated with this Item.
	*/
	public Product getProduct() {
		return _product;
	}

	/**
	* Gets the StorageUnit containing the Item.
	* @return The StorageUnit that this Item is in.
	*/
	public StorageUnit getStorageUnit() {
		return ItemManager.getInstance().getStorageUnitOfItem(this);
	}


	//////////////////////MODIFIERS/////////////////////////////
	/**
	* Updates the Item's Barcode.
	* @param barcode The new Barcode for this Item.
	*/
	public void setBarcode(Barcode barcode) {
		_barcode = barcode;
	}

	/**
	* Updates the Item's expiration date.
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
	
	/**
	 * Set the storage unit
	 * @param su The storage Unit
	 */
	public void setStorageUnit(StorageUnit su){
		ItemManager.getInstance().putItemInStorageUnit(this, su);
	}
	
	/**
	 * Set the product
	 * @param p The Product
	 */
	private void setProduct(Product p){
		_product = p;
	}

	/////////////////////////////////////////////////////////////

	/**
	* Detrmines if the Item is expired.
	* @return True if the Item has expired, else false.
	*/
	public boolean isExpired() {
		return false;
	}

	/**
	* Determines if the Item has been removed.
	* @return True if the Item has been removed, else false.
	*/
	public boolean isRemoved() {
		return _expirationDate != null;
	}

	/**
	* Marks the Item as removed, setting the removed date and removing Item
	* from all StorageUnits.
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
	* Moves this item to another ProductContainer.
	* @param container The new target ProductContainer
	*/
	public void moveItem(ProductContainer container) {
		setStorageUnit(container.getStorageUnit());
		StorageUnitManager.getInstance() // map a product associated with a storage unit in a subcontainer
			.putStorageUnitProductInContainer(getStorageUnit(), _product, container);
	}

	/**
	* Static method for unit testing purposes.
	* @return true if success
	*/
	public static boolean Test(){
		return true;
	}
}