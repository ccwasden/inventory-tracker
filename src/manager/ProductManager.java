package manager;

import java.util.*; 

import model.Barcode;
import model.Model;
import model.Product;
import model.ProductFilter;

/**
 * Manager for all products
 * 
 */
@SuppressWarnings("serial")
public class ProductManager extends Model {
    private ArrayList<Product> _products;
    private static ProductManager ref;
    
    /**
     * Singleton instance
     * @return the instance
     */
    public static ProductManager inst(){
    	if(ref == null) ref = new ProductManager();
    	return ref;
    }
    
    /**
     * Singleton instance
     * @return the instance
     */
    public static ProductManager inst(ProductManager pm){
    	ref = pm;
    	return ref;
    }
    
    /**
     * Constructs a new ProductManager
     *
     */
    private ProductManager(){}
    
    /**
     * Retrieves the product of the associated barcode
     * @param barcode (Barcode) The barcode of the product to retrive
     * @return Product The product of the barcode
     *
     */
    public Product getProduct(Barcode barcode){return null;}
    
    /**
     * Retrieves the storage unit of the associated name
     * @return ArrayList<Product> All products
     *
     */    
    public ArrayList<Product> getAllProducts(){return null;}
    
    /**
     * Retrieves all products that apply to the filter
     * @param filter (ProductFilter) The filter to run on each product
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
