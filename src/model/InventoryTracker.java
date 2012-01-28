package model;

@SuppressWarnings("serial")
class InventoryTracker extends Model {
	private StorageUnitManager _storageUnitManager;
	private ProductManager _productManager;
	private ItemManager _itemManager;

	public InventoryTracker() {
		_storageUnitManager = StorageUnitManager.getInstance();
		// TODO is ProductManager not a singleton?
		// _productManager = ProductManager.getInstance();
		_itemManager = ItemManager.getInstance();							
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