package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@SuppressWarnings("serial")
public abstract class Model implements Serializable {
	/**
	* @return the Model represented in it's proper XML format.
	*/
	public abstract String toXML();

	protected StringBuilder formatDateForXML(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yy");
		return new StringBuilder(dateFormat.format(date);
	}
}
