import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	void initDBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/SoftwareDesign";
			con = DriverManager.getConnection(url, "root", "Danieldd11");
			stmt = con.createStatement();
		} catch (Exception e) {
			System.out.println("Database connection failed");
		}
	}

	public String Username(String Username) {
		String username = "";
		String ID = "";

		String cmd = "Select * from CustomerDetails where username = '" + Username + "';";
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

	public String Password(String Password) {
		String password = "";

		String cmd = "Select * from CustomerDetails where password = '" + Password + "';";
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

	public int age(String name) {

		int Age = 0;

		manageDetails cust = new manageDetails("", 0, "", 0);

		String cmd = "Select * from CustomerDetails where username = '" + name + "';";
		try {
			rs = stmt.executeQuery(cmd);
			while (rs.next()) {

				Age = rs.getInt(5);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Age;

	}

	public int id(String name) {

		int id = 0;

		manageDetails cust = new manageDetails("", 0, "", 0);

		String cmd = "Select * from CustomerDetails where username = '" + name + "';";
		try {
			rs = stmt.executeQuery(cmd);
			while (rs.next()) {

				id = rs.getInt(1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;

	}

	public boolean createCustomer(String name, String password, String telephone, int age) {
		String cmd = "INSERT INTO CustomerDetails VALUES(" + null + ",'" + name + "','" + password + "','" + telephone
				+ "'," + age + ");";
		try {
			stmt.executeUpdate(cmd);

			return true;
		} catch (Exception e1) {
		}
		return false;
	}

}