package model;

import java.text.DecimalFormat;

/**
* Represents a Barcode.
*/
@SuppressWarnings({ "serial", "rawtypes" })
public class Barcode extends Model implements Comparable {
	private Long _code;

	/**
	* Constructs a new Barcode object.
	* @param l The value of the Barcode
	*/
	public Barcode(long l) {
		setCode(l);
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
	public void setCode(long code) {
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
//		int i = (int)_code;
//	    if ((long)i != _code) {
//	        System.out.println("Invalid cast of code in Barcode::hashCode");
//	    }
//		Long l = new Long(_code);
		return _code.hashCode();
	}
	
	public boolean equals(Object o){
		if(o instanceof Barcode) return hashCode() == o.hashCode();
		else return false;
	}

	@Override
	public int compareTo(Object o) {
		long otherCode = ((Barcode)o).getCode();
		if(getCode() > otherCode) return 1;
		if(getCode() < otherCode) return -1;
		return 0;
	}

	public String toXML() {
		return null;
	}

	public String toString() {
		DecimalFormat formatter = new DecimalFormat("000000000000");
		return formatter.format(getCode());
	}
}