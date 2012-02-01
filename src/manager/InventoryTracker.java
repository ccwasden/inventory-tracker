package manager;

import java.sql.Timestamp;

import org.json.JSONException;
import org.json.JSONObject;

import gui.common.SizeUnits;
import model.*;

@SuppressWarnings("serial")
public class InventoryTracker extends Model {
	private StorageUnitManager _storageUnitManager;
	private ProductManager _productManager;
	private ItemManager _itemManager;
	private static InventoryTracker ref;

	public static InventoryTracker inst(){
		if(ref == null) ref = new InventoryTracker();
		return ref;
	}
	
	public static void inst(InventoryTracker it){
		ref = it;
	}
	
	private InventoryTracker() {
		_storageUnitManager = StorageUnitManager.inst();
		_productManager = ProductManager.inst();
		_itemManager = ItemManager.inst();							
	}

	public StorageUnitManager getStorageUnitManager() {
		return _storageUnitManager;
	}

	public ProductManager getProductManager() {
		return _productManager;
	}

	public ItemManager getItemManager() {
		return _itemManager;
	}
	
	public static boolean Test(){
		InventoryTracker it = InventoryTracker.inst();
		StorageUnit su = new StorageUnit("Hello");
		Product p = new Product(new Barcode(1234), "Prod1234", 3, 
				new Size(3, SizeUnits.Count), 22);
		Item i = new Item(new Barcode(12345), p, su, new Timestamp(0));
		StorageUnitManager sum = StorageUnitManager.inst();
		sum.addStorageUnit(su);
		su.addItem(i);
		
		
		return true;
	}

	public static InventoryTracker fromJSON(JSONObject json) throws ImportException, JSONException {
		InventoryTracker it = inst();
		System.out.println("\nDealing with json obj");
		System.out.println(JSONObject.getNames(json).length);
		if(!json.has("products") || !json.has("storage-units") || !json.has("item-history"))
			throw new ImportException("<inventory-tracker> missing mandatory sub-field");
		
		ProductManager pm = ProductManager.fromJSON(json.getJSONObject("products").getJSONArray("product"));
		
		System.out.println("\n");
		return it;
	}
}