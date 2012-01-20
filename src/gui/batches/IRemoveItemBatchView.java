package gui.batches;

import gui.common.IView;
import gui.item.ItemData;
import gui.product.ProductData;

/**
 * View interface for remove item batch view.
 */
public interface IRemoveItemBatchView extends IView {
	
	/**
	 * Closes the remove item batch view.
	 */
	void close();
	
	/**
	 * Sets the value of the "Item Barcode" field.
	 * 
	 * @param barcode New "Item Barcode" value
	 */
	void setBarcode(String barcode);
	
	/**
	 * Returns the value of the "Item Barcode" field.
	 */
	String getBarcode();
	
	/**
	 * Gives the keyboard focus to the "Item Barcode" field.
	 */
	void giveBarcodeFocus();
	
	/**
	 * Sets the value of the "Use Barcode Scanner" setting.
	 * 
	 * @param value New "Use Barcode Scanner" value
	 */
	void setUseScanner(boolean value);
	
	/**
	 * Returns the "Use Barcode Scanner" setting.
	 */
	boolean getUseScanner();
	
	/**
	 * Sets the enable/disable state of the "Remove Item" button.
	 * 
	 * @param value New enable/disable state
	 */
	void enableItemAction(boolean value);
	
	/**
	 * Sets the enable/disable state of the "Undo" button.
	 * 
	 * @param value New enable/disable state
	 */
	void enableUndo(boolean value);
	
	/**
	 * Sets the enable/disable state of the "Redo" button.
	 * 
	 * @param value New enable/disable state
	 */
	void enableRedo(boolean value);

	/**
	 * Sets the products displayed in the "Products" table.
	 * 
	 * @param products Array of products to display
	 */
	void setProducts(ProductData[] products);
	
	/**
	 * Returns the currently selected product in the "Products" table,
	 * or null if no product is selected.
	 */
	ProductData getSelectedProduct();
	
	/**
	 * Selects the specified product in the "Products" table, or selects
	 * nothing if product is null.
	 * 
	 * @param product The product to be selected.  This must be one of the products
	 * previously passed to setProducts, or null.
	 */
	void selectProduct(ProductData product);
	
	/**
	 * Sets the items displayed in the "Items" table.
	 * 
	 * @param items Array of items to display
	 */
	void setItems(ItemData[] items);
	
	/**
	 * Returns the currently selected item in the "Items" table,
	 * or null if no item is selected.
	 */
	ItemData getSelectedItem();
	
	/**
	 * Selects the specified item in the "Items" table, or
	 * selects nothing if item is null.
	 *  
	 * @param item The item to be selected.  This must be one
	 * of the items previously passed to setItems, or null.
	 */
	void selectItem(ItemData item);

}

