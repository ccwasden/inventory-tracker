package model;

import java.sql.Timestamp;
import java.util.*; 
import common.Result;

/**
 * A bar-coded product that can be stored in a StorageUnit.
 * 
 */
@SuppressWarnings("serial")
public class Product extends Model {
	private Timestamp _creationDate;
	private Barcode _barcode;
	private String _description;
	private float _shelfLife;
	private Size _size;
	private int _threeMonthSupply;
	private String _unitOfMeasurement;
	private ProductContainerList _containers;


	//////////////////////CONSTRUCTORS/////////////////////////////

	/**
	 * Constructs a new Item
	 * @param barcode
	 */
	public Product(Barcode barcode, String description, float shelfLife, Size size,
								int threeMonthSupply, String unitOfMeasurement) {
		
	}

	public Product(Barcode barcode, String description, float shelfLife, Size size,
						int threeMonthSupply, String unitOfMeasurement, Timestamp creationDate) {
		
	}

	//////////////////////ACCESSORS/////////////////////////////

	/**
	* @return A Timestamp with the Product's creation date.
	*/
	public Timestamp getCreationDate() {
		return _creationDate;
	}

	/**
	* @return The Barcode associated with this product.
	*/
	public Barcode getBarcode() {
		return _barcode;
	}

	/**
	* @return The description of this Product.
	*/
	public String getDescription() {
		return _description;
	}

	/**
	* @return The shelf life of this Product.
	*/
	public float getShelfLife() {
		return _shelfLife;
	}

	/**
	* @return The ThreeMonthSupply for this Product.
	*/
	public int getThreeMonthSupply() {
		return _threeMonthSupply;
	}

	/**
	* @return The Unit of measurement for the three month supply.
	*/
	public String getUnitOfMeasurement() {
		return _unitOfMeasurement;
	}

	/**
	* Gets all the ProductContainers with this Product in it.
	* @return The product's containers.
	*/
	public ProductContainerList getContainers() {
		return _containers;
	}

	/**
	* Gets an ItemList of Item's that are instances of this Product.
	* @return The list of Items associated with this product.
	*/
	public ItemList getItems() {
		return null;
	}

	//////////////////////MUTATORS////////////////////////////////

	/**
	* Sets the Product's creation date. This method should only be called upon
	* intialization by the contructor.
	* @param date A Timestamp with the creation date of this Item.
	*/
	private void setCreationDate(Timestamp date) {
		
	}

	/**
	* Sets the Barcode for the Product.
	* @param barcode The Product's Barcode.
	*/
	public void setBarcode(Barcode barcode) {
		
	}

	/**
	* Sets the Product's description.
	* @param description The Product's description.
	*/
	public void setDescription(String description) {
		
	}

	/**
	* Sets the Product's shelf life.
	* @param shelfLife The Product's shelf life in months.
	*/
	public void setShelfLife(float shelfLife) {
		
	}

	/**
	* Sets the Product's three month supply.
	* @param threeMonthSupply The Product's ThreeMonthSupply
	*/
	public void setThreeMonthSupply(int threeMonthSupply) {
		
	}

	/**
	* Edits the product, updating values to those passed in.
	* @param product The Product with updated values.
	* @return A Result indicating success or failure.
	*/
	public Result editProduct(Product product) {
		return null;
	}

	/**
	* Checks to see if see if the edit would be valid.
	* @param product The Product with updated values.
	* @return A Result indicating success or failure.
	*/
	public Result canEditProduct(Product product) {
		return null;
	}

	/**
	* Moves product to a new ProductContainer
	* @param container The container to receive the Product.
	*/
	public Result moveProduct(ProductContainer container) {
		return null;
	}
	
	/**
	* Static method for unit testing purposes.
	* @return true if success
	*/
	public static boolean Test(){
		return true;
	}
}