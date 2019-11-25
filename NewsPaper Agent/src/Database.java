import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	void initDBConnection() {/// Connection with mySQL database
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Agile";

			con = DriverManager.getConnection(url, "root", "Danieldd11");

			stmt = con.createStatement();
		} catch (Exception e) {
			System.out.println("Database connection failed");
		}
	}

	public boolean createCustomer(String name, String address, String contact, int age) {
		String cmd = "INSERT INTO customer_details VALUES(" + null + ",'" + name + "','" + address + "','" + contact
				+ "'," + age + ",false);";
		try {
			stmt.executeUpdate(cmd);
			return true;
		} catch (Exception e1) {
		}
		return false;
	}

	public String lookForCustomerName(String name) {
		int cId = 0;
		String cName = "";
		String cAdd = "";
		String cCon = "";
		int cAge = 0;
		String cmd = "Select * from customer_details where Customer_Name = '" + name + "' and archive = false";
		try {
			rs = stmt.executeQuery(cmd);
			while (rs.next()) {
				cId = Integer.parseInt(rs.getString(1));
				cName = rs.getString(2);
				cAdd = rs.getString(3);
				cCon = rs.getString(4);
				cAge = rs.getInt(5);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// if(cId == 0 && cAge == 0) {
		// return "Customer Not Found";
		// }
		// else
		return "Customer Id: " + cId + "\nCustomer Name: " + cName + "\nCustomer Address: " + cAdd
				+ "\nCustomer Contact: " + cCon + "\nCustomer Age: " + cAge;
	}

	public String getCustomer_id(String name) {
		// TODO Auto-generated method stub
		String Customer_id = "";
		String cmd = "Select * from customer_details where Customer_Name = '" + name + "' and archive = false;";
		try {
			rs = stmt.executeQuery(cmd);
			while (rs.next()) {
				Customer_id = rs.getString(1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Customer_id;
	}

	public boolean createSubscription(String Frequency) {

		String cmd = "INSERT INTO Subscription VALUES (" + null + "," + null + ",'" + Frequency + "',true," + null
				+ ",false);";

		try {
			stmt.executeUpdate(cmd);
			return true;
		} catch (Exception e1) {
		}
		return false;
	}

	public String getSubscription(int subID) {
		String sub_ID = "";
		String freq = "";
		boolean sub_status = false;
		String cmd = "Select * from Subscription where subID = " + subID + " and archive = false;";
		try {
			rs = stmt.executeQuery(cmd);
			while (rs.next()) {
				sub_ID = rs.getString(1);
				freq = rs.getString(3);
				sub_status = rs.getBoolean(4);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "ID = " + sub_ID + ",Frequency = " + freq + ", Status = " + sub_status;

	}

	public boolean createDocket(int DriverID) {
		String cmd = "INSERT INTO Docket VALUES (" + null + "," + DriverID + ",false," + null + ",false);";

		try {
			stmt.executeUpdate(cmd);
			return true;
		} catch (Exception e1) {
		}
		return false;
	}

	public String getDocket_id(int id) {

		String Docket_id = "";
		String DriverID = "";
		boolean status = false;
		String cmd = "Select * from Docket where DocketID = '" + id + "' and archive = false;";
		try {
			rs = stmt.executeQuery(cmd);
			while (rs.next()) {
				Docket_id = rs.getString(1);
				DriverID = rs.getString(2);
				status = rs.getBoolean(3);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Docket id:" + Docket_id + ",Driver ID:" + DriverID + ",Delivered:" + status;
	}

	public boolean createDriver(String DriverName, String Password) {
		String cmd = "INSERT INTO Driver VALUES (" + null + ",'" + DriverName + "','" + Password + "',false);";
		try {
			stmt.executeUpdate(cmd);
			return true;
		} catch (Exception e1) {
		}
		return false;
	}

	public String getDriverName(String name) {
		// TODO Auto-generated method stub
		String Driver_name = "";
		String Driver_password = "";
		String Driver_id = "";
		String cmd = "Select * from Driver where Driver_Name = '" + name + "' and archive = false;";
		try {
			rs = stmt.executeQuery(cmd);
			while (rs.next()) {
				Driver_id = rs.getString(1);
				Driver_name = rs.getString(2);
				Driver_password = rs.getString(3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Driver_name == "") {
			return "Driver not found";
		} else {
			return "Driver ID: " + Driver_id + ",Driver name : " + Driver_name + ", Driver Password : "
					+ Driver_password;
		}

	}

	public String driverUsername(String Username) {
		String username = "";
		String ID = "";

		String cmd = "Select * from Driver where Driver_Name = '" + Username + "' and archive = false;";
		try {
			rs = stmt.executeQuery(cmd);
			while (rs.next()) {
				// ID=rs.getString(3);

				username = rs.getString(2);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return username;

	}

	public String driverPassword(String Password) {
		String password = "";

		String cmd = "Select * from Driver where Driver_Password = '" + Password + "' and archive = false;";
		try {
			rs = stmt.executeQuery(cmd);
			while (rs.next()) {

				password = rs.getString(3);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return password;

	}

	public boolean createDeliveryArea(String address, int driverID, int custID) {
		String cmd = "INSERT INTO DeliveryArea VALUES (" + null + ",'" + address + "'," + driverID + "," + custID
				+ ",false);";
		// System.out.println(cmd);
		try {
			stmt.executeUpdate(cmd);
			return true;
		} catch (Exception e1) {
		}

		return false;
	}

	public boolean modifyCustomer(int custId, String name, String address, String contact, int age) {

		String cmd = ("UPDATE customer_details SET Customer_Name = '" + name + "', Customer_Address = '" + address
				+ "', Customer_Contact = '" + contact + "', Customer_Age = " + age + " where Customer_id = " + custId
				+ " and archive = false;");
		try {
			stmt.executeUpdate(cmd);
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	public boolean createPublication(String pubName, double pubCost) {
		String cmd = "INSERT INTO Publication VALUES(" + null + ",'" + pubName + "'," + pubCost + ",false);";
		try {
			stmt.executeUpdate(cmd);
			return true;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return false;
	}

	public String getPublication(int pubID) {
		String publicationName = "";
		String publicationCost = "";
		String publicationID = "";
		String cmd = "Select * from Publication where pubID = '" + pubID + "'and archive = false;";
		try {
			rs = stmt.executeQuery(cmd);
			while (rs.next()) {
				publicationID = rs.getString(1);
				publicationName = rs.getString(2);
				publicationCost = rs.getString(3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Publication id: " + publicationID + "Publication Name: " + publicationName + "Publication Cost: "
				+ publicationCost;
	}

	public boolean addPublicationAndCustomerID(int subID, int custID, int pubID) {

		String cmd = "UPDATE Subscription SET Customer_id = " + custID + ", pubID = " + pubID + " where subID = "
				+ subID + " and archive = false;";
		// System.out.println(cmd);

		try {
			stmt.executeUpdate(cmd);

			return true;
		} catch (Exception e1) {
		}
		return false;
	}

	public boolean createOrder(int custID, int pubID, int subID) {

		String cmd = "INSERT INTO Orders VALUES(" + null + "," + custID + "," + pubID + "," + subID + ", false);";
		try {
			stmt.executeUpdate(cmd);
			return true;
		} catch (Exception e1) {
		}
		return false;
	}

	public String getOrder(int OrderID) {
		String orderID = "";
		String custID = "";
		String pubID = "";
		String subID = "";
		String cmd = "Select * from Orders where OrderID = '" + OrderID + "' and archive = false;";
		try {
			rs = stmt.executeQuery(cmd);
			while (rs.next()) {
				orderID = rs.getString(1);
				custID = rs.getString(2);
				pubID = rs.getString(3);
				subID = rs.getString(4);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Order id:" + orderID + ",Customer ID:" + custID + ",Publication ID:" + pubID + ",Subscription ID:"
				+ subID;
	}

	public boolean deleteOrders(int orderID) {
		String cmd = " Update Orders set archive = true WHERE OrderID = " + orderID + ";";
		try {
			stmt.executeUpdate(cmd);

			return true;
		} catch (Exception e1) {
		}
		return false;
	}

	public boolean addOrderToDocket(int DocketID, int OrderID) {

		String cmd = "UPDATE Docket SET OrderID = " + OrderID + " where DocketID = " + DocketID
				+ " and archive = false;";
		// System.out.println(cmd);

		try {
			stmt.executeUpdate(cmd);

			return true;
		} catch (Exception e1) {
		}
		return false;
	}

	public boolean deliveryStatus(int DocketID, Boolean status) {

		String cmd = "UPDATE Docket SET Delivered = " + status + " where DocketID = " + DocketID
				+ " and archive = false;";
		// System.out.println(cmd);

		try {
			stmt.executeUpdate(cmd);

			return true;
		} catch (Exception e1) {
		}
		return false;

	}

	public boolean archiveDriver(String DriverName) {

		String cmd = " Update Driver set  archive = true where Driver_Name = '" + DriverName + "';";
		// String cmd1 = "select * from Driverlog where Driver_Name = "+DriverName +";";
		// System.out.println(cmd);

		String driverName = "";
		String driverPassword = "";
		String driverID = "";

		try {
			stmt.executeUpdate(cmd);
		}

		catch (Exception e1) {

		}

		return false;
	}

	public String getarchiveDriver(String DriverName) {

		String cmd = " Select * from Driver where Driver_Name = '" + DriverName + "' and archive = true;";
		// String cmd1 = "select * from Driverlog where Driver_Name = "+DriverName +";";
		// System.out.println(cmd);

		String driverName = "";

		try {
			stmt.executeUpdate(cmd);
			driverName = rs.getString(1);
		}

		catch (Exception e1) {

		}

		return driverName;
	}

	public String lookForCustomerId(int custId) {
		// TODO Auto-generated method stub
		int cId = 0;
		String cName = "";
		String cAdd = "";
		String cCon = "";
		int cAge = 0;
		String cmd = "Select * from customer_details where Customer_Id = '" + custId + "' and archive = false";
		try {
			rs = stmt.executeQuery(cmd);
			while (rs.next()) {
				cId = Integer.parseInt(rs.getString(1));
				cName = rs.getString(2);
				cAdd = rs.getString(3);
				cCon = rs.getString(4);
				cAge = rs.getInt(5);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Customer Id: " + cId + "\nCustomer Name: " + cName + "\nCustomer Address: " + cAdd
				+ "\nCustomer Contact: " + cCon + "\nCustomer Age: " + cAge;

	}

	public boolean archiveCust(int custId) {
		// TODO Auto-generated method stub
		String res = "";
		String sqlCmd = "update customer_details set archive = true where Customer_Id = " + custId + ";";

		try {
			stmt.executeUpdate(sqlCmd);

		} catch (SQLException e) {
			e.printStackTrace();
			res = e.getMessage();
		}
		return false;
	}

	public String customerInactivity(int custId) {
		// TODO Auto-generated method stub
		String res = "";
		String custID = "";
		String SubID = "";
		String subFreq = "";
		boolean active = false;
		String sqlCmd = "select * from Subscription where  Customer_Id = " + custId + " and archive = false;";

		try {
			rs = stmt.executeQuery(sqlCmd);
			while (rs.next()) {

				SubID = rs.getString(1);
				custID = rs.getString(2);
				subFreq = rs.getString(3);
				active = rs.getBoolean(4);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			res = e.getMessage();
		}
		if (active) {
			return "Customer with an ID " + custID + " with a " + subFreq
					+ " frequency doesnt have an active subcription";
		}

		else {
			return "Customer with an ID " + custID + " with a " + subFreq + " frequency has an active subcription";
		}

	}

	public boolean changeActivity(int custId, boolean v) {

		String cmd = "Update Subscription set active = " + v + " where Customer_Id = " + custId + ";";
		try {
			stmt.executeUpdate(cmd);
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			// res = e.getMessage();
		}

		return false;
	}

	public String printDocket(int did) {
		int oId = 0;
		String cAdd = "";
		String pName = "";
		String sFre = "";

		String cmd = "SELECT * FROM dview where DocketID = " + did + ";";
		try {
			rs = stmt.executeQuery(cmd);
			while (rs.next()) {
				oId = Integer.parseInt(rs.getString(2));
				cAdd = rs.getString(3);
				pName = rs.getString(4);
				sFre = rs.getString(5);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "Order Id: " + oId + "\nCustomer Address: " + cAdd + "\nPublication: " + pName + "\nFrequency: " + sFre;
	}

	public boolean updatePublication(int pubID, String pubName, double pubCost) {

		String cmd = "Update Publication set pubName = '" + pubName + "', pubCost=" + pubCost
				+ ", archive= false where pubID  = " + pubID + ";";
		try {
			// System.out.println(cmd);
			stmt.executeUpdate(cmd);
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			// res = e.getMessage();
		}
		return false;

	}

	public boolean modifySubscription(int subID, int custID, String frequency, boolean active, int pubID) {

		String cmd = ("UPDATE Subscription SET Customer_Id = " + custID + ", subFreq = '" + frequency + "', active = "
				+ active + ", pubID = " + pubID + " where subID = " + subID + " and archive = false;");
		try {
			stmt.executeUpdate(cmd);
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	public String printDailySummary(int did) {
		// TODO Auto-generated method stub
		String cName = "";
		String pName = "";

		String cmd = "SELECT * FROM suView where DeliveryAreaID = " + did + ";";
		try {
			rs = stmt.executeQuery(cmd);
			while (rs.next()) {
				cName = rs.getString(2);
				pName = rs.getString(3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "\nCustomer : " + cName + "\nPublication: " + pName;
	}

	public boolean modifyDriver(int DriverID, String DriverName, String Password) {

		String cmd = ("UPDATE Driver SET Driver_Name = '" + DriverName + "' , Driver_Password= '" + Password
				+ "' where DriverID = " + DriverID + " and archive = false;");
		try {
			stmt.executeUpdate(cmd);
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;

	}

	public boolean modifyDocket(int DocketID, int driverID, int orderID) {

		String cmd = ("UPDATE Docket set DriverID = " + driverID + ", OrderID = " + orderID
				+ " where  archive = false and DocketID= " + DocketID + ";");
		try {
			stmt.executeUpdate(cmd);
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	public boolean unArchiveDriver(String DriverName) {

		String cmd = " Update Driver set  archive = false where Driver_Name = '" + DriverName + "';";
		// String cmd1 = "select * from Driverlog where Driver_Name = "+DriverName +";";
		// System.out.println(cmd);

		String driverName = "";
		String driverPassword = "";
		String driverID = "";

		try {
			stmt.executeUpdate(cmd);
		}

		catch (Exception e1) {

		}

		return false;
	}

	public String generateInvoice(int custID) {
		String cmd = "select Orders.OrderID, Customer_details.Customer_Name,Publication.pubName,Publication.pubCost, Subscription.subFreq from ((Orders inner join Customer_details  on Orders.OrderID=Customer_details.Customer_id) inner join Publication on Orders.OrderID=Publication.pubID right join Subscription on Orders.OrderID=Subscription.subID) where Orders.archive = false and Subscription.archive = false and Customer_details.archive = false and Publication.archive = false and Customer_details.Customer_id="
				+ custID + ";";

		String OrderID = "";
		String CustomerName = "";
		String pubName = "";
		String pubCost = "";
		String subFreq = "";
		// Double cost=0.00;
		Double total = 0.00;

		try {

			rs = stmt.executeQuery(cmd);
			while (rs.next()) {
				OrderID = rs.getString(1);
				CustomerName = rs.getString(2);
				pubName = rs.getString(3);
				pubCost = rs.getString(4);
				subFreq = rs.getString(5);
			}
		}

		catch (Exception e1) {

		}
		if (subFreq.equals("Daily")) {

			total = Double.parseDouble(pubCost) * 28;

		} else if (subFreq.equals("Weekly")) {
			// cost=Double.parseDouble(pubCost);
			total = Double.parseDouble(pubCost) * 7;
		} else if (subFreq.equals("Monthly")) {
			// cost=Double.parseDouble(pubCost);
			total = Double.parseDouble(pubCost) * 4;
		}

		String totalCost = Double.toString(total);
		// System.out.println(total);
		if (pubName == "" || total == 0.0) {
			return "Invoice not generated\n";
		} else {
			return "Order ID :" + OrderID + "\n" + "Customer Name:" + CustomerName + "\n" + "Publication Name:"
					+ pubName + "\n" + "Publication Cost:" + pubCost + "\nSubscription Frequency:" + subFreq
					+ "\nTotalCost: " + totalCost + "\n\n\n";
		}
	}

	public boolean unArchiveCust(int custId) {
		// TODO Auto-generated method stub
		String res = "";
		String sqlCmd = "update customer_details set archive = false where Customer_Id = " + custId + ";";

		try {
			stmt.executeUpdate(sqlCmd);

		} catch (SQLException e) {
			e.printStackTrace();
			res = e.getMessage();
		}
		return false;
	}

	public String getDeliveryArea(int DA) {
		String cmd = "Select * from DeliveryArea where DeliveryAreaID = " + DA + ";";
		String address = "";
		String driverID = "";
		String customerID = "";

		try {

			rs = stmt.executeQuery(cmd);
			while (rs.next()) {
				address = rs.getString(1);
				driverID = rs.getString(2);
				customerID = rs.getString(3);

			}
		}

		catch (Exception e1) {
			e1.getMessage();
		}
		return "Address:" + address + "\nDriverID" + driverID + "\nCustomerID:" + customerID;

	}

}
