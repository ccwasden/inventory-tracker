package model;

import java.util.SortedSet;

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
	* Static method for unit testing purposes.
	* @return true if success
	*/
	public static boolean Test(){
		return true;
	}
}
