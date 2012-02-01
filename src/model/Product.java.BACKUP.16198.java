package model;

import gui.common.SizeUnits;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*; 

<<<<<<< HEAD
import manager.ImportException;

import org.json.JSONException;
import org.json.JSONObject;

=======
import manager.ProductManager;
>>>>>>> fdfb3867d3a4fd7539daec30508a11218963a472
import common.Result;

/**
 * A bar-coded product that can be stored in a StorageUnit.
 * 
 */
@SuppressWarnings("serial")
public class Product extends Model implements Comparable {
	private Timestamp _creationDate;
	private Barcode _barcode;
	private String _description;
	private float _shelfLife;
	private Size _size;
	private int _threeMonthSupply;
//	private String _unitOfMeasurement;
	private ProductContainerList _containers;


	//////////////////////CONSTRUCTORS/////////////////////////////

	/**
	 * Constructs a new Item
	 * @param barcode
	 */
	public Product(Barcode barcode, String description, float shelfLife, Size size,
								int threeMonthSupply) {
		try {
			setBarcode(barcode);
			setDescription(description);
			setShelfLife(shelfLife);
			setSize(size);
			setThreeMonthSupply(threeMonthSupply);
		
			Calendar calendar = Calendar.getInstance();
			java.util.Date now = calendar.getTime();
			setCreationDate(new Timestamp(now.getTime()));
		}
		catch (InvalidDataException e) { }
	}

	public Product(Barcode barcode, String description, float shelfLife, Size size,
						int threeMonthSupply, Timestamp creationDate) {
		try {
			setBarcode(barcode);
			setDescription(description);
			setShelfLife(shelfLife);
			setSize(size);
			setThreeMonthSupply(threeMonthSupply);
			setCreationDate(creationDate);
		}
		catch (InvalidDataException e) { }
		
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
	* intialization by the constructor.
	* @param date A Timestamp with the creation date of this Item.
	*/
	private void setCreationDate(Timestamp date) throws InvalidDataException {
		ProductManager productManager = ProductManager.inst();
		Timestamp earliestItemAddedDate = productManager.getEarliestItemAddedDate(this);
		if (earliestItemAddedDate != date)
			throw new InvalidDataException("Earliest item added date is " +
					"not equal to product creation date");		
		_creationDate = date;
	}

	/**
	* Sets the Barcode for the Product.
	* @param barcode The Product's Barcode.
	*/
	public void setBarcode(Barcode barcode) throws InvalidDataException {
		if (barcode == null || barcode.toString() == "")
			throw new InvalidDataException("Barcode must be non-empty");
		_barcode = barcode;
	}

	/**
	* Sets the Product's description.
	* @param description The Product's description.
	*/
	public void setDescription(String description) throws InvalidDataException {
		if (description == null || description == "")
			throw new InvalidDataException("Description must be non-empty");
		_description = description;
	}

	/**
	* Sets the Product's shelf life.
	* @param shelfLife The Product's shelf life in months.
	*/
	public void setShelfLife(float shelfLife) throws InvalidDataException {
		if (shelfLife <= 0)
			throw new InvalidDataException("Shelf life must be non-negative");
		_shelfLife = shelfLife;
	}

	/**
	* Sets the Product's three month supply.
	* @param threeMonthSupply The Product's ThreeMonthSupply
	*/
	public void setThreeMonthSupply(int threeMonthSupply) throws InvalidDataException {
		if (threeMonthSupply <= 0)
			throw new InvalidDataException("Three month supply must be non-negative");
		_threeMonthSupply = threeMonthSupply;
	}
		
	/**
	 * Sets the size
	 * @param s the size to set
	 */
	public void setSize(Size s) throws InvalidDataException {
		if (s.getSize() <= 0)
			throw new InvalidDataException("Size must be non-negative");
		if (s.getUnits() == SizeUnits.Count && s.getSize() % 1 != 0)
			throw new InvalidDataException("Count value must only be an integer");
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
	public boolean canEditProduct(Product product) {
		return true;
	}

	/**
	* Moves product to a new ProductContainer
	* @param container The container to receive the Product.
	*/
	public boolean moveProduct(ProductContainer container) {
		return false;
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

	public static Product fromJSON(JSONObject jsonObject) throws ImportException, JSONException {
		if(!jsonObject.has("barcode") || !jsonObject.has("description") 
				|| !jsonObject.has("creation-date") || !jsonObject.has("size") 
				|| !jsonObject.has("supply") || !jsonObject.has("shelf-life")) 
			throw new ImportException("<product> misformatted");
		try {
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			Date create = (Date)formatter.parse(jsonObject.getString("creation-date"));
			Product p = new Product(new Barcode(jsonObject.getInt("barcode")), 
					jsonObject.getString("description"),
					(float) jsonObject.getDouble("shelf-life"), 
					Size.fromString(jsonObject.getString("size")),
					jsonObject.getInt("supply"),
					new Timestamp(create.getTime()));
			return p;
		} catch (ParseException e) {
			throw new ImportException("malformatted date");
		}
	}

	@Override
	public int compareTo(Object arg0) {
		return getBarcode().compareTo(((Product)arg0).getBarcode());
	}
}