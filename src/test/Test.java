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
		
		
		try {
			String s = "<Smith><First_Name>Mary</First_Name><sex>Female</sex></Smith><Jackson><First_Name>Jackie</First_Name><sex>Female</sex></Jackson>";
			JSONObject json = XML.toJSONObject(s);
			System.out.println(json.get("Smith"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All tests passed.");
	}

}
