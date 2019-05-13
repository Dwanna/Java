
public class Subscrption {
	public boolean createSubscription(String frequency, Database db) {
		boolean res = false;

		try {

			if (frequency.equals("Daily") || frequency.equals("Weekly") || frequency.equals("Monthly")) {

				db.createSubscription(frequency);
				res = true;
			} else if (frequency.length() < 5 || frequency.length() > 7) {
				throw new ExceptionHandler("Invalid frequency");
			}

			else {

				throw new ExceptionHandler("Invalid frequency");
			}
		}

		catch (ExceptionHandler e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return res;

	}

	public String getSubscription(int subID, Database db) {
		String res = "";
		try {
			if (subID < 1 || subID > 1000) {
				throw new ExceptionHandler("Invalid Subscrption ID");
			} else {
				res = db.getSubscription(subID);
			}
		} catch (Exception e) {
			res = e.getMessage();
		}
		return res;

	}

	public boolean addPubicationAndCustomerID(int subID, int custID, int pubID, Database db) {
		boolean res = false;
		try {
			if (subID < 1 || subID > 1000) {
				throw new ExceptionHandler("Invalid sub ID");
			} else if (custID < 1 || custID > 1000) {
				throw new ExceptionHandler("Invalid customer ID");
			} else if (pubID < 1 || pubID > 1000) {
				throw new ExceptionHandler("Invalid publication ID");
			} else {
				db.addPublicationAndCustomerID(subID, custID, pubID);
				res = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return res;

	}

	public String CustomerInactivity(int customerID, Database db) {
		String res = "";
		try {
			if (customerID < 1 || customerID > 1000) {
				throw new ExceptionHandler("Invalid Customer ID");
			} else {
				res = db.customerInactivity(customerID);

			}
		} catch (ExceptionHandler e) {
			System.out.println(e.getMessage());
			res = e.getMessage();
		}
		return res;
	}

	public boolean changeActive(int custID, boolean v, Database db) {

		boolean res = false;

		try {
			if (custID < 1 || custID > 1000) {
				throw new ExceptionHandler("Invalid Customer ID");
			} else {
				res = true;
				db.changeActivity(custID, v);

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return res;

	}

	public boolean modifySubscription(int subID, int custID, String frequency, boolean active, int pubID, Database db) {
		boolean res = false;
		try {
			if (subID < 1 || subID > 1000) {
				throw new ExceptionHandler("Invalid Subcription ID");
			} else if (custID < 1 || custID > 1000) {
				throw new ExceptionHandler("Invalid customer ID");
			} else if (frequency.length() < 5 || frequency.length() > 7) {
				throw new ExceptionHandler("Invalid Subcription frequency");
			} else if (pubID < 1 || pubID > 1000) {
				throw new ExceptionHandler("Invalid Publication ID");
			} else {
				if (frequency.equals("Daily") || frequency.equals("Weekly") || frequency.equals("Monthly")) {
					res = true;
					db.modifySubscription(subID, custID, frequency, active, pubID);

				}
			}

		} catch (ExceptionHandler e) {
			System.out.println(e.getMessage());
		}

		return res;

	}

}
