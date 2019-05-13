public class ExceptionHandler extends Exception {
	String message;

	public ExceptionHandler(String Message) {
		message = Message;
	}

	public String getMessage() {
		return message;
	}

}
