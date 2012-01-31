package model;

/**
* Represents a Barcode.
*/
@SuppressWarnings("serial")
public class Barcode extends Model {
	private String _code;

	/**
	* Constructs a new Barcode object.
	* @param code The value of the Barcode
	*/
	public Barcode(String code) {
		_code = code;
	}

	/**
	* Gets the Barcode's code.
	* @return The Barcode's number.
	*/
	public String getCode() {
		return _code;
	}

	/**
	* Sets the Barcode's code.
	* @param code The new value for the Barcode.
	*/
	public void setCode(String code) {
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
		return getCode().hashCode();
	}
}