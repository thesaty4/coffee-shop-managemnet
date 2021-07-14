package coffee_shop;

import java.awt.EventQueue;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;

public class Order extends JFrame implements ActionListener{
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order window = new Order();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Order() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JButton[] coffeeBtn;
	private JTextField coffeeName;
	private JTextField Quantity;
	private JTextField Name;
	private JTextField Mobile;
	private JButton Pay,Clr,close;
	private JRadioButton male,female;
	private JTextField Price;
	JLabel cntr;
	public connection conn=new connection();
	private void initialize() {
		setBounds(300, 100, 840, 498);
		setTitle("Order Your coffee");
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Coffee Order");
		lblNewLabel.setBounds(0, 0, 824, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 36, 394, 398);
		getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);				
		try {
			int i=0,j=11;
			Integer counter=0;
			connection conn=new connection();
			String sql="select * from `coffee_info`";
			ResultSet d1=conn.stm.executeQuery(sql);
			while(d1.next()) {
				counter+=1;
			}			
			coffeeBtn=new JButton[counter];
			cntr = new JLabel(counter.toString());
			ResultSet data=conn.stm.executeQuery(sql);
			while(data.next()) {
				coffeeBtn[i] = new JButton(data.getString("coffee_name").toUpperCase());
				coffeeBtn[i].setBounds(40, j, 300, 23);			
				panel.add(coffeeBtn[i]);
				i+=1;
				j+=35;
			}
			
			for(int k=0;k<counter;k++) {
				coffeeBtn[k].addActionListener(this);
			}
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGap(0, 0, Short.MAX_VALUE)
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGap(0, j, Short.MAX_VALUE)
			);
			panel.setLayout(gl_panel);
			
			Panel panel_1 = new Panel();
			panel_1.setLayout(null);
			panel_1.setBounds(451, 50, 340, 384);
			getContentPane().add(panel_1);
			
			JLabel lblCoffeeName = new JLabel("Coffee Name");
			lblCoffeeName.setBounds(10, 194, 82, 14);
			panel_1.add(lblCoffeeName);
			
			coffeeName = new JTextField();
			coffeeName.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					String sql="select * from `coffee_info` where `coffee_name`='"+coffeeName.getText().strip().toLowerCase()+"'";	
					try {
						ResultSet coffeeInfo=conn.stm.executeQuery(sql);
						if(coffeeInfo.next()) {
							ResultSet d2=conn.stm.executeQuery(sql);
							while(d2.next()) {
								String coffeePrice=d2.getString("price");
								String Qntty=Quantity.getText().strip();
								if(!(Qntty.isEmpty() || Qntty.isBlank())) {
									float prc=Float.parseFloat(coffeePrice);
									Integer intQntty=Integer.parseInt(Qntty);
									float tPrice=intQntty*prc;
									String strPrice=Float.toString(tPrice);
									Price.setText(strPrice);
								}else {
									Price.setText("");
								}
							}
						}else {
							Price.setText("");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			coffeeName.setText("");
			coffeeName.setColumns(10);
			coffeeName.setBounds(116, 191, 214, 20);
			panel_1.add(coffeeName);
			
			JLabel lblQntty = new JLabel("Quantity");
			lblQntty.setBounds(10, 242, 82, 14);
			panel_1.add(lblQntty);
			
			Quantity = new JTextField();
			Quantity.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					String sql="select * from `coffee_info` where `coffee_name`='"+coffeeName.getText().strip().toLowerCase()+"'";	
					try {
						ResultSet coffeeInfo=conn.stm.executeQuery(sql);
						if(coffeeInfo.next()) {
							ResultSet d2=conn.stm.executeQuery(sql);
							while(d2.next()) {
								String coffeePrice=d2.getString("price");
								String Qntty=Quantity.getText().strip();
								if(!(Qntty.isEmpty() || Qntty.isBlank())) {
									float prc=Float.parseFloat(coffeePrice);
									Integer intQntty=Integer.parseInt(Qntty);
									float tPrice=intQntty*prc;
									String strPrice=Float.toString(tPrice);
									Price.setText(strPrice);
								}else {
									Price.setText("");
								}
							}
						}else {
							Price.setText("");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			Quantity.setText("");
			Quantity.setColumns(10);
			Quantity.setBounds(116, 239, 214, 20);
			panel_1.add(Quantity);
			
			JLabel customerName = new JLabel("Customer Name");
			customerName.setBounds(10, 70, 96, 14);
			panel_1.add(customerName);
			
			Name = new JTextField();
			Name.setText("");
			Name.setColumns(10);
			Name.setBounds(116, 67, 214, 20);
			panel_1.add(Name);
			
			JLabel lblGender = new JLabel("Gender");
			lblGender.setBounds(10, 108, 96, 14);
			panel_1.add(lblGender);
			
			ButtonGroup bg=new ButtonGroup();
			male = new JRadioButton("Male");
			male.setBounds(116, 104, 66, 23);
			panel_1.add(male);
			
			female = new JRadioButton("Female");
			female.setBounds(204, 104, 109, 23);
			panel_1.add(female);
			bg.add(female);bg.add(male);
			
			Mobile = new JTextField();
			Mobile.setText("");
			Mobile.setColumns(10);
			Mobile.setBounds(116, 146, 214, 20);
			panel_1.add(Mobile);
			
			JLabel lblMobile = new JLabel("Mobile");
			lblMobile.setBounds(10, 149, 96, 14);
			panel_1.add(lblMobile);
			
			Pay = new JButton("Pay");
			Pay.setBounds(10, 324, 89, 23);
			panel_1.add(Pay);
			Pay.addActionListener(this);
			
			Clr = new JButton("Clear");
			Clr.setBounds(128, 324, 89, 23);
			panel_1.add(Clr);
			Clr.addActionListener(this);
			
			close = new JButton("Cancel");
			close.setBounds(241, 324, 89, 23);
			panel_1.add(close);
			
			Price = new JTextField();
			Price.setText("");
			Price.setColumns(10);
			Price.setBounds(116, 282, 214, 20);
			panel_1.add(Price);
			
			JLabel lblPrice = new JLabel("Price");
			lblPrice.setBounds(10, 285, 82, 14);
			panel_1.add(lblPrice);
			close.addActionListener(this);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String counter=cntr.getText();
		Integer intCounter=Integer.parseInt(counter);
		for(int i=0;i<intCounter;i++) {
			if(e.getSource()==coffeeBtn[i]) {
				String cName=coffeeBtn[i].getText().strip().toLowerCase();
				coffeeName.setText(cName);
			}
		}
		
		if(e.getSource()==Pay) {
			String name=Name.getText().strip().toLowerCase();
			String CName=coffeeName.getText().strip().toLowerCase();
			String mbl=Mobile.getText().strip();
			String Qantty=Quantity.getText().strip();
			String price=Price.getText().strip();
			String gender="";
			if(male.isSelected() || female.isSelected()) {
				if(male.isSelected()) {
					gender="male";
				}else if(female.isSelected()) {
					gender="female";
				}
			}
			if(name.isEmpty()||CName.isEmpty()||mbl.isEmpty()||price.isEmpty()||gender.isEmpty()||Qantty.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Opps ! All feild required");
			}else {
				float fltPrice=Float.parseFloat(price);
				connection conn=new connection();
				String sql="insert into `customer_info` (`name`,`gender`,`mobile`,`total_pay`) values ('"+name+"','"+gender+"','"+mbl+"',"+fltPrice+")";
				String sql1="select `customer_id`,`purchase_date` from `customer_info`";
				try {
					conn.stm.executeUpdate(sql);
					ResultSet data=conn.stm.executeQuery(sql1);
					String cInfo="";
					String pDate="";
					while(data.next()) {
						cInfo=data.getString("customer_id");
						pDate=data.getString("purchase_date");
					}
					Integer cId=Integer.parseInt(cInfo);
					Integer QTTY=Integer.parseInt(Qantty);
					String sql3="insert into `bill` (`customer_id`,`coffee_name`,`quantity`) values ("+cId+",'"+CName+"',"+QTTY+")";
					conn.stm.executeUpdate(sql3);
					Name.setText("");
					Mobile.setText("");
					Quantity.setText("");
					Price.setText("");
					coffeeName.setText("");
					int x=JOptionPane.showConfirmDialog(null, "Do you want to get reciept?","Reciept",JOptionPane.YES_NO_CANCEL_OPTION);
					if(x==0) {
						String printData="\t\tThe Coffee Shop\n-------------------------------------------------------------------------------------------\n\n Customer ID : "+cId+"\n Customer Name : "+name+"\n Gender : "+gender+"\n Mobile No. : "+mbl+"\n Coffee Name : "+CName+"\n Quantity : "+Qantty+"\n Paid : "+price+"\n Date : "+pDate;
						JTextArea printD=new JTextArea();
						printD.append(printData);
						try {
							printD.print();
						} catch (PrinterException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Congratulation ! Order successfully");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}else if(e.getSource()==Clr){
			Name.setText("");
			coffeeName.setText("");
			Mobile.setText("");
			Quantity.setText("");
		}else if(e.getSource()==close) {
			this.setVisible(false);
		}
	}
}
