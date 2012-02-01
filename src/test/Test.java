package test;
import org.json.*;

import manager.*;
import model.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Barcode.Test();
		Item.Test();
		Product.Test();
		StorageUnit.Test();
		ProductContainer.Test();
		ProductGroup.Test();
		ProductContainerList.Test();
		ItemFilter.Test();
		ProductFilter.Test();
		ItemManager.Test();
		ProductManager.Test();
//		Size.Test();
		StorageUnitManager.Test();
		InventoryTracker.Test();
		
		System.out.println("All tests passed.");
	}

}
