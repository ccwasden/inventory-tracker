package manager;

import java.sql.Timestamp;
import java.util.*; 

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Barcode;
import model.Item;
import model.Model;
import model.Product;
import model.ProductFilter;

/**
 * Manager for all products
 * 
 */
@SuppressWarnings("serial")
public class ProductManager extends Model {
    private TreeSet<Product> _products;
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
    private ProductManager(){
    	_products = new TreeSet<Product>();
    }
    
    /**
     * Retrieves the product of the associated barcode
     * @param barcode (Barcode) The barcode of the product to retrive
     * @return Product The product of the barcode
     *
     */
    public Product getProduct(Barcode barcode){
    	return null;
    }
    
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
    
    public Timestamp getEarliestItemAddedDate(Product p) {
//		Product product = getProduct(p.getBarcode());
		TreeSet<Item> items = p.getItems();
		Timestamp earliestEntryDate = new Timestamp(0);
		for (Item item : items)
			if (item.getDateAdded().before(earliestEntryDate))
				earliestEntryDate = item.getDateAdded();
		return earliestEntryDate;
    }
        
    /**
	* Static method for unit testing purposes.
	* @return true if success
	*/
	public static boolean Test(){
		return true;
	}

	public static ProductManager fromJSON(JSONArray jsonArray) throws JSONException, ImportException {
		ProductManager pm = inst();
		for(int i = 0; i < jsonArray.length(); i++)
			pm._products.add(Product.fromJSON(jsonArray.getJSONObject(i)));
		
//		jsonObject.getNames(jo)
		return pm;
	}
    
}
