package model;

public class StorageUnitProduct {

	private StorageUnit _su;
	private Product _p;
	
	public StorageUnitProduct(StorageUnit su, Product p){
		assert(su != null);
		assert(p != null);
		_su = su;
		_p = p;
	}
	
	public StorageUnit getStorageUnit() {
		return _su;
	}

	public Product getProduct() {
		return _p;
	}
	
	@Override
	public int hashCode(){
		return 997 * _su.hashCode() ^ 991 * _p.hashCode();
	}
	
	/**
	* Static method for unit testing purposes.
	* @return true if success
	*/
	public static boolean Test(){
		StorageUnit su = new StorageUnit();
		
		return true;
	}
}
