package model;

/**
* Represents a Barcode.
*/
@SuppressWarnings({ "serial", "rawtypes" })
public class Barcode extends Model implements Comparable {
	private long _code;

	/**
	* Constructs a new Barcode object.
	* @param code The value of the Barcode
	*/
	public Barcode(int code) {
		_code = code;
	}

	/**
	* Gets the Barcode's code.
	* @return The Barcode's number.
	*/
	public long getCode() {
		return _code;
	}

	/**
	* Sets the Barcode's code.
	* @param code The new value for the Barcode.
	*/
	public void setCode(int code) {
		_code = code;
	}
	
	/**
	* Static method for unit testing purposes.
	* @return true if success
	*/
	public static boolean Test(){
		return true;
	}
	
	@Override
	public int hashCode(){
		return (int) _code;
	}

	@Override
	public int compareTo(Object o) {
		long otherCode = ((Barcode)o).getCode();
		if(getCode() > otherCode) return 1;
		if(getCode() < otherCode) return -1;
		return 0;
	}
}