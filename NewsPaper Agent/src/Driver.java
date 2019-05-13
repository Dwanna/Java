
public class Driver {
	public boolean createDriver(String DriverName, String Password, Database db) {
		boolean res = false;
		try {
			if (DriverName.matches(".*\\d+.*") || DriverName.length() > 15) {

				throw new ExceptionHandler("Invalid Driver Name");
			} else if (DriverName.length() < 1) {
				throw new ExceptionHandler("Enter Driver's Name");
			}
			if (Password.length() < 1) {
				throw new ExceptionHandler("Enter Driver's password");
			} else if (Password.length() < 7 || Password.length() > 20 || Password.matches(".*\\d+.*")) {

				throw new ExceptionHandler("Invalid Driver Password");
			}

			else {
				db.createDriver(DriverName, Password);
				res = true;
			}
		} catch (ExceptionHandler e) {
			System.out.println(e.getMessage());
		}
		return res;

	}

	public String lookUpDriver(String DriverName, Database db) {
		String res = "";

		try {
			if (DriverName.length() < 1 || DriverName.length() > 15) {
				throw new ExceptionHandler("Invalid Driver Name");
			}

			else {
				res = db.getDriverName(DriverName);

			}
		} catch (ExceptionHandler e) {
			System.out.println(e.getMessage());
			res = e.getMessage();
		}
		return res;
	}

	public boolean deliveryStatus(int docketID, boolean v, Database db) {
		boolean res = false;
		try {
			if (docketID < 1 || docketID > 1000) {
				throw new ExceptionHandler("Invalid Docket id");

			} else {
				db.deliveryStatus(docketID, v);
				res = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;

	}

	public boolean archiveDriver(String DriverName, Database db) {
		boolean res = false;

		try {
			if (DriverName.length() < 1 || DriverName.length() > 15) {
				throw new ExceptionHandler("Invalid Driver Name");
			}

			else {
				db.archiveDriver(DriverName);
				res = true;

			}
		} catch (ExceptionHandler e) {
			System.out.println(e.getMessage());
			// e.getMessage();
		}
		return res;
	}

	public boolean modifyDriver(int DriverID, String DriverName, String Password, Database db) {
		boolean res = false;
		try {
			if (DriverName.matches(".*\\d+.*") || DriverName.length() > 15) {

				throw new ExceptionHandler("Invalid Driver Name");
			} else if (DriverName.length() < 1) {
				throw new ExceptionHandler("Enter Driver's Name");
			} else if (DriverID < 1 || DriverID > 1000) {
				throw new ExceptionHandler("Invalid Driver ID");
			} else if (Password.length() < 1) {
				throw new ExceptionHandler("Enter Driver's password");
			} else if (Password.length() < 7 || Password.length() > 20 || Password.matches(".*\\d+.*")) {

				throw new ExceptionHandler("Invalid Driver Password");
			} else {
				res = true;
				db.modifyDriver(DriverID, DriverName, Password);
			}

		} catch (ExceptionHandler e) {
			System.out.println(e.getMessage());
		}

		return res;

	}

	public boolean unArchiveDriver(String DriverName, Database db) {
		boolean res = false;

		try {
			if (DriverName.length() < 1 || DriverName.length() > 15 || (DriverName.matches(".*\\d+.*"))) {
				throw new ExceptionHandler("Invalid Driver Name");
			}

			else {
				db.unArchiveDriver(DriverName);
				res = true;

			}
		} catch (ExceptionHandler e) {
			System.out.println(e.getMessage());
			// e.getMessage();
		}
		return res;
	}

}
