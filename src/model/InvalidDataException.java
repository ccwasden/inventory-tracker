package model;

@SuppressWarnings("serial")
public class InvalidDataException extends Exception {

	public InvalidDataException() {
		super();
	}
	
	public InvalidDataException(String message) {
		super(message);
	}
}
