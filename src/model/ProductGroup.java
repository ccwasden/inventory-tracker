package model;

/**
 * A user-defined group of Products. Product Groups are used by users to aggregate 
 * related Products so they can be managed as a collection.
 */
@SuppressWarnings("serial")
public class ProductGroup extends ProductContainer {

	private Size _threeMonthSupply;	
			
	// Constructors
	/**
	 * Constructs a new instance of a ProductGroup
	 */
	public ProductGroup(String name) {
		super(name);
	}	
	
	// Accessors
	/**
	 * @return The amount of this ProductGroup that's needed for a three
	 * month supply
	 */
	public Size getThreeMonthSupply() {
		return _threeMonthSupply;
	}	
		
	// Mutators
	/**
	 * Sets the three month supply for this ProductGroup
	 */
	public void setThreeMonthSupply(Size threeMonthSupply) {
		_threeMonthSupply = threeMonthSupply;
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
	
	/**
	* Static method for unit testing purposes.
	* @return true if success
	*/
	public static boolean Test(){
		return true;
	}

// <product-groups>
// 			<product-group name="Colgate" supply="0 count">			
// 				<products>
// 					<product barcode="035000741264" />
// 				</products>
// 				<items>
// 					<item product="035000741264" entry-date="05/28/2011" />
// 					<item product="035000741264" entry-date="05/28/2011" />
// 				</items>
// 			</product-group>
// 			<product-group name="Crest" supply="0 count">			
// 				<products>
// 					<product barcode="037000307570" />
// 				</products>
// 				<items>
// 					<item product="037000307570" entry-date="06/04/2011" />
// 					<item product="037000307570" entry-date="06/04/2011" />
// 					<item product="037000307570" entry-date="06/04/2011" />
// 				</items>
// 			</product-group>
// 		</product-groups>	
	public String toXML() {
		String xml = "<product-group name=\"" + getName() + "\" supply=\"" + getThreeMonthSupply() + "\">\n";
		
		// TODO child product groups
		for(ProductGroup pg : getProductGroups()) {
			xml += indentXMLBlock(pg.toXML());
		}

		// Print products
		xml += "\t<products>\n";
		for (Product prod : getProducts()) {
			xml += "\t\t" + prod.toXML();
		}
		xml += "\t</products>\n";

		// print items
		xml += "\t<items>\n";
		for (Product prod : getProducts()) {
			for (Item item : prod.getItems()) {
				xml += "\t\t" + item.toXML();
			}
		}
		xml += "\t</items>\n";
		
		xml += "</product-group>";
		return xml;
	}
}
