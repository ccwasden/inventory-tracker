package model;

import java.util.*;

@SuppressWarnings("serial")
public class ProductList extends Model {

	private SortedSet<Product> _products;

	public ProductList(SortedSet<Product> products) {
		_products = products;
	}

	/**
	 * @return The products in this list
	 */
	public SortedSet<Product> getProducts() {
		return _products;
	}

	/**
	 * Sets the products in this list
	 * @param products
	 */
	public void setProducts(SortedSet<Product> products) {
		_products = products;
	}
	
	public void add(Product product) {
		_products.add(product);
	}
	
	/**
	 * @return the number of products in this list
	 */
	public int size() {
		return _products.size();
	}
	
	public void remove(Product product) {
		_products.remove(product);
	}
	
	/**
	 * @return a read-only iterator
	 */
	public Iterator<Product> iterator() {
		return Collections.unmodifiableSet(_products).iterator();
	}
	
	/**
	 * @return whether or not this ProductList contains the specified item
	 */
	public boolean contains(Product product) {
		return _products.contains(product);
	}

	/**
	* Static method for unit testing purposes.
	* @return true if success
	*/
	public static boolean Test(){
		return true;
	}
}
