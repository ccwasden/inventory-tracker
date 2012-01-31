package manager;

import model.Model;

@SuppressWarnings("serial")
class InventoryTracker extends Model {
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
		
		
		
		return true;
	}
}