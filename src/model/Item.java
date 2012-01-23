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

	public Barcode getBarcode() {
		return null;
	}

	public Timestamp getExpirationDate() {
		return null;		
	}

	public Timestamp getDateAdded() {
		return null;
	}

	public Timestamp getDateRemoved() {
		return null;
	}

	public Product getProduct() {
		return null;
	}

	public StorageUnit getStorageUnit() {
		return null;
	}

	public ProductGroup getProductGroup() {
		return null;
	}

	//////////////////////MODIFIERS/////////////////////////////

	public void setBarcode(Barcode barcode) {
		
	}

	public void setExpirationDate(Timestamp date) {
		
	}

	private void setDateAdded(Timestamp date) {
		
	}

	private void setDateRemoved(Timestamp date) {
		
	}

	/////////////////////////////////////////////////////////////

	public boolean isExpired() {
		return false;
	}

	public boolean isRemoved() {
		return false;
	}

	public Result remove() {
		return null;
	}

	public Result editItem() {
		return null;
	}

	public Result canEditItem() {
		return null;
	}

	public void moveItem(ProductContainer container) {

	}

}