
public class Publication {

	public boolean createPublication(String pubName, double pubCost, Database db) {
		boolean res = false;
		try {
			if (pubName.equals("newspaper") || pubName.equals("magazine")) {
				throw new ExceptionHandler("Invalid Publication Name");
			} else if (pubCost <= 0) {
				throw new ExceptionHandler("Invalid Publication Cost");
			}

			else {
				db.createPublication(pubName, pubCost);
				res = true;
			}
		} catch (ExceptionHandler e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	String getPublication(int pubID, Database db) {
		String res = "";

		try {
			if (pubID < 1 || pubID > 1000) {
				throw new ExceptionHandler("Invalid Publication ID");
			} else {
				res = db.getPublication(pubID);
			}

		} catch (Exception e) {
			res = e.getMessage();
		}
		return res;
	}

	public boolean updatePublication(int pubID, String pubName, double pubCost, Database db) {
		boolean res = false;
		try {
			if (pubID <= 0) {
				throw new ExceptionHandler("Invalid Publication Id");
			} else if (pubName.equals("newspaper") || pubName.equals("magazine")) {
				throw new ExceptionHandler("Invalid Publication Name");
			} else if (pubCost <= 0) {
				throw new ExceptionHandler("Invalid Publication Cost");
			}

			else {
				db.updatePublication(pubID, pubName, pubCost);
				res = true;
			}
		} catch (ExceptionHandler e) {
			System.out.println(e.getMessage());
		}
		return res;
	}
}
