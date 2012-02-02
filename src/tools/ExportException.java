package tools;

@SuppressWarnings("serial")
public class ExportException extends Exception {

	String message;
	public ExportException(String string) {
		message = string;
	}
	
	public String getMessage(){
		return message;
	}

}
