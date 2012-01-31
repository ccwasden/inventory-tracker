package manager;

import model.Model;

@SuppressWarnings("serial")
class InventoryTracker extends Model {
	private StorageUnitManager _storageUnitManager;
	private ProductManager _productManager;
	private ItemManager _itemManager;

	public InventoryTracker() {
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
}