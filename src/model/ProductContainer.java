package model;

import java.text.ParseException;
import java.util.SortedSet;
import java.util.TreeSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import manager.ImportException;
import manager.ProductManager;
import manager.StorageUnitManager;

/**
 * A ProductContainer is a generic term for StorageUnits and ProductGroups. 
 * These objects can "contain" Products and Items, and are referred to generically
 * as ProductContainers.
 */
@SuppressWarnings("serial")
public abstract class ProductContainer extends Model implements Comparable<ProductContainer> {
	
	private String _name;	
	
	/**
	 * The StorageUnit that contains this ProductContainer
	 */
	private StorageUnit _storageUnit;
	
	/**
	 * The collection of ProductGroups that this ProductContainer contains
	 */
	private TreeSet<ProductGroup> _productGroups;	
	
	/**
	 * The Products this ProductContainer contains
	 */
	private TreeSet<Product> _products;
	
	// Constructors
	/**
	 * Constructs a new instance of a ProductContainer
	 */
	public ProductContainer(String name, StorageUnit su) {
		try {
			setName(name);
			setProductGroups(new TreeSet<ProductGroup>());
			setProducts(new TreeSet<Product>());
			_storageUnit = su;
		}
		catch (InvalidDataException e) { }
	}
	
	/**
	 * Constructs a new instance of a ProductContainer (only for StorageUnit)
	 */
	public ProductContainer(String name) {
		try {
			assert this instanceof StorageUnit;
			setName(name);
			setProductGroups(new TreeSet<ProductGroup>());
			setProducts(new TreeSet<Product>());
			_storageUnit = (StorageUnit) this;
		}
		catch (InvalidDataException e) { }
	}
	
	
	// Accessors
	/**
	 * @return The name of this ProductContainer
	 */
	public String getName() {
		return _name;
	}	
	
	/**
	 * @return The collection of ProductGroups this ProductContainer contains
	 */
	public SortedSet<ProductGroup> getProductGroups() {
		return _productGroups;
	}	
	
	/**
	 * @return The Products this ProductContainer contains
	 */
	public TreeSet<Product> getProducts() {
		return _products;
	}	
	
	// Mutators
	/**
	 * Sets the name of this ProductContainer
	 */
	public void setName(String name) throws InvalidDataException {
		if (name == null || name == "")
			throw new InvalidDataException("Name must not be empty or null");
		// To do: also check that this is unique among other ProductContainers at same level
		_name = name;
	}	
	
	/**
	 * Sets the collection of ProductGroups this ProductContainer contains
	 */
	public void setProductGroups(TreeSet<ProductGroup> productGroups) {
		_productGroups = productGroups;
	}	
	
	/**
	 * Sets the collection of Products this ProductContainer contains
	 */
	public void setProducts(TreeSet<Product> products) {
		_products = products;
	}		
	
	// Class Methods

	/**
	 * Adds a new product to this container, and is called when an item 
	 * is trying to be added but has no product associated with it yet.
	 * @param product The product to be added
	 */
	public void addProduct(Product product) {
		StorageUnitManager.inst()
			.putStorageUnitProductInContainer(getStorageUnit(), product, this);
	}	
	
	/**
	 * Adds a ProductGroup
	 * @param productGroup The ProductGroup to be added
	 */
	public void addProductGroup(ProductGroup productGroup) throws InvalidDataException {
		if (!canAddProductGroup(productGroup))
			throw new InvalidDataException("Cannot add this product group");
		_productGroups.add(productGroup);
	}	
	
	/**
	 * Checks to see if a particular ProductGroup can be added
	 * @param productGroup The productGroup to check if it can be added
	 * @return true if the name of productGroup is not the empty string and if
	 * it is not already found in this ProductContainer, otherwise false
	 */
	public boolean canAddProductGroup(ProductGroup productGroup) {
		if (productGroup.getName() == "")
			return false;
		for (ProductGroup pg : _productGroups)
			if (pg.getName() == productGroup.getName())
				return false;
		return true;
	}	
	
	/**
	 * Deletes a Product
	 * @param product The product to be deleted
	 */
	public void deleteProduct(Product product) {
		if (canDeleteProduct(product))
			_products.remove(product);
	}	
	
	/**
	 * Checks to see if a particular Product can be deleted
	 * @param product The product to check if it can be deleted
	 * @return true if product can be deleted (meaning that there
	 * are no items associated with this product), otherwise false
	 */
	public boolean canDeleteProduct(Product product) {
		if (product.getItems().size() == 0)
			return true;
		return false;
	}	
	
	/**
	 * Deletes a ProductGroup
	 * @param productGroup The ProductGroup to delete
	 */
	public void deleteProductGroup(ProductGroup productGroup) {
		if (canDeleteProductGroup(productGroup))
			_productGroups.remove(productGroup);
	}	
	
	/**
	 * Checks to see if a particular ProductGroup can be deleted
	 * @param productGroup The productGroup to check if it can be deleted
	 * @return true if productGroup can be deleted, otherwise false
	 */
	public boolean canDeleteProductGroup(ProductGroup productGroup) {
		return true;
	}	
		
	/**
	 * Returns all the Products in this ProductContainer that apply to a filter
	 * @param productFilter The filter to be applied to the products
	 * @return All products that apply to the productFilter
	 */
	public TreeSet<Product> getProductsOfFilter(ProductFilter productFilter) { 
		return null;
	}	
	
	/**
	 * 
	 * @return The StorageUnit containing this ProductContainer
	 */
	public StorageUnit getStorageUnit() {
		return _storageUnit;
	}
	
	/**
	 * @return The ProductGroup containing a given Product
	 */
	public ProductGroup getProductGroupContaining(Product product) {
		for (ProductGroup pg : _productGroups)
			if (pg.contains(product))
				return pg;
		return null;
	}
	
	/**
	 * @return whether or not this ProductContainer contains the specified
	 * product in its immediate list of products (not recursive sub-directories)
	 */
	public boolean contains(Product product) {
		return _products.contains(product);
	}
	
	public int hashCode(){
		return _name.hashCode();
	}
	
	public void addAllProductsFromJSON(JSONArray jarr) throws JSONException, ImportException{
		for(int k = 0; k < jarr.length(); k++){
			long bcode = jarr.getJSONObject(k).getLong("barcode");
			Barcode b = new Barcode(bcode);
			Product p = ProductManager.inst().getProduct(b);
			if(p == null){
				System.out.println("barcode: " + b.hashCode());
				throw new ImportException("cant find product of specified barcode");
			}
			addProduct(p);
		}
	}
	
	public void addAllItemsFromJSON(JSONArray jarr) throws JSONException, ImportException {
		for(int k = 0; k < jarr.length(); k++){
//			System.out.println("Implement adding item to product container");
			Item i = Item.fromJSONToSU(jarr.getJSONObject(k), getStorageUnit());
			getStorageUnit().addItem(i);
		}
	}
	
	public void addAllProductGroupsFromJSON(JSONArray pGroups) throws JSONException, ImportException {
		for(int i = 0; i < pGroups.length(); i++) {
			JSONObject j = pGroups.getJSONObject(i);
			ProductGroup pg = new ProductGroup(j.getString("name"), getStorageUnit());
			if(j.has("products")) {
				JSONArray prods = getSubArray(j, "products", "product");
				pg.addAllProductsFromJSON(prods);
			}
			if(j.has("items")) {
				JSONArray itms = getSubArray(j, "items", "item");
				pg.addAllItemsFromJSON(itms);
			}
			if(j.has("product-groups")) {
				JSONArray pgroups = getSubArray(j, "product-groups", "product-group");
				pg.addAllProductGroupsFromJSON(pgroups);
			}
			try {
				addProductGroup(pg);
			} catch (InvalidDataException e) {
				throw new ImportException("invalid product group");
			}
		}
	}
	
	/**
	* Static method for unit testing purposes.
	* @return true if success
	*/
	public static boolean Test() {
		return true;
	}
	
	@Override
	public int compareTo(ProductContainer o) {
		return getName().compareTo(o.getName());
	}
}
