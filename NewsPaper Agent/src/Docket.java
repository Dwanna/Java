
public class Docket {
	public boolean createDocket(int driverID, Database db) {
		boolean res = false;

		try {
			if (driverID < 1 || driverID > 1000) {
				throw new ExceptionHandler("Invalid Driver ID");
			}

			else {
				res = true;
				System.out.println(res);
				db.createDocket(driverID);
			}
		} catch (ExceptionHandler e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return res;

	}

	public String getDocket(int DocketID, Database db) {
		String res = "";

		try {
			if (DocketID < 1 || DocketID > 1000) {
				throw new ExceptionHandler("Invalid DocketID");
			} else {
				res = db.getDocket_id(DocketID);
			}

		} catch (Exception e) {
			res = e.getMessage();
		}
		return res;
	}

	public boolean addOrderToDocket(int DocketID, int OrderID, Database db) {
		boolean res = false;
		try {
			if (DocketID < 1 || DocketID > 1000) {
				throw new ExceptionHandler("Invalid DocketID");
			} else if (OrderID < 1 || OrderID > 1000) {
				throw new ExceptionHandler("Invalid OrderID");
			} else {
				db.addOrderToDocket(DocketID, OrderID);
				res = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;

	}

	boolean deliveryStatus(int DocketID, Database db) {
		boolean res = false;

		try {
			if (DocketID < 1 || DocketID > 1000) {
				throw new ExceptionHandler("Invalid Docket ID");
			}

			else {
				res = true;
				System.out.println(res);
				db.createDocket(DocketID);
			}
		} catch (ExceptionHandler e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return res;

	}

	public String lookDocket(int did, Database db) {
		String res = "";
		try {
			if (did < 1) {
				throw new ExceptionHandler("Invalid Docket Id");
			} else {
				res = db.printDocket(did);
				System.out.println(res);
			}
		} catch (ExceptionHandler e) {
			// System.out.println(e.getMessage());
			res = e.getMessage();
		}
		// TODO Auto-generated method stub
		return res;
	}

	public boolean modifyDocket(int DocketID, int driverID, int orderID, Database db) {
		boolean res = false;
		try {
			if (DocketID < 1 || DocketID > 1000) {
				throw new ExceptionHandler("Invalid DocketID");
			} else if (driverID < 1 || driverID > 1000) {
				throw new ExceptionHandler("Invalid Driver ID");
			} else if (orderID < 1 || orderID > 1000) {
				throw new ExceptionHandler("Invalid OrderID");
			} else {
				{
					res = true;
					db.modifyDocket(DocketID, driverID, orderID);

				}
			}

		} catch (ExceptionHandler e) {
			System.out.println(e.getMessage());
		}

		return res;

	}

}
