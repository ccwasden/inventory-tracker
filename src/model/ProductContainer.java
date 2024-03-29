package model;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * A ProductContainer is a generic term for StorageUnits and ProductGroups. 
 * These objects can "contain" Products and Items, and are referred to generically
 * as ProductContainers.
 */
@SuppressWarnings("serial")
public abstract class ProductContainer extends Model {
	
	private String _name;	
	
	/**
	 * The StorageUnit that contains this ProductContainer
	 */
	private StorageUnit _storageUnit;
	
	/**
	 * The collection of ProductGroups that this ProductContainer contains
	 */
	private SortedSet<ProductGroup> _productGroups;	
	
	/**
	 * The Products this ProductContainer contains
	 */
	private SortedSet<Product> _products;
	
	// Constructors
	/**
	 * Constructs a new instance of a ProductContainer
	 */
	public ProductContainer(String name) {
		setName(name);
		setProductGroups(new TreeSet<ProductGroup>());
		setProducts(new TreeSet<Product>());
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
	public SortedSet<Product> getProducts() {
		return _products;
	}	
	
	// Mutators
	/**
	 * Sets the name of this ProductContainer
	 */
	public void setName(String name) {
		_name = name;
	}	
	
	/**
	 * Sets the collection of ProductGroups this ProductContainer contains
	 */
	public void setProductGroups(SortedSet<ProductGroup> productGroups) {
		_productGroups = productGroups;
	}	
	
	/**
	 * Sets the collection of Products this ProductContainer contains
	 */
	public void setProducts(SortedSet<Product> products) {
		_products = products;
	}		
	
	// Class Methods
	/**
	 * Adds a ProductGroup
	 * @param productGroup The ProductGroup to be added
	 */
	public void addProductGroup(ProductGroup productGroup) {
		_productGroups.add(productGroup);
	}	
	
	/**
	 * Checks to see if a particular ProductGroup can be added
	 * @param productGroup The productGroup to check if it can be added
	 * @return true if the name of productGroup is not the empty string and if
	 * it is not already found in this ProductContainer, otherwise false
	 */
	public boolean canAddProductGroup(ProductGroup productGroup) {
		return false;
	}	
	
	/**
	 * Deletes a Product
	 * @param product The product to be deleted
	 */
	public void deleteProduct(Product product) {
		_products.remove(product);
	}	
	
	/**
	 * Checks to see if a particular Product can be deleted
	 * @param product The product to check if it can be deleted
	 * @return true if product can be deleted, otherwise false
	 */
	public boolean canDeleteProduct(Product product) {
		return false;
	}	
	
	/**
	 * Deletes a ProductGroup
	 * @param productGroup The ProductGroup to delete
	 */
	public void deleteProductGroup(ProductGroup productGroup) {
		_productGroups.remove(productGroup);
	}	
	
	/**
	 * Checks to see if a particular ProductGroup can be deleted
	 * @param productGroup The productGroup to check if it can be deleted
	 * @return true if productGroup can be deleted, otherwise false
	 */
	public boolean canDeleteProductGroup(ProductGroup productGroup) {
		return false;
	}	
		
	/**
	 * Returns all the Products in this ProductContainer that apply to a filter
	 * @param productFilter The filter to be applied to the products
	 * @return All products that apply to the productFilter
	 */
	public SortedSet<Product> getProductsOfFilter(ProductFilter productFilter) { 
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
