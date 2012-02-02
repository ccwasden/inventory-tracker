package manager;

import java.util.*; 

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.*;

/**
 * Manager for all storage units
 * 
 */
@SuppressWarnings("serial")
public class StorageUnitManager extends Model {
    private HashMap<StorageUnitProduct, ProductContainer> _productSUMap;
    private TreeSet<StorageUnit> _storageUnits;
    private static StorageUnitManager ref;
    private HashMap<String, StorageUnit> _nameMap;

    /**
     * Get Singleton
     * @return the singleton instance
     */
    public static StorageUnitManager inst()
    {
      if (ref == null) ref = new StorageUnitManager();
      return ref;
    }
    
    /**
     * Get Singleton
     * @return the singleton instance
     */
    public static StorageUnitManager getInstance(StorageUnitManager sum)
    {
      ref = sum;
      return ref;
    }
    
    /**
     * private constructor
     */
    private StorageUnitManager(){
    	_productSUMap = new HashMap<StorageUnitProduct, ProductContainer>();
    	_storageUnits = new TreeSet<StorageUnit>();
    	_nameMap = new HashMap<String, StorageUnit>(); 
    }
    
    /**
     * Retrieves the length of the document (number of characters)
     * @param unit (StorageUnit) The unit to add to the list
     * @return true if successfully added, else false
     *
     */
    public boolean addStorageUnit(StorageUnit unit){
    	boolean added = _storageUnits.add(unit);
    	if(added) _nameMap.put(unit.getName(), unit);
    	return added;
    }
    
    /**
     * Removes StorageUnit specified
     * @param unit <StorageUnit> The unit to delete
     *
     */    
    public boolean deleteStorageUnit(StorageUnit unit){
    	return _storageUnits.remove(unit);
    }
    
    /**
     * Retrieves the storage unit of the associated name
     * @param name (String) The name of the storage unit to get
     * @return StorageUnit The unit with the passed in name
     *
     */    
    public StorageUnit getStorageUnit(String name){return null;}
    
    /**
     * Retrieves all Storage Units 
     * @return TreeSet<StorageUnit> The list of all storage units
     */    
    public TreeSet<StorageUnit> getAllStorageUnits(){return null;}
    
    /**
     * Maps a storage unit and product to a product container 
     * @param sup (StorageUnitProduct) the object containing a storage unit and product for mapping 
     * @param pc (ProductContainer) The ProductContainer to map to
     */
    public void putStorageUnitProductInContainer(StorageUnit su, Product p, ProductContainer pc){
    	assert pc.getStorageUnit().equals(su);
    	_productSUMap.put(new StorageUnitProduct(su, p), pc);
    }
    
    /**
     * Retrieves the ProductContainer associated with a product of a storage unit
     * @param su the storage unit 
     * @param p the product
     * @return the product container
     */
	public ProductContainer getProductContainerOfSUProd(StorageUnit su, Product p){
		return _productSUMap.get(new StorageUnitProduct(su, p));
	}
    
    /**
	* Static method for unit testing purposes.
	* @return true if success
	*/
	public static boolean Test(){
		return true;
	}

    public String toXML() {
        String xml = "<storage-units>\n";
        for(StorageUnit su : getAllStorageUnits()) {
            xml += su.toXML();
        }
        xml += "<storage-units>\n";
        return null;
    }

	public static StorageUnitManager fromJSON(JSONArray jsonArray) 
			throws JSONException, ImportException {
		StorageUnitManager sm = StorageUnitManager.inst();
		for(int i = 0; i < jsonArray.length(); i++) {
			JSONObject j = jsonArray.getJSONObject(i);
			StorageUnit su = new StorageUnit(j.getString("name"));
			if(j.has("products")) {
				JSONArray prods = getSubArray(j, "products", "product");
				su.addAllProductsFromJSON(prods);
			}
			if(j.has("items")) {
				JSONArray itms = getSubArray(j, "items", "item");
				su.addAllItemsFromJSON(itms);
			}
			if(j.has("product-groups")) {
				JSONArray pgroups = getSubArray(j, "product-groups", "product-group");
				su.addAllProductGroupsFromJSON(pgroups);
			}
			sm.addStorageUnit(su);
		}
		return null;
	}
}
