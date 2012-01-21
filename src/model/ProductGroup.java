package model;

/**
 * A user-defined group of Products. Product Groups are used by users to aggregate 
 * related Products so they can be managed as a collection.
 */
public class ProductGroup extends ProductContainer {

	private float _threeMonthSupply;	
	
	/**
	 * The unit of measurement used in threeMonthSupply (i.e. "pounds", "count", "ounces") 
	 */
	private String _unitOfMeasurement;
		
	// Constructors
	/**
	 * Constructs a new instance of a ProductGroup
	 */
	public ProductGroup() {
		
	}	
	
	// Accessors
	/**
	 * @return The amount of this ProductGroup that's needed for a three
	 * month supply
	 */
	public float getThreeMonthSupply() {
		return _threeMonthSupply;
	}	
	
	/**
	 * @return The unit of measurement used for the three month supply
	 */
	public String getUnitOfMeasurement() {
		return _unitOfMeasurement;
	}	
	
	// Mutators
	/**
	 * Sets the three month supply for this ProductGroup
	 */
	public void setThreeMonthSupply(float threeMonthSupply) {
		_threeMonthSupply = threeMonthSupply;
	}	
	
	/**
	 * Sets the unit of measurement used for the three month supply
	 * for this ProductGroup
	 */
	public void setUnitOfMeasurement(String unitOfMeasurement) {
		_unitOfMeasurement = unitOfMeasurement;
	}	
	
	// Class methods
	/**
	 * Edits the attributes of a particular ProductGroup
	 * @param productGroup The ProductGroup to be edited
	 */
	public void editProductGroup(ProductGroup productGroup) {
		
	}	
	
	/**
	 * Checks to see if a ProductGroup can be edited in a certain way
	 * @param productGroup the ProductGroup to check if it can be edited
	 * @return true if productGroup can be edited, otherwise false
	 */
	public boolean canEditProductGroup(ProductGroup productGroup) {
		return false;
	}	
}
