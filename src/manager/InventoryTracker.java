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
	private static long curCode = 0; 

	public static InventoryTracker inst(){
		if(ref == null) ref = new InventoryTracker();
		return ref;
	}
	
	public static void inst(InventoryTracker it){
		if(ref != null) ref = it;
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

	public static InventoryTracker fromJSON(JSONObject json) 
			throws ImportException, JSONException {
		InventoryTracker it = inst();
		if(!json.has("products") || !json.has("storage-units") || !json.has("item-history"))
			throw new ImportException("<inventory-tracker> tag malformed");
		
		ProductManager pm = ProductManager.fromJSON(
				getSubArray(json, "products", "product"));
		ItemManager im = ItemManager.fromJSON(
				getSubArray(json, "item-history", "item"));
		StorageUnitManager sum = StorageUnitManager.fromJSON(
				getSubArray(json, "storage-units", "storage-unit"));
		
		return it;
	}
	
	public String toXML() {
		String xml = "<inventory-tracker>";
		xml += indentXMLBlock(getProductManager().toXML());
		xml += indentXMLBlock(getStorageUnitManager().toXML());

		// print <item-history>
		String itemxml = "<item-history>\n";
		for (Item item : getItemManager().getDeletedItems()) {
			itemxml +=  indentXMLBlock(item.toXML());
		}
		itemxml += "\t</item-history>\n";
		xml += indentXMLBlock(itemxml);

		xml += "</inventory-tracker>";
		return xml;
	}

	public long generateUPC() {
		return curCode++;
	}
}