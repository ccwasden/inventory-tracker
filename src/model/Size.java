package model;

import manager.ImportException;
import gui.common.SizeUnits;

/**
* Represents the size of a product.
*/
@SuppressWarnings("serial")
public class Size extends Model {
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

	public static Size fromString(String string) throws ImportException {
		String[] strs = string.split("\\s+");
		if(strs.length < 2) throw new ImportException("Invalid size: " + string);
		String type = string.substring(strs[0].length()).trim();
		return new Size(new Float(strs[0]), unitsFromString(type));
	}

	private static SizeUnits unitsFromString(String type) throws ImportException {
		if(type.equals("fluid ounces")) return SizeUnits.FluidOunces;
		if(type.equals("ounces")) return SizeUnits.Ounces;
		if(type.equals("count")) return SizeUnits.Count;
		if(type.equals("gallons")) return SizeUnits.Gallons;
		if(type.equals("grams")) return SizeUnits.Grams;
		if(type.equals("kilograms")) return SizeUnits.Kilograms;
		if(type.equals("liters")) return SizeUnits.Liters;
		if(type.equals("pints")) return SizeUnits.Pints;
		if(type.equals("pounds")) return SizeUnits.Pounds;
		if(type.equals("quarts")) return SizeUnits.Quarts;
		throw new ImportException("invalid size type: " + type);
	}
}