public class LoginCheckExceptionHandler extends Exception {
	String errorMessage;

	public LoginCheckExceptionHandler(String errMsg) {
		errorMessage = errMsg;
	}

	public String getMessage() {
		return errorMessage;
	}
}