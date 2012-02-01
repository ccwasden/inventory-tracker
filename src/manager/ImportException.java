package manager;

@SuppressWarnings("serial")
public class ImportException extends Exception {

	String message;
	public ImportException(String string) {
		message = string;
	}
	
	public String getMessage(){
		return message;
	}

}
