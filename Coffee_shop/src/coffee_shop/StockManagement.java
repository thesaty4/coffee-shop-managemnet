package coffee_shop;
/** 
 * @author Satya Narayan Mishra
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import com.mysql.cj.protocol.Resultset;

import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.ScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StockManagement extends JFrame implements ActionListener{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockManagement window = new StockManagement();
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
	public StockManagement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private int i=0;
	private JTextField EntryDate;
	private JTextField CoffeeName;
	private JTextField Price;
	private JTable table;
	private JButton btnClose,btnUpdate,btnDelete;
	private void initialize() {
		setBounds(300, 80, 900, 534);
		setResizable(false);
		JLabel header = new JLabel("Coffee Management");
		header.setForeground(new Color(139, 0, 0));
		header.setFont(new Font("Cambria Math", Font.BOLD, 20));
		header.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(header, BorderLayout.NORTH);
						
		connection conn=new connection();
		String sql="select * from `coffee_info`";
		try {
			ResultSet rslt=conn.stm.executeQuery(sql);	
			if(rslt.next()) {
				// If data available
				Panel panel = new Panel();
				getContentPane().add(panel, BorderLayout.CENTER);
				panel.setLayout(null);
				
				Panel panel_1 = new Panel();
				panel_1.setBounds(10, 11, 420, 412);
				panel.add(panel_1);
				panel_1.setLayout(null);
				
				JLabel lblEntryDate = new JLabel("Entry Date");
				lblEntryDate.setBounds(36, 245, 91, 14);
				panel_1.add(lblEntryDate);
				
				EntryDate = new JTextField();
				EntryDate.setText("");
				EntryDate.setColumns(10);
				EntryDate.setBounds(153, 242, 223, 20);
				panel_1.add(EntryDate);
				
				JLabel lblCoffeeName = new JLabel("Coffee Name");
				lblCoffeeName.setBounds(36, 138, 91, 14);
				panel_1.add(lblCoffeeName);
				
				CoffeeName = new JTextField();
				CoffeeName.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						String coffee=CoffeeName.getText().toLowerCase().strip();
						String mySql="select * from `coffee_info` where `coffee_name`='"+coffee+"'";
						try {
							ResultSet result=conn.stm.executeQuery(mySql);
							if(result.next()) {
								Price.setText(result.getString("price"));
								EntryDate.setText(result.getString("cur_date"));
							}else {
								Price.setText("");
								EntryDate.setText("");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				
				CoffeeName.setText("");
				CoffeeName.setColumns(10);
				CoffeeName.setBounds(153, 135, 223, 20);
				panel_1.add(CoffeeName);
				
				JLabel lblPrice = new JLabel("Price");
				lblPrice.setBounds(36, 194, 91, 14);
				panel_1.add(lblPrice);
				
				Price = new JTextField();
				Price.setText("");
				Price.setColumns(10);
				Price.setBounds(153, 191, 223, 20);
				panel_1.add(Price);
				
				btnUpdate = new JButton("Update");
				btnUpdate.setBounds(76, 306, 89, 23);
				panel_1.add(btnUpdate);
				btnUpdate.addActionListener(this);
				
				btnDelete = new JButton("Delete");
				btnDelete.setBounds(175, 306, 89, 23);
				panel_1.add(btnDelete);
				btnDelete.addActionListener(this);
				
				btnClose = new JButton("Close");
				btnClose.setBounds(274, 306, 89, 23);
				panel_1.add(btnClose);
				btnClose.addActionListener(this);
				
				Panel panel_2 = new Panel();
				panel_2.setBounds(436, 11, 423, 412);
				panel.add(panel_2);
				panel_2.setLayout(null);
				
				
				String query="select * from `coffee_info`";
				ResultSet data1=conn.stm.executeQuery(query);
				Integer counter=0,i=0,j=0,m=1;
				while(data1.next()) {
					counter+=1;
				}
				String x[]= {"S.N","Coffee Name","Price","Entry Date"};
				String y[][]=new String[counter][5];
				Resultset data=(Resultset) conn.stm.executeQuery(query);
				while(((ResultSet) data).next()) {
					y[i][j++]=m.toString();
					y[i][j++]=((ResultSet) data).getString("coffee_name");
					y[i][j++]=((ResultSet) data).getString("price");
					y[i][j++]=((ResultSet) data).getString("cur_date");
					i++;
					j=0;
					m+=1;
				}
				table = new JTable(y,x);
				table.setBounds(10, 11, 403, 18);
				JScrollPane titleSP=new JScrollPane(table);
				panel_2.add(titleSP);
				titleSP.setBounds(10, 11, 403, 390);	
								
			}else {
				JLabel lblNewLabel = new JLabel("Opps ! There are no any record found...");
				lblNewLabel.setForeground(new Color(255, 0, 0));
				lblNewLabel.setBackground(new Color(255, 0, 0));
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				getContentPane().add(lblNewLabel, BorderLayout.CENTER);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnClose)) {
			this.setVisible(false);
		}else {
			String coffee=CoffeeName.getText().strip();
			String str_price=Price.getText().strip();
			
			
			if(coffee.isEmpty() || str_price.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Opps ! all field required..", "Warning", JOptionPane.WARNING_MESSAGE);
			}else {
				float fltPrice=Float.parseFloat(str_price);
				connection conn=new connection();
				if(e.getSource().equals(btnUpdate)) {
					String sql="update `coffee_info` set `price`="+fltPrice+" where `coffee_name`='"+coffee+"'";
					try {
						conn.stm.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Record Updated successfull...", "Success", JOptionPane.WARNING_MESSAGE);
						this.hide();
						new StockManagement().setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
				}else if(e.getSource().equals(btnDelete)) {
					int val=JOptionPane.showConfirmDialog(null, "After clicking you lose all record from database \n Do you want to delete this record?", "Conformation", JOptionPane.YES_NO_OPTION);					
					if(val==0) {
						// clicked on yes button
						String sql1="delete from `coffee_info` where `coffee_name`='"+coffee+"'";
						String sql2="delete from `coffee_info` where `coffee_name`='"+coffee+"'";
						try {
							conn.stm.executeUpdate(sql1);
							conn.stm.executeUpdate(sql2);
							JOptionPane.showMessageDialog(null, "Record Deleted successfull");
							this.hide();
							new StockManagement().setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						// clicked on no button
					}					
				}
			}
		}
	}
}
