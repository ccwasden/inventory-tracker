package model;

import java.sql.Timestamp;
import java.util.*; 
import common.Result;

/**
 * A bar-coded product that can be stored in a StorageUnit.
 * 
 */
public class Product {
	private Timestamp _creationDate;
	private Barcode _barcode;
	private String _description;
	private float _shelfLife;
	private int _threeMonthSupply;

	/**
	 * Constructs a new Item
	 *
	 */
	public Product(Barcode barcode, String description, float shelfLife, int threeMonthSupply) {
		
	}

	public Product(Barcode barcode, String description, float shelfLife,
									int threeMonthSupply, Timestamp creationDate) {
		
	}

	//////////////////////ACCESSORS/////////////////////////////

	public Timestamp getCreationDate() {
		return null;
	}

	public Barcode getBarcode() {
		return null;
	}

	public String getDescription() {
		return null;
	}

	public float getShelfLife() {
		return 0;
	}

	public int threeMonthSupply() {
		return 0;
	}

	//////////////////////MODIFIERS//////////////////////////////

	public void setCreationDate(Timestamp date) {
		
	}

	public void setBarcode(Barcode barcode) {
		
	}

	public void setDescription(String description) {
		
	}

	public void setShelfLife(float shelfLife) {
		
	}

	public void setThreeMonthSupply(int threeMonthSupply) {
		
	}

	public void editProduct() {
		
	}

	public Result canEditProduct() {
		return null;
	}

	public Result moveProduct() {
		return null;
	}

	public ItemList getItems() {
		return null;
	}
}