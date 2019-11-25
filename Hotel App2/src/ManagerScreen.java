import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.border.*;

import java.util.Set;
import java.util.Hashtable;
import java.util.*;

public class ManagerScreen extends JFrame implements ActionListener {
	private JButton exit = new JButton("EXIT");

	private HashTable hash = new HashTable();

	public ManagerScreen(String s) {
		super();
		JPanel mainCustomerPanel = new JPanel();
		JButton setDetails = new JButton("Book my room");

		mainScreen main = mainScreen.getInstance();
		CustomerScreen cust = new CustomerScreen("");

		// JLabel l0 = new JLabel(" Welcome Admin");

		Container content = getContentPane();
		content.setLayout(new BorderLayout());
		content.setBackground(Color.DARK_GRAY);
		Font f = new Font("TimesRoman", Font.BOLD, 20);
		// l0.setFont(f);
		setSize(725, 550);
		setVisible(true);

		Border lineBorder = BorderFactory.createEtchedBorder(15, Color.red, Color.black);
		JButton search = new JButton("SEARCH");

		JPanel IDPanel = new JPanel();

		JLabel IDLabel = new JLabel("ID");
		JTextField ID = new JTextField(10);
		JRadioButton get = new JRadioButton("Get details");
		ButtonGroup group = new ButtonGroup();
		group.add(get);

		IDPanel.add(IDLabel);
		IDPanel.add(ID);
		IDPanel.add(get);

		/////////// Center Panel1
		JPanel HashPanel = new JPanel();
		HashPanel.setLayout(new BorderLayout());
		JPanel HashPanel1 = new JPanel();

		JPanel hashPanel = new JPanel();
		hashPanel.setLayout(new FlowLayout());
		JLabel hashLabel = new JLabel("HASH TABLE");
		hashPanel.add(hashLabel);
		HashPanel.setBorder(lineBorder);

		HashPanel1.setLayout(new GridLayout(4, 2));

		JLabel name = new JLabel("Name");
		JTextField nameTF = new JTextField(10);

		JLabel age = new JLabel("Age");
		JTextField ageTF = new JTextField(10);

		JLabel roomType = new JLabel("Room type");
		JTextField roomTypeTF = new JTextField(10);

		JLabel price = new JLabel("Price");
		JTextField priceTF = new JTextField(10);

		HashPanel1.add(name);
		HashPanel1.add(nameTF);
		HashPanel1.add(age);
		HashPanel1.add(ageTF);
		HashPanel1.add(roomType);
		HashPanel1.add(roomTypeTF);
		HashPanel1.add(price);
		HashPanel1.add(priceTF);

		HashPanel.add(hashPanel, BorderLayout.SOUTH);
		HashPanel.add(HashPanel1, BorderLayout.NORTH);

		//////////// Center Panel2
		JPanel BsTreePanel = new JPanel();

		JPanel BsTreePanel1 = new JPanel();

		JPanel bsPanel = new JPanel();
		// bsPanel.setLayout(new GridLayout(5,2));
		JLabel bsLabel = new JLabel("BSTREE TABLE");
		bsPanel.add(bsLabel);
		BsTreePanel.setLayout(new BorderLayout());
		BsTreePanel1.setLayout(new GridLayout(4, 2));

		JLabel name1 = new JLabel("Name");
		JTextField nameTF1 = new JTextField(10);

		JLabel age1 = new JLabel("Age");
		JTextField ageTF1 = new JTextField(10);

		JLabel roomType1 = new JLabel("Room type");
		JTextField roomTypeTF1 = new JTextField(10);

		JLabel price1 = new JLabel("Price");
		JTextField priceTF1 = new JTextField(10);

		BsTreePanel.setBorder(lineBorder);

		BsTreePanel1.add(name1);
		BsTreePanel1.add(nameTF1);
		BsTreePanel1.add(age1);
		BsTreePanel1.add(ageTF1);
		BsTreePanel1.add(roomType1);
		BsTreePanel1.add(roomTypeTF1);
		BsTreePanel1.add(price1);
		BsTreePanel1.add(priceTF1);

		BsTreePanel.add(bsPanel, BorderLayout.SOUTH);
		BsTreePanel.add(BsTreePanel1, BorderLayout.NORTH);

		//////////// Center Panel3
		JTextArea area = new JTextArea(200, 29);
		JScrollPane scroll = new JScrollPane(area);

		/////// Center
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1, 3));

		center.add(HashPanel);
		center.add(BsTreePanel);
		center.add(scroll);

		/////////// Bottom Panel

		JButton insert = new JButton("Insert");

		JButton searchID = new JButton("SEARCH BY ID");

		JButton deleteAll = new JButton("DELETE ALL");

		JButton searchAge = new JButton("SEARCH BY AGE");
		JButton delete = new JButton("DELETE");

		JButton print = new JButton("PRINT");

		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(3, 2));
		bottomPanel.add(insert);
		bottomPanel.add(searchID);
		//bottomPanel.add(deleteAll);
		bottomPanel.add(searchAge);
		bottomPanel.add(delete);
		bottomPanel.add(print);
		bottomPanel.add(exit);

		/////// Content panel
		content.add(IDPanel, BorderLayout.NORTH);
		content.add(center, BorderLayout.CENTER);
		content.add(bottomPanel, BorderLayout.SOUTH);

		/////////////////// BS Tree
		BSTree bs = new BSTree();

		///////////////////// Hash table

		ActionListener one = new ActionListener() {//// Gets customers data
			public void actionPerformed(ActionEvent e) {

				// int id= main.returnId();
				ID.setText(String.valueOf(main.returnId()));
				nameTF.setText(cust.returnName());
				ageTF.setText(String.valueOf(main.returnAge()));
				roomTypeTF.setText(cust.returnRoom());
				priceTF.setText(String.valueOf(cust.returnPrice()));

				nameTF1.setText(cust.returnName());
				ageTF1.setText(String.valueOf(main.returnAge()));
				roomTypeTF1.setText(cust.returnRoom());
				priceTF1.setText(String.valueOf(cust.returnPrice()));

			}
		};
		get.addActionListener(one);

		ActionListener two = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// int id= main.returnId();
				// ID.setText(String.valueOf(main.returnId()));
				// nameTF.setText(cust.returnName());
				// ageTF.setText(String.valueOf(main.returnAge()));
				// roomTypeTF.setText(cust.returnRoom());
				// priceTF.setText(String.valueOf(cust.returnPrice()));

				bs.insert(main.returnId(), nameTF.getText(), main.returnAge(), roomTypeTF.getText(),
						cust.returnPrice());
				hash.insert(main.returnId(), nameTF.getText(), main.returnAge(), roomTypeTF.getText(),
						cust.returnPrice());

			}
		};
		insert.addActionListener(two);

		

		ActionListener three = new ActionListener() {////Searches ID in hash table and bs tree annd prints out the steps 
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(ID.getText());
				Node temp = bs.searchById(id);
				if (temp == null) {
					area.append("Unknown ID\n");
					area.append("\n");
				} else {
					area.append("Search  ID  by BSTree" + bs.readCount() + "steps\n");
					area.append("" + temp.readKey() + "\n");
					area.append("" + temp.readName() + "\n");
					area.append("" + temp.readAge() + "\n");
					area.append("" + temp.readRoom() + "\n");
					area.append("" + temp.readPrice() + "\n");
				}

				Iterator it = hash.iterator();
				HNode temp1 = hash.search(id);
				if (temp1 == null) {
					area.append("Unknown ID BY hashtable\n");
					area.append("\n");
				} else {
					area.append("Search  ID  by Hashtable" + hash.getStep() + "steps\n");
					area.append("" + temp1.readKey() + "\n");
					area.append("" + temp1.readName() + "\n");
					area.append("" + temp1.readAge() + "\n");
					area.append("" + temp1.readRoomType() + "\n");
					area.append("" + temp1.readPrice() + "\n");
				}

				// while(it.hasNext()){
				// HNode temp1= (HNode)it.next();
				// HNode node= temp1;
				// if(id==node.readKey()) {
				//
				// area.append("Search ID by Hashtable"+hash.getStep()+"setps\n");
				// area.append(""+node.readKey()+"\n");
				// area.append(""+node.readName()+"\n");
				// area.append(""+node.readAge()+"\n");
				// area.append(""+node.readRoomType()+"\n");
				// area.append(""+node.readPrice()+"\n");
				//
				// }
				// else {
				// area.append("Invalid ID\n");
				// }
				// }

			}
		};
		searchID.addActionListener(three);

//		ActionListener four = new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				// //Node temp=null;
//				// area.setText("All nodes have been deleted");
//				// bs.deleteAll();
//				//
//
//			}
//		};
//		deleteAll.addActionListener(four);

		ActionListener five = new ActionListener() {///Searches the age of the customer which is used only for the BSTree and prints out the steps
			public void actionPerformed(ActionEvent e) {

				int age = Integer.parseInt(ageTF.getText());
				Node temp = bs.searchByAge(age);
				if (temp == null) {
					area.append("Unknown Age");
					area.append("");
				} else {
					area.append("Search by Age using BS tree took"+bs.readCount()+"steps\n");
					area.append("" + temp.readKey() + "\n");
					area.append("Name:" + temp.readName() + "\n");
					area.append("Age:" + temp.readAge() + "\n");
					area.append("Room Type" + temp.readRoom() + "\n");
					area.append("Total Price:" + temp.readPrice() + "\n");
				}

			}
		};
		searchAge.addActionListener(five);

		ActionListener six = new ActionListener() {/// Deletes a customer using a key from the hastable and BSTree 
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(ID.getText());
				// Node temp=bs.searchByRoom(room);

				area.setText("ID has been deleted in the BSTree and HashTable " + id + "\n");
				bs.delete(id);
				hash.delete(id);

			}
		};
		delete.addActionListener(six);

		ActionListener seven = new ActionListener() {///Uses the iterator pattern to transverse over the hash table
			public void actionPerformed(ActionEvent e) {

				Iterator iter = hash.iterator();
				while (iter.hasNext()) {
					area.append("\n[" + hash.readIndex() + "]:");
					HNode temp = (HNode) iter.next();
					if (temp != null) {
						while (temp != null) {
							HNode res = temp;
							temp = temp.next;
							area.append(res.readKey() + ", " + res.readName() + "," + res.readAge() + ","
									+ res.readRoomType() + "," + res.readPrice() + "-->");
						}
					}
					area.append("null\n");
				}
				hash.setIndex();

			}
		};
		print.addActionListener(seven);

		ActionListener eight = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mainScreen main=mainScreen.getInstance();

			}
		};
		exit.addActionListener(eight);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// if(target)
		//
		// }
	}
}
