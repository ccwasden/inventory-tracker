package test;
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
		ProductList.Test();
		ItemList.Test();
		ProductContainerList.Test();
		ItemFilter.Test();
		ProductFilter.Test();
		ItemManager.Test();
		ProductManager.Test();
//		Size.Test();
		StorageUnitManager.Test();
		System.out.println("All tests passed.");
	}
	
//	public static boolean Assert(Boolean expr){
//		if(!expr) ;
//		return expr;
//	}

}
