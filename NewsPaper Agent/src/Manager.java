public class Manager {
	boolean validateLogin(String username, String password) {
		boolean res = false;
		try {
			if (username.equals("Admin") && password.equals("Pass")) {
				res = true;

			} else {
				throw new LoginCheckExceptionHandler("Invalid Login");
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return res;
	}

}
