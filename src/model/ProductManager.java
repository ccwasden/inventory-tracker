package model;

import java.util.*; 

/**
 * Manager for all products
 * 
 */
public class ProductManager {
    private ArrayList<Product> _products;
    
    /**
     * Constructs a new ProductManager
     *
     */
    public ProductManager(){}
    
    /**
     * Retrieves the product of the associated barcode
     * 
     * @param barcode (Barcode) The barcode of the product to retrive
     * 
     * @return Product The product of the barcode
     *
     */
    public Product getProduct(Barcode barcode){return null;}
    
    /**
     * Retrieves the storage unit of the associated name
     * 
     * @return ArrayList<Product> All products
     *
     */    
    public ArrayList<Product> getAllProducts(){return null;}
    
    /**
     * Retrieves all products that apply to the filter
     * 
     * @param filter (ProductFilter) The filter to run on each product
     *
     * @return ArrayList<Product> The list of products that apply to the filter
     */    
    public ArrayList<Product> getProductsOfFilter(ProductFilter filter){return null;}
    
    /**
	* Static method for unit testing purposes.
	* @return true if success
	*/
	public static boolean Test(){
		return true;
	}
    
}
