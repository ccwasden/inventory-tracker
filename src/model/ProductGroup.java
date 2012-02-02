package model;

import gui.common.SizeUnits;

import java.sql.Timestamp;
import java.util.TreeSet;

import org.json.JSONObject;

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
	public ProductGroup(String name, StorageUnit su) {
		super(name, su);
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
		
		StorageUnit storageUnit1 = new StorageUnit("storageUnit1");
		Barcode barcode1 = new Barcode(123);
		Size size1 = new Size((float)3.4, SizeUnits.Liters);
		Product product1 = new Product(barcode1, "description of product 1",
				(float)5.5, size1, 6);
		assert (storageUnit1.getItems().size() == 0);
		
		Timestamp expirationDate1 = new Timestamp(55555);
		Item item1 = new Item(barcode1, product1, storageUnit1, expirationDate1);
		storageUnit1.addItem(item1);
		assert (storageUnit1.getItems().size() == 1);
		
		Barcode barcode2 = new Barcode(234);
		Timestamp expirationDate2 = new Timestamp(666666);
		Item item2 = new Item(barcode2, product1, storageUnit1, expirationDate2);
		storageUnit1.addItem(item2);
		assert (storageUnit1.getItems().size() == 2);
		
		Barcode barcode3 = new Barcode(345);
		Barcode barcode4 = new Barcode(456);
		Item item3 = new Item(barcode3, product1, storageUnit1, expirationDate1);
		Item item4 = new Item(barcode4, product1, storageUnit1, expirationDate1);
		TreeSet<Item> items3and4 = new TreeSet<Item>();
		items3and4.add(item3);
		items3and4.add(item4);
		storageUnit1.addItems(items3and4);
		assert (storageUnit1.getItems().size() == 4);
		
		storageUnit1.removeItem(item3);
		assert (storageUnit1.getItems().size() == 3);
		assert (!storageUnit1.getItems().contains(item3));
		assert (storageUnit1.getItems().contains(item4));
		assert (!storageUnit1.canEditStorageUnit(""));
		assert (!storageUnit1.canEditStorageUnit(null));
		
		assert (storageUnit1.getName() == "storageUnit1");
		storageUnit1.editStorageUnit("storageUnitNewName", items3and4);
		assert (storageUnit1.getName() == "storageUnitNewName");
		assert (!storageUnit1.getItems().contains(item1));
		assert (storageUnit1.getItems().contains(item4));	
		
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
		String xml = "<product-group name=\"" + getName() + 
				"\" supply=\"" + getThreeMonthSupply() + "\">\n";
		
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

	public static ProductGroup fromJSON(JSONObject json, StorageUnit su) {
		return null;
	}
}
