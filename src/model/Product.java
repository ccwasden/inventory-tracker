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
		setBarcode(barcode);
		setDescription(description);
		setShelfLife(shelfLife);
		setSize(size);
		setThreeMonthSupply(threeMonthSupply);
		setUnitOfMeasurement(unitOfMeasurement);
		
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		setCreationDate(new Timestamp(now.getTime()));
	}

	public Product(Barcode barcode, String description, float shelfLife, Size size,
						int threeMonthSupply, String unitOfMeasurement, Timestamp creationDate) {
		setBarcode(barcode);
		setDescription(description);
		setShelfLife(shelfLife);
		setSize(size);
		setThreeMonthSupply(threeMonthSupply);
		setUnitOfMeasurement(unitOfMeasurement);
		setCreationDate(creationDate);
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
	public TreeSet<Item> getItems() {
		return null;
	}

	//////////////////////////MUTATORS////////////////////////////////

	/**
	* Sets the Product's creation date. This method should only be called upon
	* intialization by the contructor.
	* @param date A Timestamp with the creation date of this Item.
	*/
	private void setCreationDate(Timestamp date) {
		_creationDate = date;
	}

	/**
	* Sets the Barcode for the Product.
	* @param barcode The Product's Barcode.
	*/
	public void setBarcode(Barcode barcode) {
		_barcode = barcode;
	}

	/**
	* Sets the Product's description.
	* @param description The Product's description.
	*/
	public void setDescription(String description) {
		_description = description;
	}

	/**
	* Sets the Product's shelf life.
	* @param shelfLife The Product's shelf life in months.
	*/
	public void setShelfLife(float shelfLife) {
		_shelfLife = shelfLife;
	}

	/**
	* Sets the Product's three month supply.
	* @param threeMonthSupply The Product's ThreeMonthSupply
	*/
	public void setThreeMonthSupply(int threeMonthSupply) {
		_threeMonthSupply = threeMonthSupply;
	}
	
	/**
	* Sets the Product's unit of measure.
	* @param unitOfMeasure The Product's unitOfMeasure
	*/
	public void setUnitOfMeasurement(String unitOfMeasure) {
		_unitOfMeasurement = unitOfMeasure;
	}
	
	/**
	 * Sets the size
	 * @param s the size to set
	 */
	public void setSize(Size s){
		_size = s;
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
	
	public int hashCode(){
		return _barcode.hashCode();
	}
	
	/**
	* Static method for unit testing purposes.
	* @return true if success
	*/
	public static boolean Test(){
		return true;
	}
}