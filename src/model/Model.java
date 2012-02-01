package model;

import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@SuppressWarnings("serial")
public abstract class Model implements Serializable {
	/**
	* @return the Model represented in it's proper XML format.
	*/
	public abstract String toXML();


	// TODO, maybe weird that the XML stuff is in the model when not all Model objects
	// need to have toXML functions... maybe put in another abstract class that extends model?
	protected StringBuilder formatDateForXML(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yy");
		return new StringBuilder(dateFormat.format(date));
	}
	
	protected static Timestamp getDateFromXML(String s) throws ParseException{
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		return new Timestamp(((Date)formatter.parse(s)).getTime());
	}
	
	protected static Timestamp getDateTimeFromXML(String s) throws ParseException{
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy KK:mm aa");
		return new Timestamp(((Date)formatter.parse(s)).getTime());
	}
	

	/**
	* Takes a block of XML and indents the whole block for prettier formatting. Can apply as many
	* times as you'd like.
	* @param xml The block of XML to indent
	* @return A block of indented xml.
	*/
	protected String indentXMLBlock(String xml) {
		String ret = "\t" + xml.replaceAll("\n", "\n\t");
		// remove any trailing tabs
		while(ret.endsWith("\t")) ret = ret.substring(0, ret.length() - 1);
		return ret;
	}
}
