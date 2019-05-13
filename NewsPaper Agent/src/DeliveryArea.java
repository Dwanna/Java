
public class DeliveryArea {
	public boolean createDeliveryArea(String address, int driverID, int custID, Database db) {
		boolean res = false;
		try {
			if (address.length() == 0) {
				throw new ExceptionHandler("Enter address");
			} else if (address.length() < 4 || address.length() > 15) {
				throw new ExceptionHandler("Invalid address");
			} else if (custID < 1 || custID > 1000) {
				throw new ExceptionHandler("Invalid Customer ID");
			} else if (driverID < 1 || driverID > 1000) {
				throw new ExceptionHandler("Invalid Driver ID");
			}
 
			else {
				res = true;
				db.createDeliveryArea(address, driverID, custID);
			}

		} catch (Exception e) {

		}

		return res;
	}

	public String printSummary(int did, Database db) {
		// TODO Auto-generated method stub
		String res = "";
		try {
			if (did < 1||did>1000) {
				throw new ExceptionHandler("Invalid Delivery Id");
			} else {
				res = db.printDailySummary(did);
				System.out.println(res);
			}
		} catch (ExceptionHandler e) {
			// System.out.println(e.getMessage());
			res = e.getMessage();
		}
		// TODO Auto-generated method stub
		return res;
	}

	public String getDeliveryArea(int DA, Database db) {
		String res = "";
		try {
			if (DA < 1 || DA > 1000) {
				throw new ExceptionHandler("Invalid Delivery Id");
			} else {
				res = db.getDeliveryArea(DA);

			}
		} catch (ExceptionHandler e) {
			// System.out.println(e.getMessage());
			res = e.getMessage();
		}
		// TODO Auto-generated method stub
		return res;
	}

}
