package model;

import gui.common.SizeUnits;

class Size {
	private float _size;
	private SizeUnits _units;

	public Size(float size, SizeUnits units) {
		_size = size;
		_units = units;
	}

	public float getSize() {
		return _size;
	}

	public SizeUnits getUnits() {
		return _units;
	}

	public void setSize(float size) {
		_size = size;
	}

	public void setUnits(SizeUnits units) {
		_units = units;
	}
}