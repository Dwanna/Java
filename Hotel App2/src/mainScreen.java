import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

class mainScreen extends JFrame implements ActionListener {
	private JLabel l0 = new JLabel(
			"																								Hotel App");

	private JButton b1 = new JButton("Manager");
	private JButton b2 = new JButton("Customer");
	private JButton b3 = new JButton("Click here if you're a New Customer");
	private JButton b4 = new JButton("Exit");
	private JPanel p1 = new JPanel();
	private JPanel managerScreen = new JPanel();
	private JPanel customerLogin = new JPanel();
	private JPanel newCustomer = new JPanel();

	private int value = 0;
	public static mainScreen single;
	private static boolean created = false;

	static private int Age = 0;
	static private int ID = 0;

	// CONSTRUCTOR
	public mainScreen() {
		// super(s);
		Database db = new Database();

		db.initDBConnection();
		single= this; created = true;/// shows the class has been initially called
		value=0;

		final CardLayout cards = new CardLayout();
		final JPanel cardPanel = new JPanel();
		cardPanel.setLayout(cards);
		manageDetails cust = new manageDetails("", 0, "", 0);

		java.awt.Container content = getContentPane();
		content.setLayout(new BorderLayout());
		content.setBackground(Color.DARK_GRAY);
		p1.setBackground(Color.DARK_GRAY);
		Font f = new Font("TimesRoman", Font.BOLD, 20);
		p1.setLayout(new GridLayout(4, 1));
		l0.setFont(f);
		p1.add(l0, BorderLayout.CENTER);

		content.add(cardPanel);//// Adds cardPanel
		content.add(b4, BorderLayout.SOUTH);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);

		// cardPanel.add(p1,"p1");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		// Horiz , Vert
		setSize(370, 500);
		setVisible(true);

		//// Manager Screen
		JPanel managerScreen1 = new JPanel();
		managerScreen1.setBackground(Color.LIGHT_GRAY);
		JPanel managerScreen2 = new JPanel();
		managerScreen2.setBackground(Color.LIGHT_GRAY);
		JPanel managerScreen3 = new JPanel();
		managerScreen3.setLayout(new BorderLayout());

		managerScreen.setLayout(new BorderLayout());

		JLabel managerUserName = new JLabel("Manager Username");
		JTextField managerUsernameTF = new JTextField(10);

		JLabel managerPassword = new JLabel("Manager Password");
		JTextField managerPasswordTF = new JTextField(10);

		JButton managerLogin = new JButton("LOGIN");

		JButton managerBack = new JButton("BACK");

		managerScreen1.setLayout(new GridLayout(2, 2));
		managerScreen1.add(managerUserName);
		managerScreen1.add(managerUsernameTF);
		managerScreen1.add(managerPassword);
		managerScreen1.add(managerPasswordTF);

		managerScreen2.add(managerLogin);

		managerScreen3.add(managerBack);
		managerScreen.setBackground(Color.DARK_GRAY);

		managerScreen.add(managerScreen1, BorderLayout.NORTH);
		managerScreen.add(managerScreen2, BorderLayout.CENTER);
		managerScreen.add(managerScreen3, BorderLayout.SOUTH);

		///// Customer Login
		JPanel customerScreen1 = new JPanel();
		customerScreen1.setBackground(Color.LIGHT_GRAY);

		JPanel customerScreen2 = new JPanel();
		customerScreen2.setBackground(Color.LIGHT_GRAY);

		JPanel customerScreen3 = new JPanel();
		customerScreen3.setLayout(new BorderLayout());

		JLabel customerUserName = new JLabel("Customer Username");
		JTextField customerUserNameTF = new JTextField(10);

		JLabel customerPassword = new JLabel("Customer Password");
		JTextField customerPasswordTF = new JTextField(10);

		JButton loginCustomer = new JButton("LOGIN");

		JButton loginCustomerBack = new JButton("Back");

		customerScreen1.setLayout(new GridLayout(2, 2));
		customerScreen1.add(customerUserName);
		customerScreen1.add(customerUserNameTF);
		customerScreen1.add(customerPassword);
		customerScreen1.add(customerPasswordTF);

		customerScreen2.add(loginCustomer);
		customerScreen3.add(loginCustomerBack);

		customerLogin.setLayout(new BorderLayout());
		customerLogin.setBackground(Color.DARK_GRAY);

		customerLogin.add(customerScreen1, BorderLayout.NORTH);
		customerLogin.add(customerScreen2, BorderLayout.CENTER);
		customerLogin.add(customerScreen3, BorderLayout.SOUTH);

		/////// Create Customer

		JPanel createScreen1 = new JPanel();
		createScreen1.setBackground(Color.LIGHT_GRAY);
		JPanel createScreen2 = new JPanel();
		createScreen2.setBackground(Color.LIGHT_GRAY);

		JPanel createScreen3 = new JPanel();
		createScreen3.setLayout(new BorderLayout());

		JLabel customerUserName1 = new JLabel("Enter your Username");
		JTextField customerUserNameTF1 = new JTextField(10);

		JLabel customerPassword1 = new JLabel("Enter your Password");
		JTextField customerPasswordTF1 = new JTextField(10);

		JLabel customerTelephone = new JLabel("Enter your telephone number:");
		JTextField customerTelephoneTF = new JTextField(10);

		JLabel customerAge = new JLabel("Enter your Age:");
		JTextField customerAgeTF = new JTextField(10);

		JButton createButton = new JButton("Create your account");

		JButton createButtonBack = new JButton("BACK");

		createScreen1.setLayout(new GridLayout(4, 2));
		createScreen1.add(customerUserName1);
		createScreen1.add(customerUserNameTF1);
		createScreen1.add(customerPassword1);
		createScreen1.add(customerPasswordTF1);
		createScreen1.add(customerTelephone);
		createScreen1.add(customerTelephoneTF);
		createScreen1.add(customerAge);
		createScreen1.add(customerAgeTF);

		createScreen2.add(createButton);
		createScreen3.add(createButtonBack);

		newCustomer.setLayout(new BorderLayout());
		newCustomer.setBackground(Color.DARK_GRAY);

		newCustomer.add(createScreen1, BorderLayout.NORTH);
		newCustomer.add(createScreen2, BorderLayout.CENTER);
		newCustomer.add(createScreen3, BorderLayout.SOUTH);

		///////////////////////////////////////////////

		cardPanel.add(p1, "p1");
		cardPanel.add(managerScreen, "managerScreen");
		cardPanel.add(customerLogin, "customerLogin");
		cardPanel.add(newCustomer, "newCustomer");

		///// Actions to change between panels
		ActionListener one = new ActionListener() {/// Shows Manager Panel
			public void actionPerformed(ActionEvent e) {

				cards.show(cardPanel, "managerScreen");

			}
		};
		b1.addActionListener(one);

		ActionListener two = new ActionListener() {/// Shows customer Login
			public void actionPerformed(ActionEvent e) {

				cards.show(cardPanel, "customerLogin");

			}
		};
		b2.addActionListener(two);

		ActionListener three = new ActionListener() {/// Shows new Customer Panel
			public void actionPerformed(ActionEvent e) {

				cards.show(cardPanel, "newCustomer");

			}
		};
		b3.addActionListener(three);

		ActionListener four = new ActionListener() {/// Shows new Customer Panel
			public void actionPerformed(ActionEvent e) {

				cards.show(cardPanel, "p1");

			}
		};
		managerBack.addActionListener(four);

		ActionListener five = new ActionListener() {/// Shows new Customer Panel
			public void actionPerformed(ActionEvent e) {

				cards.show(cardPanel, "p1");

			}
		};
		loginCustomerBack.addActionListener(five);

		ActionListener six = new ActionListener() {/// Shows new Customer Panel
			public void actionPerformed(ActionEvent e) {

				cards.show(cardPanel, "p1");

			}
		};
		createButtonBack.addActionListener(six);

		/////////////////////////////////// Getting Strings

		// System.out.println(age);

		ActionListener nine = new ActionListener() {/// Allows manager to login using Admin for usernmame and Pass is Password
			public void actionPerformed(ActionEvent e) {

				String nam = managerUsernameTF.getText();
				String pass = managerPassword.getText();
				//
				// String name1="admin";
				// String pass1= "password";

				if (managerUsernameTF.getText().equals("") || managerPassword.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Make sure you enter username and password");
				} else if (managerUsernameTF.getText().equals("Admin")
						|| managerPasswordTF.getText().equals("Password")) {
					JOptionPane.showMessageDialog(null, "Succesful login");
					new ManagerScreen("Admin");
					// System.out.println(nam+""+pass);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid username or password");
				}

			}
		};
		managerLogin.addActionListener(nine);

		ActionListener seven = new ActionListener() {/// Shows new Customer Panel
			public void actionPerformed(ActionEvent e) {
				String name = customerUserNameTF1.getText();
				String password = customerPasswordTF1.getText();
				String telephone = customerTelephoneTF.getText();
				String age1 = customerAgeTF.getText();
				int age = Integer.parseInt(age1);
				if (customerUserNameTF1.getText().equals("") || customerPasswordTF1.getText().equals("")
						|| customerTelephoneTF.getText().equals("") || age <= 18) {

					JOptionPane.showMessageDialog(null, "Make sure all details are entered correctly");

				}

				else {
					db.createCustomer(name, password, telephone, age);
					JOptionPane.showMessageDialog(null, "Your account has been created");

				}

			}
		};
		createButton.addActionListener(seven);

		ActionListener eight = new ActionListener() {/// Shows new Customer Panel
			public void actionPerformed(ActionEvent e) {
				String name = customerUserNameTF.getText();
				String password = customerPasswordTF.getText();

				String n = db.Username(name);
				String p = db.Password(password);
				int age = db.age(name);
				int id = db.id(name);

				if (customerUserNameTF.getText().equals("") || customerPasswordTF.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Make sure all details are entered correctly");

				}

				else if (n.equals(name) && p.equals(password)) {
					JOptionPane.showMessageDialog(null, "Succesfully logged in");
					// new CustomerScreen(n);

					Age = age;
					ID = id;
					// System.out.println(Age);
					// System.out.println(ID);
					new CustomerScreen(n).setVisible(true);
					

					// customer.set mmmmmmmmmmmmmName(n);

				} else {
					JOptionPane.showMessageDialog(null, "Invalid username or password");
				}

			}
		};
		loginCustomer.addActionListener(eight);

	}

	public void actionPerformed(ActionEvent e) {

		Object target = e.getSource();

		if (target == b4) {
			System.exit(0);
		}

	}

	public static mainScreen getInstance() {// intansiate the singleton pattern
		if (!created) {
			single = new mainScreen();
		}
		return single;
	}
//
//	public void setvisible(boolean v) {
//		if (v == false) {
//			this.setVisible(false);
//		} else {
//			this.setvisible(true);
//		}
//	}

	public int returnAge() {
		return Age;
	}

	public int returnId() {
		return ID;
	}

}
