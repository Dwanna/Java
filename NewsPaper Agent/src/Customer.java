
public class Customer {

	public boolean createCust(String name, String address, String contact, int age, Database db) {
		boolean res = false;
		try {
			if (name.matches(".*\\d+.*") || name.length() > 40) {
				throw new ExceptionHandler("Invalid Customer Name");
			} else if (address.length() < 4 || address.length() > 20) {
				throw new ExceptionHandler("Invalid Customer Address");
			} else if (contact.length() < 9 || contact.length() > 11 || !contact.matches("[0-9]+")) {
				throw new ExceptionHandler("Invalid Contact Details");
			} else if (age < 18 || age > 100) {
				throw new ExceptionHandler("Invalid Customer Age");
			} else {
				db.createCustomer(name, address, contact, age);
				res = true;
			}
		} catch (ExceptionHandler e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	public String findCustomerByName(String name, Database db) {
		String res = "";
		try {
			if (name.matches(".*\\d+.*") || name.length() > 40) {
				throw new ExceptionHandler("Invalid Name Entered");
			} else {
				res = db.lookForCustomerName(name);

				// System.out.println(res);

			}
		} catch (ExceptionHandler e) {
			System.out.println(e.getMessage());
			res = e.getMessage();
		}
		return res;
	}

	public boolean modifyCust(int custId, String name, String address, String contact, int age, Database db) {
		boolean res = false;
		try {
			if (custId < 1 || custId > 1000) {
				throw new ExceptionHandler("Invalid Customer Id");
			} else if (name.matches(".*\\d+.*") || name.length() > 40) {
				throw new ExceptionHandler("Invalid Customer Name");
			} else if (address.length() < 4 || address.length() > 20) {
				throw new ExceptionHandler("Invalid Customer Address");
			} else if (contact.length() < 9 || contact.length() > 11 || !contact.matches("[0-9]+")) {
				throw new ExceptionHandler("Invalid Contact Details");
			} else if (age < 18 || age > 100) {
				throw new ExceptionHandler("Invalid Customer Age");
			} else {
				db.modifyCustomer(custId, name, address, contact, age);
				res = true;
			}
		} catch (ExceptionHandler e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	public String findCustomerById(int custId, Database db) {
		// TODO Auto-generated method stub
		String res = "";
		try {
			if (custId < 1 || custId > 1000) {
				throw new ExceptionHandler("Invalid Customer ID");
			} else {
				res = db.lookForCustomerId(custId);
				// System.out.println(res);
			}
		} catch (ExceptionHandler e) {
			System.out.println(e.getMessage());
			res = e.getMessage();
		}
		return res;
	}

	public boolean archiveCustomer(int custId, Database db) {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			if (custId < 1 || custId > 1000) {
				throw new ExceptionHandler("Invalid Customer Id");
			}

			else {
				db.archiveCust(custId);
				res = true;
			}
		} catch (ExceptionHandler e) {
			System.out.println(e.getMessage());

		}
		return res;
	}

	public boolean unArchiveCustomer(int custId, Database db) {
		boolean res = false;

		try {
			if (custId < 1 || custId > 1000) {
				throw new ExceptionHandler("Invalid Customer Id");
			}

			else {
				db.unArchiveCust(custId);
				res = true;
			}
		} catch (ExceptionHandler e) {
			System.out.println(e.getMessage());
			// e.getMessage();
		}
		return res;
	}

}
