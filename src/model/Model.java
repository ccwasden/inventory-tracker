package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Model implements Serializable {
	/**
	* @return the Model represented in it's proper XML format.
	*/
	abstract String toXML();
}
