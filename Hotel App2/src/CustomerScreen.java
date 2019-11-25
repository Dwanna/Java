import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

import java.util.*; //This is new

public class CustomerScreen extends JFrame implements ActionListener {

	static private String Name = "";
	static private String Room = "";
	static private int price1 = 0;
	

	public CustomerScreen(String s) {
		super(s);
		JPanel mainCustomerPanel = new JPanel();
		JButton setDetails = new JButton("Book my room");
		Database db = new Database();

		// String name=customer.getName();
		// System.out.println(name);
		JLabel l0 = new JLabel(
				"																						Welcome " + s);

		java.awt.Container content = getContentPane();
		content.setLayout(new BorderLayout());
		content.setBackground(Color.DARK_GRAY);
		Font f = new Font("TimesRoman", Font.BOLD, 20);
		l0.setFont(f);
		setSize(725, 550);

		// content.add(l0);

		mainCustomerPanel.setLayout(new BorderLayout());
		mainCustomerPanel.setBackground(Color.LIGHT_GRAY);

		manageDetails manage = new manageDetails("", 0, "", 0);
		
		String id = "";
		String room = "";
		int price = 0;

		////////////////////// CENTER PANEL
		JPanel topPanel = new JPanel();
		JPanel topPanel1 = new JPanel();
		JPanel topPanel2 = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel1.setLayout(new BorderLayout());
		topPanel2.setLayout(new BorderLayout());

		final CardLayout cards = new CardLayout();
		final JPanel cardPanel = new JPanel();
		cardPanel.setLayout(cards);

		JButton viewCustomer = new JButton("View Rooms");
		Border emptyBorder = BorderFactory.createEmptyBorder();
		viewCustomer.setBorder(emptyBorder);// Removes border around the button

		topPanel1.add(viewCustomer);

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3, 1));///

		JPanel p1a = new JPanel();/// first picture
		p1a.setLayout(new BorderLayout());

		JLabel label = new JLabel();

		ImageIcon icon = new ImageIcon("/Users/daniel/eclipse-workspace/Hotel App2/src/sing.jpg");
		label.setIcon((Icon) icon);
		JRadioButton one = new JRadioButton("Single room");

		p1a.add(label);
		p1a.add(one, BorderLayout.SOUTH);

		JPanel p1b = new JPanel();///// second picture
		p1b.setLayout(new BorderLayout());

		ImageIcon icon1 = new ImageIcon("/Users/daniel/eclipse-workspace/Hotel App2/src/double.jpg");
		JLabel label1 = new JLabel();
		label1.setIcon(icon1);
		JRadioButton two = new JRadioButton("Double room");

		p1b.add(label1);
		p1b.add(two, BorderLayout.SOUTH);

		JPanel p1c = new JPanel();/// third picture
		p1c.setLayout(new BorderLayout());

		ImageIcon icon2 = new ImageIcon("/Users/daniel/eclipse-workspace/Hotel App2/src/penthouse.jpg");
		JLabel label2 = new JLabel();

		label2.setIcon(icon2);
		JRadioButton three = new JRadioButton("Penthouse");
		p1c.add(label2);
		p1c.add(three, BorderLayout.SOUTH);

		ButtonGroup group = new ButtonGroup(); //
		group.add(one);
		group.add(two);
		group.add(three);

		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());// third Screen

		JPanel boxPanel = new JPanel();
		boxPanel.setLayout(new GridLayout(3, 1));
		JButton back1 = new JButton("Back");
		JLabel daysBookedLabel = new JLabel("Days booked");
		JComboBox<Integer> daysBox = new JComboBox<Integer>();
		daysBox.addItem(1);
		daysBox.addItem(2);
		daysBox.addItem(3);
		daysBox.addItem(4);
		daysBox.addItem(5);
		daysBox.addItem(6);
		daysBox.addItem(7);
		daysBox.addItem(8);
		daysBox.addItem(9);
		daysBox.addItem(10);
		boxPanel.add(daysBookedLabel);
		boxPanel.add(daysBox);
		boxPanel.add(back1);

		p.add(p1a);
		p.add(p1b);
		p.add(p1c);
		p2.add(p);
		p2.add(boxPanel, BorderLayout.SOUTH);
		topPanel2.add(p2);

		// cardPanel.add(topPanel1,"topPanel1");//

		cardPanel.add(topPanel1, "topPanel1");
		cardPanel.add(topPanel2, "topPanel2");

		// cardPanel.add(topPanel,"topPanel");
		// cardPanel.add(topPanel2,"topPanel2");

		/// Should be the other way around, later.....
		// cardPanel.add(topPanel2,"topPanel2");//Ass one panel

		ActionListener clicked0 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (one.isSelected()) {

					// t2.setText("Single");
					JOptionPane.showMessageDialog(null, "  Single Room Added");
					manage.setRoom("Single");

				}

				if (two.isSelected()) {
					// t2.setText("Double");
					JOptionPane.showMessageDialog(null, " Double Room Added");
					manage.setRoom("Double");

				}

				if (three.isSelected()) {
					// t2.setText("Penthouse");
					JOptionPane.showMessageDialog(null, " PenthHouse Added");
					manage.setRoom("PenthHouse");

				}

			}

		};

		one.addActionListener(clicked0);
		two.addActionListener(clicked0);
		three.addActionListener(clicked0);

		//
		// cardPanel.add(topPanel1,"topPanel1");
		//
		topPanel.add(cardPanel);

		//////////////////////// BOTTOM PANEL

		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.setBackground(Color.LIGHT_GRAY);

		JLabel notify = new JLabel(
				"The availabilty of rooms may differ within the next 24H,\n so its advisable to still book unavailable rooms");

		JPanel availabilityPanel = new JPanel();
		availabilityPanel.setLayout(new GridLayout(1, 2));
		JLabel availabilityLabel = new JLabel("Available room");
		JComboBox<String> availablityBox = new JComboBox<String>();
		availabilityPanel.add(availabilityLabel);
		availabilityPanel.add(availablityBox);

		JPanel statusPanel = new JPanel();
		statusPanel.setLayout(new GridLayout(3, 1));
		JLabel status = new JLabel("						Waiting for confirmation ");
		JButton statusBook = new JButton("Make Booking");
		JButton statusExit = new JButton("Exit");

		statusPanel.add(status);
		statusPanel.add(statusBook);
		statusPanel.add(statusExit);

		bottomPanel.add(notify, BorderLayout.NORTH);
		// bottomPanel.add(availabilityPanel,BorderLayout.CENTER);
		bottomPanel.add(statusPanel, BorderLayout.SOUTH);

		mainCustomerPanel.add(l0, BorderLayout.NORTH);
		mainCustomerPanel.add(topPanel, BorderLayout.CENTER);
		mainCustomerPanel.add(bottomPanel, BorderLayout.SOUTH);

		// cardPanel.add(mainCustomerPanel,"mainCustomerPanel");
		// cardPanel.add(topPanel2,"topPanel2");

		content.add(mainCustomerPanel);

		ActionListener clicked1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainScreen main= mainScreen.getInstance();

				cards.show(cardPanel, "topPanel2");

				manage.setName(s);
				manage.setAge(main.returnAge());
				// System.out.println(main.returnAge());

			}
		};

		viewCustomer.addActionListener(clicked1);

		ActionListener clicked2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int days = (int) daysBox.getSelectedItem();

				cards.show(cardPanel, "topPanel1");

				// int getPrice= manage.getPrice();
				if (one.isSelected()) {

					// t2.setText("Single");

					manage.setPrice(75 * days);

				}

				if (two.isSelected()) {
					// t2.setText("Double");

					manage.setPrice(85 * days);

				}

				if (three.isSelected()) {
					// t2.setText("Penthouse");

					manage.setPrice(200 * days);

				}

			}
		};

		back1.addActionListener(clicked2);

		ActionListener clicked3 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mainScreen main=mainScreen.getInstance();
				//// Using singleton pattern
				setVisible(false);

				// System.out.println(manage.readName());
				// System.out.println(manage.readRoom());
				// System.out.println(manage.readAge());
				// System.out.println(manage.getPrice());

			}
		};

		statusExit.addActionListener(clicked3);

		ActionListener clicked4 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String Input = JOptionPane.showInputDialog(null,
						manage.readName() + " your booking includes a " + manage.readRoom() + " booked for "
								+ daysBox.getSelectedItem() + " days which cost  " + manage.getPrice() + "euro",
						"Are you sure you want to continue with this booking,Please input Yes or No",
						JOptionPane.INFORMATION_MESSAGE);
				if (Input.equals("Yes")) {

					JOptionPane.showMessageDialog(null, " You have placed a booking");
					Name = manage.readName();
					Room = manage.readRoom();
					price1 = manage.getPrice();
				} else {
					JOptionPane.showMessageDialog(null,
							" Please exit the app or place the booking has all booking info has been reset");
					manage.setRoom("");
					manage.setPrice(0);
				}

			}
		};

		statusBook.addActionListener(clicked4);

		// setDetails.addActionListener(this);
		// statusExit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public String returnName() {
		return Name;
	}

	public String returnRoom() {
		return Room;
	}

	public int returnPrice() {
		return price1;
	}

}
