import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

@SuppressWarnings("serial")
public class JDBCMainWindowContent extends JInternalFrame implements ActionListener
{	
	String cmd = null;

	// DB Connectivity Attributes
	private Connection con = null;
	private Statement stmt = null;
	private Statement stmt1 = null;
	private ResultSet rs = null;
	

	private Container content;

	private JPanel detailsPanel;
	private JPanel detailsPanel1;
	private JPanel exportButtonPanel;
	//private JPanel exportConceptDataPanel;
	private JScrollPane dbContentsPanel;
	private JScrollPane dbContentsPanel1;

	private Border lineBorder;

	private JLabel IDLabel=new JLabel("ID:                 ");
	private JLabel FirstNameLabel=new JLabel("FirstName:               ");
	private JLabel LastNameLabel=new JLabel("LastName:      ");
	private JLabel AgeLabel=new JLabel("Age:        ");
	private JLabel GenderLabel=new JLabel("Gender:                 ");
	private JLabel RoomLabel=new JLabel("Room Type:               ");
	private JLabel PriceLabel=new JLabel("Price:      ");
	private JLabel DaysLabel=new JLabel("Days Booked:      ");
	private JLabel CheckInLabel=new JLabel("Check In:        ");
	private JLabel PaidBy=new JLabel("Paid By:        ");
	private JLabel CustomerID=new JLabel("Customer ID:        ");

	private JTextField IDTF= new JTextField(10);
	private JTextField FirstNameTF=new JTextField(10);
	private JTextField LastNameTF=new JTextField(10);
	private JTextField AgeTF=new JTextField(10);
	private JComboBox <String>GenderBox=new JComboBox<String>();
	private JComboBox <String>RoomBox=new JComboBox<String>();
	private JTextField PriceTF=new JTextField(10);
	private JComboBox <Integer>DaysBookedBox=new JComboBox<Integer>();
	private JComboBox <String>CheckInBox=new JComboBox<String>();
	private JComboBox <String>PaidByBox=new JComboBox<String>();
	private JTextField CustomerIDTF=new JTextField(10);
	


	private static QueryTableModel TableModel = new QueryTableModel();
	private static QueryTableModel TableModel1 = new QueryTableModel();
	//Add the models to JTabels
	private JTable TableofDBContents=new JTable(TableModel);
	private JTable TableofDBContents1=new JTable(TableModel1);
	//Buttons for inserting, and updating members
	//also a clear button to clear details panel
	private JButton updateButton = new JButton("Update");
	private JButton insertButton = new JButton("Insert");
	private JButton exportButton  = new JButton("Export");
	private JButton deleteButton  = new JButton("Delete");
	private JButton clearButton  = new JButton("Clear");

	private JButton  TPrice = new JButton("Total Price for customers");
	private JTextField checkInTF  = new JTextField(12);
	private JButton searchCustomer  = new JButton("Search Customer");
	private JTextField searchCustomerTF  = new JTextField(12);
	private JButton searchCustomerByRoom  = new JButton("Room booked by customers");
	private JTextField searchCustomerByRoomTF  = new JTextField(12);
	private JButton TPriceCustomer  = new JButton("Price for a customer");
	private JTextField TPriceCustomerTF  = new JTextField(12);
	private JButton sortByGender  = new JButton("Sort by Gender");
	private JButton checkedIn = new JButton("Customer CheckedIn");
	private JButton countCheck = new JButton("Count checkedIn");
	
	



	public JDBCMainWindowContent( String aTitle)
	{	
		//setting up the GUI
		super(aTitle, false,false,false,false);
		setEnabled(true);

		initiate_db_conn();
		//add the 'main' panel to the Internal Frame
		content=getContentPane();
		content.setLayout(null);
		content.setBackground(Color.lightGray);
		lineBorder = BorderFactory.createEtchedBorder(15, Color.red, Color.black);

		//setup details panel and add the components to it
		detailsPanel=new JPanel();
		detailsPanel.setLayout(new GridLayout(12,2));
		detailsPanel.setBackground(Color.lightGray);
		detailsPanel.setBorder(BorderFactory.createTitledBorder(lineBorder, "CRUD Actions"));

		detailsPanel.add(IDLabel);			
		detailsPanel.add(IDTF);
		detailsPanel.add(FirstNameLabel);		
		detailsPanel.add(FirstNameTF);
		detailsPanel.add(LastNameLabel);		
		detailsPanel.add(LastNameTF);
		detailsPanel.add(AgeLabel);	
		detailsPanel.add(AgeTF);
		detailsPanel.add(GenderLabel);		
		detailsPanel.add(GenderBox);
		detailsPanel.add(RoomLabel);
		detailsPanel.add(RoomBox);
		detailsPanel.add(PriceLabel);
		detailsPanel.add(PriceTF);
		detailsPanel.add(DaysLabel);
		detailsPanel.add(DaysBookedBox);
		detailsPanel.add(CheckInLabel);
		detailsPanel.add(CheckInBox);
		detailsPanel.add(PaidBy);
		detailsPanel.add(PaidByBox);
		detailsPanel.add(CustomerID);
		detailsPanel.add(CustomerIDTF);
		
		
		//Adding Items to Combo boxes
		GenderBox.addItem("M");GenderBox.addItem("F");
		RoomBox.addItem("Single");RoomBox.addItem("Double");RoomBox.addItem("Triple");RoomBox.addItem("Queen");RoomBox.addItem("Penthhouse");
		DaysBookedBox.addItem(1);DaysBookedBox.addItem(2);DaysBookedBox.addItem(3);DaysBookedBox.addItem(4);DaysBookedBox.addItem(5);DaysBookedBox.addItem(6);DaysBookedBox.addItem(7);DaysBookedBox.addItem(8);DaysBookedBox.addItem(9);DaysBookedBox.addItem(10);
		CheckInBox.addItem("Yes");CheckInBox.addItem("No");
		PaidByBox.addItem("Card");PaidByBox.addItem("Cash");
		
		
		//Selecting RoomType 
		ActionListener clicked0 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		if(RoomBox.getSelectedItem().equals("Single")) {
			PriceTF.setText("70");
		}
		else if(RoomBox.getSelectedItem().equals("Double")) {
			PriceTF.setText("85");
		}
		else if(RoomBox.getSelectedItem().equals("Triple")) {
			PriceTF.setText("120");
		}
		else if(RoomBox.getSelectedItem().equals("Queen")) {
			PriceTF.setText("120");
		}
		else if(RoomBox.getSelectedItem().equals("Penthhouse"))  {
			PriceTF.setText("170");
		}
			
		}

		
		};

		RoomBox.addActionListener(clicked0);

	
		
		
		
		
		//setup details panel and add the components to it
		exportButtonPanel=new JPanel();
		exportButtonPanel.setLayout(new GridLayout(6,2));
		exportButtonPanel.setBackground(Color.lightGray);
		exportButtonPanel.setBorder(BorderFactory.createTitledBorder(lineBorder, "Export Data"));
		exportButtonPanel.add(checkedIn);
		exportButtonPanel.add(checkInTF);
		exportButtonPanel.add(searchCustomer);
		exportButtonPanel.add(searchCustomerTF);
		exportButtonPanel.add(searchCustomerByRoom);
		exportButtonPanel.add(searchCustomerByRoomTF);
		exportButtonPanel.add(TPriceCustomer);
		exportButtonPanel.add(TPriceCustomerTF);
		exportButtonPanel.add(sortByGender);
		exportButtonPanel.add(TPrice);
		exportButtonPanel.add(countCheck);
		exportButtonPanel.setSize(500, 200);
		exportButtonPanel.setLocation(3, 300);
		content.add(exportButtonPanel);

		insertButton.setSize(100, 30);
		updateButton.setSize(100, 30);
		exportButton.setSize (100, 30);
		deleteButton.setSize (100, 30);
		clearButton.setSize (100, 30);

		insertButton.setLocation(370, 10);
		updateButton.setLocation(370, 110);
		exportButton.setLocation (370, 160);
		deleteButton.setLocation (370, 60);
		clearButton.setLocation (370, 210);

		insertButton.addActionListener(this);
		updateButton.addActionListener(this);
		exportButton.addActionListener(this);
		deleteButton.addActionListener(this);
		clearButton.addActionListener(this);

		//this.ListAllDepartments.addActionListener(this);
		this.TPrice.addActionListener(this);
		this.searchCustomer.addActionListener(this);
		this.TPriceCustomer.addActionListener(this);
		this.checkedIn.addActionListener(this);
		this.searchCustomerByRoom.addActionListener(this);
		this.countCheck.addActionListener(this);
		this.sortByGender.addActionListener(this);

		content.add(insertButton);
		content.add(updateButton);
		content.add(exportButton);
		content.add(deleteButton);
		content.add(clearButton);


		TableofDBContents.setPreferredScrollableViewportSize(new Dimension(900, 300));
		TableofDBContents1.setPreferredScrollableViewportSize(new Dimension(900, 300));
		
		dbContentsPanel=new JScrollPane(TableofDBContents,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		dbContentsPanel.setBackground(Color.lightGray);
		dbContentsPanel.setBorder(BorderFactory.createTitledBorder(lineBorder,"Database Content"));
		
		dbContentsPanel1=new JScrollPane(TableofDBContents1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		dbContentsPanel1.setBackground(Color.lightGray);
		dbContentsPanel1.setBorder(BorderFactory.createTitledBorder(lineBorder,"Second Table"));
		
		
		

		detailsPanel.setSize(360, 300);
		detailsPanel.setLocation(3,0);
		dbContentsPanel.setSize(700, 250);
		dbContentsPanel.setLocation(520, 0);
		dbContentsPanel1.setSize(700, 200);
		dbContentsPanel1.setLocation(520, 300);
		content.add(detailsPanel);
		content.add(dbContentsPanel);
		content.add(dbContentsPanel1);

		setSize(982,645);
		setVisible(true);

		TableModel.refreshFromDB(stmt);
		TableModel1.refreshFromDB1(stmt1);
	}

	public void initiate_db_conn()
	{
		try
		{
			// Load the JConnector Driver
			//Class.forName("com.mysql.jdbc.Driver");
			// Specify the DB Name
			String url="jdbc:mysql://localhost:3306/BEng_Assign1";
			// Connect to DB using DB URL, Username and password
			con = DriverManager.getConnection(url, "root", "Danieldd11");
			//Create a generic statement which is passed to the TestInternalFrame1
			stmt = con.createStatement();
			stmt1 = con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("Error: Failed to connect to database DBB\n"+e.getMessage());
		}
	}

	//event handling 
	public void actionPerformed(ActionEvent e)
	{
		Object target=e.getSource();
		if (target == clearButton)
		{
			IDTF.setText("");
			FirstNameTF.setText("");
			LastNameTF.setText("");
			AgeTF.setText("");
			GenderBox.setSelectedItem("");
			RoomBox.setSelectedItem("");
			PriceTF.setText("");
			DaysBookedBox.setSelectedItem("");
			CheckInBox.setSelectedItem("");

		}

		if (target == insertButton)
		{		
			////Value for customer ID has to be inputed
			
			if(CustomerIDTF.getText().equals("")) {
				JOptionPane.showMessageDialog(null, " Please put in a Customer ID " );}
			else {
			try
			{
				
				
				String updateTemp ="INSERT INTO details VALUES("+
				null +",'"+FirstNameTF.getText()+"','"+LastNameTF.getText()+"',"+AgeTF.getText()+",'"+GenderBox.getSelectedItem()+"','"
				+RoomBox.getSelectedItem()+"',"+PriceTF.getText()+","+DaysBookedBox.getSelectedItem()+",'"+CheckInBox.getSelectedItem()+ "');";
				
				String updateTemp1 ="INSERT INTO Customer VALUES("+
						null +","+CustomerIDTF.getText()+",'"+PaidByBox.getSelectedItem()+ "');";
				stmt.executeUpdate(updateTemp);
				stmt1.executeUpdate(updateTemp1);

			}
			catch (SQLException sqle)
			{
				System.err.println("Error with  insert:\n"+sqle.toString());
			}
			
			finally
			{
				TableModel.refreshFromDB(stmt);
				TableModel1.refreshFromDB1(stmt1);
			}
			}
		
		}
		if (target == deleteButton)
		{

			try
			{
				String updateTemp ="DELETE FROM details WHERE id = "+IDTF.getText()+";"; 
				stmt.executeUpdate(updateTemp);
				System.out.println(updateTemp);
				String updateTemp1 ="DELETE FROM Customer WHERE id = "+IDTF.getText()+";"; 
				stmt1.executeUpdate(updateTemp1);
				System.out.println(updateTemp1);
			}
			catch (SQLException sqle)
			{
				System.err.println("Error with delete:\n"+sqle.toString());
			}
			finally
			{
				TableModel.refreshFromDB(stmt);
				TableModel1.refreshFromDB1(stmt1);
			}
		}
		if (target == updateButton)
		{	 	
			try
			{ 			
				String updateTemp ="UPDATE details SET " +
				"firstName = '"+FirstNameTF.getText()+
				"', lastName = '"+LastNameTF.getText()+
				"', age = "+AgeTF.getText()+
				", gender ='"+GenderBox.getSelectedItem()+
				"', roomType = '"+RoomBox.getSelectedItem()+
				"', roomPrice = "+PriceTF.getText()+
				", daysBooked = "+DaysBookedBox.getSelectedItem()+
				", checkIn = '"+CheckInBox.getSelectedItem()+
				"' where id = "+IDTF.getText();
				
				
				String updateTemp1 ="UPDATE Customer SET("+
						null +","+CustomerIDTF.getText()+",'"+PaidByBox.getSelectedItem()+ "');";


				stmt.executeUpdate(updateTemp);
				stmt1.executeUpdate(updateTemp1);
				//these lines do nothing but the table updates when we access the db.
				rs = stmt.executeQuery("SELECT * from details ");
				rs.next();
				rs.close();	
			}
			catch (SQLException sqle){
				System.err.println("Error with  update:\n"+sqle.toString());
			}
			finally{
				TableModel.refreshFromDB(stmt);
				TableModel1.refreshFromDB1(stmt1);
			}
			
		}
		if(target == this.checkedIn){///Change check In status
			
			
			try{				
				String id= IDTF.getText();
				String room = this.checkInTF.getText();

				String updateTemp = "call update_checkIn("+id+","+"'"+room+"');";
				
				stmt.executeUpdate(updateTemp);
				
				//these lines do nothing but the table updates when we access the db.
				rs = stmt.executeQuery("SELECT * from details ");
				rs.next();
				rs.close();	
				rs= stmt.executeQuery(cmd); 	
				writeToFile(rs);
			}
			catch(SQLException sqle){System.err.println("Error with  update:\n"+sqle.toString());}
			finally{
				TableModel.refreshFromDB(stmt);
				
			}

		}
		
		
		
		
		if (target == exportButton) {

			cmd = "select * from details;";

			try {
				rs = stmt.executeQuery(cmd);
				writeToFile(rs);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		if(target == this.TPrice){
			

			cmd = "select sum(roomPrice*daysBooked) as 'Total price for all customers' "+  "from details " ;

			System.out.println(cmd);
			try{					
				rs= stmt.executeQuery(cmd); 	
				writeToFile(rs);
				System.out.println(rs);
			}
			catch(Exception e1){e1.printStackTrace();}

		} 
		
		
			
			if(target == this.searchCustomerByRoom){//Search customers who booked a room type
				String text=  checkInTF.getText();

				cmd = "select sum(roomPrice*daysBooked) as 'Price for customer ' from details where firstName='"+ text+"';" ;

				System.out.println(cmd);
				try{					
					rs= stmt.executeQuery(cmd); 	
					writeToFile(rs);
					System.out.println(rs);
				}
				catch(Exception e1){e1.printStackTrace();}
			

		} 
		if(target == this.searchCustomer){//Search for a customer
			String custName = this.searchCustomerTF.getText();
 
			
			//cmd = "select department, round(avg(age)) as 'Average age' "+  "from details " + "where department =  '" +custName+"' ";
			cmd = "select Customer.id,details.firstName, details.lastName, details.roomType,details.checkIn, details.roomType,(details.daysBooked*details.roomPrice) as 'TP',Customer.paidBy "+ " from details "+" inner join Customer "+" on details.id=customer.id "+" where firstName = '"+custName+"';"; 
			System.out.println(cmd);
			try{					
				rs= stmt.executeQuery(cmd); 	
				writeToFile(rs);
			}
			catch(Exception e1){e1.printStackTrace();}

		} 
		
		if(target == this.TPriceCustomer){///Price of a customer
			String custName = this.TPriceCustomerTF.getText();

			
			//cmd = "select department, round(avg(age)) as 'Average age' "+  "from details " + "where department =  '" +custName+"' ";
			cmd = "select calculate_TotalPrice('"+custName+"');";
			System.out.println(cmd);
			try{					
				rs= stmt.executeQuery(cmd); 	
				writeToFile(rs);
			}
			catch(Exception e1){e1.printStackTrace();}

		}
		
		if(target == this.searchCustomerByRoom){
			String room = this.searchCustomerByRoomTF.getText();

			
			//cmd = "select department, round(avg(age)) as 'Average age' "+  "from details " + "where department =  '" +custName+"' ";
			cmd = "select roomType, firstName, lastName from details where roomType='"+room+"';";
			System.out.println(cmd);
			try{					
				rs= stmt.executeQuery(cmd); 	
				writeToFile(rs);
			}
			catch(Exception e1){e1.printStackTrace();}

		}
		if(target == this.countCheck){///Count the amount of customers checked in
			

			
			//cmd = "select department, round(avg(age)) as 'Average age' "+  "from details " + "where department =  '" +custName+"' ";
			cmd = "select checkIn,count(*) from details group by checkIn;";
			System.out.println(cmd);
			try{					
				rs= stmt.executeQuery(cmd); 	 
				writeToFile(rs);
			}
			catch(Exception e1){e1.printStackTrace();}

		}
		
		if(target == this.sortByGender){///Count the amount of customers checked in
			

			
			//cmd = "select department, round(avg(age)) as 'Average age' "+  "from details " + "where department =  '" +custName+"' ";
			cmd = "SELECT gender, count(*) FROM details GROUP BY gender;";
			System.out.println(cmd);
			try{					
				rs= stmt.executeQuery(cmd); 	
				writeToFile(rs);
			}
			catch(Exception e1){e1.printStackTrace();}

		}

	}
	///////////////////////////////////////////////////////////////////////////

	private void writeToFile(ResultSet rs){
		try{
			System.out.println("In writeToFile");
			FileWriter outputFile = new FileWriter("Sheila.csv");
			PrintWriter printWriter = new PrintWriter(outputFile);
			ResultSetMetaData rsmd = rs.getMetaData();
			int numColumns = rsmd.getColumnCount();

			for(int i=0;i<numColumns;i++){
				printWriter.print(rsmd.getColumnLabel(i+1)+",");
			}
			printWriter.print("\n");
			while(rs.next()){
				for(int i=0;i<numColumns;i++){
					printWriter.print(rs.getString(i+1)+",");
				}
				printWriter.print("\n");
				printWriter.flush();
			}
			printWriter.close();
		}
		catch(Exception e){e.printStackTrace();}
	}
}
