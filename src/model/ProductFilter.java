package model;
/**
 * FIlter for products 
 */
public class ProductFilter {
  
    /**
     * Checks if product applies to filter
     * @param product (Product) The product to run filter on
     * @return boolean true if product is in filter
     */
    public boolean productInFilter(Product product) {
    	return false;
    }
    
    /**
	* Static method for unit testing purposes.
	* @return true if success
	*/
	public static boolean Test(){
		return true;
	}
}
