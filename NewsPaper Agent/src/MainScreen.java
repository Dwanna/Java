import java.util.Scanner;

public class MainScreen {

	static Customer cust = new Customer();
	static Subscrption sub = new Subscrption();
	static Driver driver = new Driver();
	static Database db = new Database();
	static Manager manager = new Manager();
	static Docket docket = new Docket();
	static DeliveryArea deliveryArea = new DeliveryArea();
	static Publication stock = new Publication();
	static Scanner sc = new Scanner(System.in);
	static Order order = new Order();

	public static void ManagerScreen() {/// Manager's Screen
		System.out.println("Select an Option");
		System.out.println("Press 1: Customer");
		System.out.println("Press 2: Driver");
		System.out.println("Press 3: Subscription");
		System.out.println("Press 4: Docket");
		System.out.println("Press 5: Delivery Area");
		System.out.println("Press 6: Publication");
		System.out.println("Press 7: Order");

		System.out.println("Press 8: Daily Summary");
		System.out.println("Press 9: Exit");
		int choice = sc.nextInt();
		if (choice == 1) {
			Customer();
		} else if (choice == 2) {
			Driver();
		} else if (choice == 3) {
			Subscription();
		} else if (choice == 4) {
			Docket();
		} else if (choice == 5) {
			DeliveryArea();
		} else if (choice == 6) {
			Stock();
		} else if (choice == 7) {
			Order();
		} else if (choice == 8) {
			DailySummary();
		}

		else if (choice == 9) {
			System.out.println("Manager screen exited");
			main(null);
		}

		else {
			ManagerScreen();
			System.out.println("Enter a valid option ");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		db.initDBConnection();

		System.out.println("Welcome to NewsAgent");

		System.out.println("Select an Option");
		System.out.println("Press 1: Manager Login:");
		System.out.println("Press 2: Delivery Login: ");
		System.out.println("Press 3: Exit");
		int choice = sc.nextInt();
		if (choice == 1) {// Manager Login]
			System.out.println("Enter manager username:");
			String username = sc.next();
			System.out.println("Enter manager password:");
			String password = sc.next();
			if (manager.validateLogin(username, password)) {
				ManagerScreen();
			} else {
				System.out.println("Invalid login");
				main(args);
			}

		} else if (choice == 2) {/// Allows created driver to login
			String user = "";
			String pass = "";

			System.out.println("Enter Driver's Username:");
			String Username = sc.next();
			System.out.println("Enter Driver's password:");
			String Password = sc.next();
			user = db.driverUsername(Username);
			pass = db.driverPassword(Password);
			if (Username.equals(user) && Password.equals(pass)) {
				System.out.println("Succesful login");
				DeliveryStatusScreen();
			} else {
				System.out.println("Invalid driver login");

				main(args);
			}

		}

		else if (choice == 3) {
			System.exit(0);
		} else {
			System.out.println("Press an option");
			main(args);
		}
	}

	public static void Customer() {
		System.out.println("\nPlease choose and option: ");
		System.out.println("1: Create customer");
		System.out.println("2: Look up customer");
		System.out.println("3: Modify customer");
		System.out.println("4: Archieve Customer");
		System.out.println("5: Unarchieve Customer");
		System.out.println("6: Exit customer");

		int choice = sc.nextInt();

		if (choice == 1) {
			createCustomerScreen();
		}

		else if (choice == 2) {
			lookCustomerScreen();
		}

		else if (choice == 3) {
			modifyCustomerScreen();
		}

		else if (choice == 4) {
			archieveCustomerScreen();
		} else if (choice == 5) {
			unArchieveCustomerScreen();
		}

		else if (choice == 6) {
			System.out.println("Are you sure you want to exit press y to exit and n to not exit :");
			String choice2 = sc.next();
			if (choice2.toLowerCase().equals("y")) {
				ManagerScreen();
			} else if ((choice2.toLowerCase().equals("n"))) {
				Driver();
			} else {
				System.out.println("Enter a valid option:");
				Driver();
			}
			ManagerScreen();
		}

		else {
			System.out.println("Enter a valid option");
			Customer();
		}
	}

	public static void DailySummary() {
		// TODO Auto-generated method stub
		System.out.println("Press 1: View Delivered Dockets");
		System.out.println("Press 2: Exit");
		int choice = sc.nextInt();
		if (choice == 1) {
			System.out.println("Please enter delivery id");
			int did = sc.nextInt();

			if (did == 0) {
				DailySummary();
			} else {
				deliveryArea.printSummary(did, db);
				// docket.lookDocket(did, db);
				DailySummary();
			}
		} else if (choice == 2) {
			System.out.println("Are you sure you want to exit press y to exit and n to not exit :");
			String choice2 = sc.next();
			if (choice2.toLowerCase().equals("y")) {
				ManagerScreen();
			} else if ((choice2.toLowerCase().equals("n"))) {
				Driver();
			} else {
				System.out.println("Enter a valid option:");
				Driver();
			}
			ManagerScreen();
		}
	}

	public static void createCustomerScreen() {
		System.out.println("Enter Customer Name:");
		String name = sc.next();
		System.out.println("Enter Customer Address:");
		String address = sc.next();
		System.out.println("Enter Customer Contact:");
		String contact = sc.next();
		System.out.println("Enter Customer Age:");
		int age = sc.nextInt();

		if (cust.createCust(name, address, contact, age, db)) {

			System.out.println("Customer created successfully with Id: " + db.getCustomer_id(name));
			Customer();

		} else {
			System.out.println("Customer not created");
			Customer();
		}
	}

	public static void lookCustomerScreen() {
		int ch = 0;
		int custId = 0;
		String name;
		System.out.println("1 : Search By Customer Id");
		System.out.println("2 : Search By Customer Name");
		ch = sc.nextInt();
		if (ch == 0) {
			lookCustomerScreen();
		}

		if (ch == 1) {
			System.out.println("Enter Customer Id : ");
			custId = sc.nextInt();

			String res = cust.findCustomerById(custId, db);

			;

			System.out.println(res);
			Customer();

		} else if (ch == 2) {
			System.out.println("Enter Customer Name : ");
			name = sc.next();

			String res = cust.findCustomerByName(name, db);

			System.out.println(res);
		}
		Customer();
	}

	public static void modifyCustomerScreen() {
		System.out.println("Modify Customer Details");
		System.out.println("Please enter customer id");
		int custId = sc.nextInt();
		System.out.println("Customer Name:");
		String name = sc.next();
		System.out.println("Customer Address:");
		String address = sc.next();
		System.out.println("Customer Contact:");
		String contact = sc.next();
		System.out.println("Customer Age:");
		int age = sc.nextInt();

		if (cust.modifyCust(custId, name, address, contact, age, db)) {

			System.out.println("Customer details updated successfully: " + db.getCustomer_id(name));
			Customer();

		} else {
			System.out.println("Customer details is not updated");
			Customer();
		}
	}

	public static void archieveCustomerScreen() {
		System.out.println("Please enter customer id");
		int custId = sc.nextInt();

		if (cust.archiveCustomer(custId, db)) {
			System.out.println("Customer Archived Successfully");
			Customer();
		} else {
			System.out.println("Try Again");
			Customer();
		}
		/*
		 * if(custId == 0) { >>>>>>> branch 'Ayodeji' of
		 * https://Dwanna04@bitbucket.org/agileteam11/newspaper-agent.git Customer(); }
		 * else { System.out.println("Try Again"); Customer(); } // /*if(custId == 0) {
		 * // Customer(); // } // else { //
		 * System.out.println(cust.archiveCustomer(custId, db)); //
		 * archieveCustomerScreen(); // }
		 */
	}

	public static void unArchieveCustomerScreen() {
		System.out.println("Please enter customer id");
		int custId = sc.nextInt();

		if (cust.unArchiveCustomer(custId, db)) {
			System.out.println("Customer UnArchived Successfully");
			Customer();
		} else {
			System.out.println("Try Again");
			Customer();
		}
		/*
		 * if(custId == 0) { >>>>>>> branch 'Ayodeji' of
		 * https://Dwanna04@bitbucket.org/agileteam11/newspaper-agent.git Customer(); }
		 * else { System.out.println("Try Again"); Customer(); } // /*if(custId == 0) {
		 * // Customer(); // } // else { //
		 * System.out.println(cust.archiveCustomer(custId, db)); //
		 * archieveCustomerScreen(); // }
		 */
	}

	public static void Subscription() {
		System.out.println("Choose an option");
		System.out.println("Press1: Create a subscription");
		System.out.println("Press2: Look up subscription");
		System.out.println("Press3: Add customer and publication ID");
		System.out.println("Press4: Detect inactive customer by inputting customer ID ");
		System.out.println("Press5: Change customer's activity");
		System.out.println("Press6: Modify subscription");
		System.out.println("Press7: Exit subscription screen");
		int choice = sc.nextInt();
		if (choice == 1) {

			System.out.println("Assign customer frequency");
			String Frequency = sc.next();

			if (sub.createSubscription(Frequency, db)) {

				System.out.println("Subcription ID succesfully created ");
				Subscription();

			} else {
				System.out.println("Sub not created");
				Subscription();
			}
		} else if (choice == 2) {
			String res = "";
			System.out.println(" Enter Subscription ID");
			int subID = sc.nextInt();
			res = sub.getSubscription(subID, db);
			System.out.println(res);
			Subscription();

		} else if (choice == 3) {
			System.out.println("Enter Sub ID you want to add customer ID and publication ID to");
			int subID = sc.nextInt();
			System.out.println(" Enter customer's ID");
			int custID = sc.nextInt();

			System.out.println(" Enter publication's ID");
			int pubID = sc.nextInt();

			if (sub.addPubicationAndCustomerID(subID, custID, pubID, db)) {
				System.out.println("Customer ID " + custID + " and pubID " + pubID + " has been entered and updated");
			} else {
				System.out.println("Customer and publication ID not added");
			}
			Subscription();

		} else if (choice == 4) {
			System.out.println("Enter customer ID you want to check customer's status ");
			int custID = sc.nextInt();
			String res = sub.CustomerInactivity(custID, db);

			if (res.equals("")) {
				System.out.println("That customer id isnt associated with the subcription");
			} else {
				System.out.println(res);
			}
			Subscription();

		} else if (choice == 5) {

			System.out.println("Enter customer ID to change customer's active status");
			int custID = sc.nextInt();
			String res = cust.findCustomerById(custID, db);
			System.out.println("Press y if you want to change customer's status to true and n to do otherwise");
			String choice2 = sc.next();
			if (choice2.toLowerCase().equals("y")) {
				if (sub.changeActive(custID, true, db)) {
					System.out.println("Customer with ID:" + custID + " now has an active subscription");
				} else {

				}

			} else if (choice2.toLowerCase().equals("n")) {
				if (sub.changeActive(custID, false, db)) {
					System.out.println("Customer with details:" + custID + " now has an inactive subscription");
				} else {
					System.out.println("Please enter a valid option");
				}

			}

			Subscription();

		} else if (choice == 6) {

			System.out.println("Modify Subscription");
			System.out.println("Enter subscription ID");
			int subID = sc.nextInt();
			System.out.println("Enter Customer's ID");
			int custID = sc.nextInt();
			System.out.println("Enter Publication's ID");
			int pubID = sc.nextInt();
			System.out.println("Enter Customer's Subcription frequency");
			String frequency = sc.next();
			System.out.println("Enter y if customer has an active sub and n if customer has a non-active subscription");
			String choice2 = sc.next();
			if (choice2.toLowerCase().equals("y")) {
				if (sub.modifySubscription(subID, custID, frequency, true, pubID, db)) {
					System.out.println("Customer with ID:" + custID + " now has been modified");
				} else {

				}

			} else if (choice2.toLowerCase().equals("n")) {
				if (sub.modifySubscription(subID, custID, frequency, false, pubID, db)) {
					System.out.println("Customer with details:" + custID + " now has been modified");
				} else {
					System.out.println("Please enter a valid option");
				}

			}

			Subscription();

		} else if (choice == 7) {
			System.out.println("Are you sure you want to exit press y to exit and n to not exit :");
			String choice2 = sc.next();

			if (choice2.toLowerCase().equals("y")) {
				ManagerScreen();
			} else if ((choice2.toLowerCase().equals("n"))) {
				Subscription();
			} else {
				System.out.println("Enter a valid option");
				Subscription();
			}
		} else {
			System.out.println("Enter a valid Option");
			Subscription();

		}

	}

	public static void Driver() {

		System.out.println("Press 1: Create Driver");
		System.out.println("Press 2: Look up Driver");
		System.out.println("Press 3: Archive Driver with name");
		System.out.println("Press 4: Unarchive Driver with name");
		System.out.println("Press 5: Modify Driver's details");
		System.out.println("Press 6: Exit Driver");
		int choice = sc.nextInt();
		if (choice == 1) {
			System.out.println("Kindly enter Driver details");
			System.out.println("Kindly enter Driver's name");
			String Name = sc.next();
			System.out.println("Kindly enter Driver's Password");
			String Password = sc.next();
			if (driver.createDriver(Name, Password, db)) {

				System.out.println("Driver succesfully created: " + db.getDriverName(Name));
				Driver();

			} else {
				System.out.println("Driver not created");
				Driver();
			}

		} else if (choice == 2) {
			System.out.println("Enter Driver's name:");
			String name = sc.next();
			String res = "";
			res = driver.lookUpDriver(name, db);
			System.out.println(res);
			Driver();
		} else if (choice == 3) {
			System.out.println("Enter Driver's name to archive:");
			String name = sc.next();
			String res = "";

			if (driver.archiveDriver(name, db)) {
				System.out.println("Driver has been archive " + db.getarchiveDriver(name));
				Driver();
			}
			// else if(name.equals("")){
			// System.out.println("Enter a driver's name");
			// Driver();
			// }
			else {
				System.out.println("Driver has not been deleted");
				Driver();
			}

		} else if (choice == 4) {
			System.out.println("Enter Driver's name to unarchive:");
			String name = sc.next();
			String res = "";

			if (driver.unArchiveDriver(name, db)) {
				System.out.println("Driver has been unarchived " + db.getDriverName(name));
				Driver();
			}
			// else if(name.equals("")){
			// System.out.println("Enter a driver's name");
			// Driver();
			// }
			else {
				System.out.println("Driver has not been unarchived");
				Driver();
			}

		} else if (choice == 5) {
			System.out.println("Enter Driver's ID");
			int DriverID = sc.nextInt();

			System.out.println("Enter Driver's Name");
			String name = sc.next();

			System.out.println("Enter Driver's Passsword");
			String password = sc.next();

			if (driver.modifyDriver(DriverID, name, password, db)) {
				System.out.println(db.getDriverName(name) + " been modified");
				Driver();
			}
			// else if(name.equals("")){
			// System.out.println("Enter a driver's name");
			// Driver();
			// }
			else {
				System.out.println("Driver has not been modified");
				Driver();
			}

		}

		else if (choice == 6) {
			System.out.println("Are you sure you want to exit press y to exit and n to not exit :");
			String choice2 = sc.next();

			if (choice2.toLowerCase().equals("y")) {
				ManagerScreen();
			} else if ((choice2.toLowerCase().equals("n"))) {
				Driver();
			} else {
				System.out.println("Enter a valid option:");
				Driver();
			}

		} else {
			System.out.println("Enter a valid Option");
			Driver();
		}

	}

	public static void Docket() {
		System.out.println("Press 1: Create Docket");
		System.out.println("Press 2: Look up Docket");
		System.out.println("Press 3: Add Order ID to Docket");
		System.out.println("Press 4: Modify Docket");
		System.out.println("Press 5: Exit Docket");
		int choice = sc.nextInt();
		if (choice == 1) {
			System.out.println("Kindly enter Docket detail");
			System.out.println("Kindly enter Driver's ID:");
			int ID = sc.nextInt();

			if (docket.createDocket(ID, db)) {

				System.out.println("Docket succesfully created: " + db.getDocket_id(ID));
				Docket();

			} else {
				System.out.println("Docket not created");
				Docket();
			}

		}

		else if (choice == 2) {
			System.out.println("Enter the docket ID");

			int ID = sc.nextInt();

			if (ID < 1 || ID > 1000) {
				System.out.println("Docket not found");
				Docket();
			} else {
				String res = "";
				res = db.getDocket_id(ID);
				System.out.println("Docket found: " + res);
				Docket();
			}

		} else if (choice == 3) {
			System.out.println("Enter the Docket ID");
			int DocketID = sc.nextInt();
			System.out.println("Enter the Order ID");
			int OrderID = sc.nextInt();

			if (docket.addOrderToDocket(DocketID, OrderID, db)) {
				System.out.println("Order ID " + OrderID + " has been enter to Docket ID " + DocketID);
				Docket();
			} else {
				System.out.println("Error Occured in adding order ID please try again");
				Docket();
			}

		} else if (choice == 4) {

			System.out.println("Modify Docket");
			System.out.println("Enter Docket ID");
			int DocketID = sc.nextInt();
			System.out.println("Enter Driver ID");
			int driverID = sc.nextInt();
			System.out.println("Enter Order ID");
			int orderID = sc.nextInt();
			System.out.println("Enter Y if you want modify driver, N if you do not want ");
			String choice2 = sc.next();
			if (choice2.toLowerCase().equals("y")) {
				if (docket.modifyDocket(DocketID, driverID, orderID, db)) {
					System.out.println("Successfully! ");
					Docket();
				} else {

				}

			} else if (choice2.toLowerCase().equals("n")) {

				System.out.println("Bye! ");
				Docket();
			} else {

				System.out.println("Please choose a valid option ");
				Docket();

			}

			Docket();

		} else if (choice == 5) {
			System.out.println("Are you sure you want to exit press y to exit and n to not exit :");
			String choice2 = sc.next();

			if (choice2.toLowerCase().equals("y")) {
				ManagerScreen();
			} else if ((choice2.toLowerCase().equals("n"))) {
				Docket();
			} else {
				System.out.println("Enter a valid option:");
				Docket();
			}
		} else {
			System.out.println("Enter a valid Option");
			Docket();
		}

	}

	public static void DeliveryArea() {
		System.out.println("Press 1: Create Delivery Area");
		System.out.println("Press 2: Look up Delivery area");
		System.out.println("Press 3: Exit Delivery Area");
		int choice = sc.nextInt();
		if (choice == 1) {
			System.out.println("Kindly enter Delivery Area details");
			System.out.println("Kindly enter Delivery Area address:");
			String address = sc.next();

			System.out.println("Kindly enter Driver's ID");
			int driverID = sc.nextInt();

			System.out.println("Kindly enter Customer's ID");
			int custID = sc.nextInt();

			if (deliveryArea.createDeliveryArea(address, driverID, custID, db)) {
				System.out.println("Delivery area created succesfully");
				DeliveryArea();
			} else {
				System.out.println("Delivery area not created");
				DeliveryArea();
			}

		}

		else if (choice == 2) {
			System.out.println("Enter delivery Area ID:");
			int DA = sc.nextInt();
			String res = deliveryArea.getDeliveryArea(DA, db);
			if (res == "") {
				System.out.println("Delivery Area not found");
			} else {
				System.out.println(res);
			}
			DeliveryArea();

		} else if (choice == 3) {
			System.out.println("Are you sure you want to exit press y to exit and n to not exit :");
			String choice2 = sc.next();

			if (choice2.toLowerCase().equals("y")) {
				ManagerScreen();
			} else if ((choice2.toLowerCase().equals("n"))) {
				DeliveryArea();
			} else {
				System.out.println("Enter a valid option:");
				DeliveryArea();
			}
		} else {
			System.out.println("Enter a valid Option");
			DeliveryArea();
		}
	}

	public static void Stock() {
		System.out.println("Choose an option");
		System.out.println("Press1: Create a publication");
		System.out.println("Press2: Look up publication");
		System.out.println("Press3: Update publication");
		System.out.println("Press4: Exit publication screen");
		int choice = sc.nextInt();
		if (choice == 1) {

			System.out.println("Enter Publication Name:");
			String name = sc.next();
			System.out.println("Enter Publication Cost");
			double cost = sc.nextDouble();

			if (stock.createPublication(name, cost, db)) {

				System.out.println("Publication ID succesfully created ");
				Stock();

			} else {
				System.out.println("Publication not created");
				Stock();
			}
		}
		if (choice == 2) {
			String res = "";
			System.out.println("Enter Publication ID");
			int pubID = sc.nextInt();
			res = stock.getPublication(pubID, db);
			System.out.println(res);
			Stock();

		} else if (choice == 3) {
			System.out.println("Enter Publication ID");
			int pubID = sc.nextInt();
			System.out.println("Enter Publication Name: ");
			String pubName = sc.next();
			System.out.println("Enter Publication Cost");
			double pubCost = sc.nextDouble();
			stock.updatePublication(pubID, pubName, pubCost, db);
			Stock();
		}

		else if (choice == 4) {
			System.out.println("Are you sure you want to exit press y to exit and n to not exit :");
			String choice2 = sc.next();

			if (choice2.toLowerCase().equals("y")) {
				ManagerScreen();
			} else if ((choice2.toLowerCase().equals("n"))) {
				Stock();
			} else {
				System.out.println("Enter a valid option:");
				Stock();
			}
		}
	}

	public static void Order() {
		System.out.println("Choose an option");
		System.out.println("Press1: Create an order");
		System.out.println("Press2: Look up Order");
		System.out.println("Press3: Archive Order");
		System.out.println("Press4: Generate Customer's Invoice");
		System.out.println("Press5: Exit Order screen");
		int choice = sc.nextInt();
		if (choice == 1) {

			System.out.println("Enter Customer Id:");
			int custID = sc.nextInt();
			System.out.println("Enter Publication Id:");
			int pubID = sc.nextInt();
			System.out.println("Enter Subscription Id");
			int subID = sc.nextInt();

			if (order.createOrder(custID, pubID, subID, db)) {

				System.out.println("Order ID succesfully created ");
				Order();

			} else {
				System.out.println("Order not created");
				Order();
			}
		}

		if (choice == 2) {
			String res = "";
			System.out.println("Enter Order ID");
			int orderID = sc.nextInt();
			res = order.getOrder(orderID, db);
			System.out.println("Customer's Order");
			System.out.println("-----------------------------");
			System.out.println(res);
			Order();

		} else if (choice == 3) {
			System.out.println("Enter Order Id:");
			int orderID = sc.nextInt();
			if (order.deleteOrders(orderID, db)) {
				System.out.println("Order successfully deleted");
				Order();
			}
		} else if (choice == 4) {
			System.out.println("Enter Customer's Id to generate invoice:");
			int custID = sc.nextInt();
			String res = order.generateInvoice(custID, db);

			if (res == "") {
				System.out.println("There is no invoice to generate");
			} else {
				System.out.println("Customer's Invoice ");
				System.out.println("-------------------------- ");
				System.out.println(res);
			}
			Order();

		}

		else if (choice == 5) {
			System.out.println("Are you sure you want to exit press y to exit and n to not exit :");
			String choice2 = sc.next();

			if (choice2.toLowerCase().equals("y")) {
				ManagerScreen();
			} else if ((choice2.toLowerCase().equals("n"))) {
				Order();
			} else {
				System.out.println("Enter a valid option:");
				Order();
			}
		} else {
			System.out.println("Enter a valid Option");
			Order();

		}
	}

	public static void DeliveryStatusScreen() {
		System.out.println("\nChoose an option");
		System.out.println("Press 1: Change your delivery status");
		System.out.println("Press 2: Print Docket details");
		System.out.println("Press 3: Print Customer's Invoice");
		System.out.println("Press 4: Exit");
		int choice = sc.nextInt();
		if (choice == 1) {
			System.out.println("Press1: Enter the delivery docket ID assigned to you");
			int DocketID = sc.nextInt();
			System.out.println("Was the delivery a success, enter y for yes and n for no :");
			String status = sc.next();

			if (status.toLowerCase().equals("y")) {
				if (driver.deliveryStatus(DocketID, true, db))
					System.out.println("Status has been changed to delivered");
				DeliveryStatusScreen();

			} else if (status.toLowerCase().equals("n")) {
				if (driver.deliveryStatus(DocketID, false, db))
					System.out.println("Delivery status has been changed to not delivered");
				DeliveryStatusScreen();
			} else {
				System.out.println("Please enter a valid letter:");
				DeliveryStatusScreen();
			}

		}

		else if (choice == 2) {

			System.out.println("Please enter docket id");
			int did = sc.nextInt();

			if (did == 0) {
				DeliveryStatusScreen();
			} else {
				String res = docket.lookDocket(did, db);
				System.out.println(res);
				DeliveryStatusScreen();
			}

		} else if (choice == 3) {
			System.out.println("Enter Customer's Id to generate invoice:");
			int custID = sc.nextInt();
			String res = order.generateInvoice(custID, db);

			if (res == "") {
				System.out.println("There is no invoice to generate");
			} else {
				System.out.println("Customer's Invoice ");
				System.out.println("-------------------------- ");
				System.out.println(res);
			}
			DeliveryStatusScreen();

		}

		else if (choice == 4) {
			System.out.println("Are you sure you want to exit press y to exit and n to not exit :");
			String choice2 = sc.next();

			if (choice2.toLowerCase().equals("y")) {
				main(null);
			} else if ((choice2.toLowerCase().equals("n"))) {
				DeliveryStatusScreen();
			} else {
				System.out.println("Enter a valid option:");
				DeliveryStatusScreen();
			}
		} else {
			System.out.println("Please enter a valid Option");
			DeliveryStatusScreen();
		}

	}

}
