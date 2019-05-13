
public class Order {
	public boolean createOrder(int custID, int pubID, int subID, Database db) {
		boolean res = false;
		try {
			if (custID < 1 || custID > 1000) {
				throw new ExceptionHandler("Invalid customer ID");
			} else if (pubID < 1 || pubID > 1000) {
				throw new ExceptionHandler("Invalid pub ID");
			} else if (subID < 1 || subID > 1000) {
				throw new ExceptionHandler("Invalid sub ID");
			} else {
				db.createOrder(custID, pubID, subID);
				res = true;
			}
		} catch (ExceptionHandler e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	public String getOrder(int OrderID, Database db) {
		String res = "";
		try {
			if (OrderID < 1 || OrderID > 1000) {
				throw new ExceptionHandler("Invalid Order ID");
			} else {
				res = db.getOrder(OrderID);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			res = e.getMessage();
		}
		return res;
	}

	public boolean deleteOrders(int orderID, Database db) {
		boolean res = false;
		try {
			if (orderID <= 0 || orderID > 100) {
				throw new ExceptionHandler("Invalid Order ID");
			} else {
				db.deleteOrders(orderID);
				res = true;
			}
		} catch (ExceptionHandler e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	public String generateInvoice(int custID, Database db) {

		String res = "";
		try {
			if (custID < 1 || custID > 1000) {
				throw new ExceptionHandler("Invalid customer ID");
			} else {
				res = db.generateInvoice(custID);
			}
		} catch (ExceptionHandler e) {
			res = e.getMessage();
		}
		return res;
	}
}
