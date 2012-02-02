package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*; 

import java.sql.Timestamp;

import org.json.JSONException;
import org.json.JSONObject;

import manager.ImportException;
import manager.InventoryTracker;
import manager.ItemManager;
import manager.ProductManager;
import manager.StorageUnitManager;
import common.Result;

/**
 * A physical instance of a particular Product. An Item correpsronds to a physical
 * container with a barcode on it. For example, a case of soda might contain 24
 * cans of Diet Coke. In this case, the Product is, "Diet Coke, 12 fl oz," while
 * each physical can is a distinct Item.
 * 
 */
@SuppressWarnings("serial")
public class Item extends Model implements Comparable<Item>{
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
	public Item(Barcode barcode, Product product, StorageUnit storageUnit, 
			Timestamp expirationDate) {
		try {
			setBarcode(barcode);
			setProduct(product);
			setStorageUnit(storageUnit);
			setExpirationDate(expirationDate);
		
			Calendar calendar = Calendar.getInstance();
			java.util.Date now = calendar.getTime();
			setDateAdded(new Timestamp(now.getTime()));
		} 
		catch (InvalidDataException e) { }
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
		try {
			setBarcode(barcode);
			setProduct(product);
			setStorageUnit(storageUnit);
			setExpirationDate(expirationDate);
			setDateAdded(dateAdded);
			setDateRemoved(dateRemoved);
		}
		catch (InvalidDataException e) { }
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
		return ItemManager.inst().getStorageUnitOfItem(this);
	}


	//////////////////////MODIFIERS/////////////////////////////
	/**
	* Updates the Item's Barcode.
	* @param barcode The new Barcode for this Item.
	*/
	public void setBarcode(Barcode barcode) {
		if(barcode == null)
			barcode = new Barcode(InventoryTracker.inst().generateUPC());
		_barcode = barcode;
	}

	/**
	* Updates the Item's expiration date.
	* @param date The Timestamp for the Item's updated expiration date.
	*/
	public void setExpirationDate(Timestamp date) throws InvalidDataException {
		if (getProduct().getShelfLife() == 0 && date != null)
			throw new InvalidDataException("Cannot set expiration " +
					"date when shelf life isn't specified");
		_expirationDate = date;
	}

	/**
	* This function will only be called internally--date added will either be set in constructor
	* either as a parameter passed in, or created as part of the Item's initialization.
	* @param date The Timestamp for the Item's date added
	*/
	private void setDateAdded(Timestamp date) throws InvalidDataException {
		if (date == null)
			throw new InvalidDataException("Entry date cannot be null");
		if (date.before(_product.getCreationDate()))
			throw new InvalidDataException("Entry date must be after or exactly " +
					"on the product creation date");
		if (date.before(new Timestamp(946727755)))
			throw new InvalidDataException("Date cannot be before 1/1/2000");
		if (date.after(new Timestamp((new java.util.Date()).getTime())))
			throw new InvalidDataException("Date cannot be after today's date");
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
	public void setStorageUnit(StorageUnit su) {
		if(su != null)
			ItemManager.inst().putItemInStorageUnit(this, su);
	}
	
	/**
	 * Set the product
	 * @param p The Product
	 */
	private void setProduct(Product p) throws InvalidDataException {
		if (p == null)
			throw new InvalidDataException("Product must be non-empty");
		_product = p;
	}

	/////////////////////////////////////////////////////////////

	/**
	* Determines if the Item is expired.
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
		return _dateRemoved != null;
	}

	/**
	* Marks the Item as removed, setting the removed date and removing Item
	* from all StorageUnits.
	* @return A Result indicating success or failure.
	* @post The object will no longer be associated with any ProductContainers and
	*		will have a removedDate.
	*/
	public Result remove() {
		return null;
	}

	/**
	* @param item An Item with the new desired values.
	* @return A Result indicating whether or not the parameter is a valid change,
	* 			and a message as to why not if invalid.
	* @post If was able to edit, this Item will now be updated with the values of the parameter.
	*/
	public boolean editItem(Item item) {
		return true;
	}


	/**
	* @param item An Item with the new desired values.
	* @return A Result indicating whether or not the parameter is a valid change,
	* 			and a message as to why not if invalid.
	*/
	public boolean canEditItem(Item item) {
		return true;
	}

	/**
	* Moves this item to another ProductContainer.
	* @param container The new target ProductContainer
	*/
	public void moveItem(ProductContainer container) {
		setStorageUnit(container.getStorageUnit());
		StorageUnitManager.inst() // map a product associated with a storage unit to a container
			.putStorageUnitProductInContainer(getStorageUnit(), getProduct(), container);
	}

	/**
	* Static method for unit testing purposes.
	* @return true if success
	*/
	public static boolean Test(){
		return true;
	}

	// <item product="049000037197" entry-date="06/04/2011" />
	// -or- <item product="041710112881" entry-date="05/14/2011" 
	//				exit-time="05/21/2011 12:01 PM" />
	public String toXML() {
		String xml = "<item product=\"";
		xml += getProduct().getBarcode() + "\" entry-date=\"" + 
			formatDateForXML(getDateAdded()) + "\" ";
		if (isRemoved()) {
			xml += "exit-time=\"" + 
				formatDateTimeForXML(getDateRemoved()) + "\" ";
		}
		xml += "/>";
		return xml;
	}


	public static Item fromJSONToSU(JSONObject json, StorageUnit su, boolean requireExitTime) 
			throws ImportException, JSONException {
		if(!json.has("product") || !json.has("entry-date") 
				|| (requireExitTime && !json.has("exit-time")))
			throw new ImportException("<item> misformatted");
		Barcode b = new Barcode(json.getLong("product"));
		Product p = ProductManager.inst().getProduct(b);
		if(p == null) throw new ImportException("cant find product of specified barcode");
		try {
			Timestamp createdDate;
			createdDate = getDateFromXML(json.getString("entry-date"));
			Timestamp dateRemoved = json.has("exit-time") ? 
				getDateTimeFromXML(json.getString("exit-time")) : null;
			return new Item(null, p, su, null, createdDate, dateRemoved);
		} catch (ParseException e) {
			throw new ImportException("Invalid formatted date in item");
		}
	}

	@Override
	public int compareTo(Item o) {
		return getBarcode().compareTo(o.getBarcode());
	}
}