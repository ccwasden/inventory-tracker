package model;

import gui.common.SizeUnits;

/**
* Represents the size of a product.
*/
@SuppressWarnings("serial")
class Size extends Model {
	private float _size;
	private SizeUnits _units;

	/**
	* Creates a new Size object.
	* @param size The quantity of the size.
	* @param units The unit of measurement.
	*/
	public Size(float size, SizeUnits units) {
		_size = size;
		_units = units;
	}

	/**
	* Get the size.
	* @return The size.
	*/
	public float getSize() {
		return _size;
	}

	/**
	* Get the units for this size.
	* @return The unit as a SizeUnit.
	*/
	public SizeUnits getUnits() {
		return _units;
	}

	/**
	* Set the size
	* @param size The new size.
	*/
	public void setSize(float size) {
		_size = size;
	}

	/**
	* Set the units.
	* @param units the new units.
	*/
	public void setUnits(SizeUnits units) {
		_units = units;
	}
	
	/**
	* Static method for unit testing purposes.
	* @return true if success
	*/
	public static boolean Test(){
		return true;
	}
}