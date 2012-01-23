package model;

import java.util.*; 

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
		
	}

	public Timestamp getExpirationDate() {
		
	}

	public Timestamp getDateAdded() {
		
	}

	public Timestamp getDateRemoved() {
		
	}

	public Product getProduct() {
		
	}

	public StorageUnit getStorageUnit() {
		
	}

	public ProductGroup getProductGroup() {
		
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
		
	}

	public boolean isRemoved() {
		
	}

	public Result remove() {
		
	}

	public Result editItem() {

	}

	public Result canEditItem() {
		
	}

	public void moveItem(ProductContainer container) {

	}

}