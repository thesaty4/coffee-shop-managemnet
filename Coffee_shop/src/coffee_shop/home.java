package coffee_shop;
/** 
 * @author Satya Narayan Mishra
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JButton;
public class home extends JFrame implements ActionListener{

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new home().setVisible(true);
	}

	/**
	 * Initialize the contents of the frame. and run application
	 */
	
	// globle variable decleartion
	JMenuItem list1,list2,ex,usrl2,usrl3;
	private JButton btnOrder;
	 home() {
		 setTitle("Coffee Shop Management");
		 setBounds(200,100,878,551);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setResizable(false);
		 getContentPane().setLayout(null);
		 
		 btnOrder = new JButton("Order Now");
		 btnOrder.setBounds(137, 311, 238, 32);
		 getContentPane().add(btnOrder);
		 btnOrder.addActionListener(this);
		 
		 
		 JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setIcon(new ImageIcon(home.class.getResource("/coffee_shop/image/theme3.jpg")));
		 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		 lblNewLabel.setBounds(-16, 0, 910, 494);
		 getContentPane().add(lblNewLabel);
		 
		 Font f=new Font("monospaced",Font.PLAIN,16);
		 	JMenuBar mb=new JMenuBar();
			JMenu shopManage=new JMenu("Shop Management");
			list1=new JMenuItem("New Stock");
			list2=new JMenuItem("Stock Management");
			shopManage.setFont(f);
			shopManage.add(list1);
			shopManage.add(list2);
			list1.setBackground(Color.WHITE);
			list2.setBackground(Color.WHITE);
			list1.addActionListener(this);
			list2.addActionListener(this);
			
			//second column
			JMenu user=new JMenu("Customer Management");
			usrl2=new JMenuItem("User Details");
			usrl3=new JMenuItem("Customer Details");
			usrl2.setBackground(Color.WHITE);
			usrl3.setBackground(Color.WHITE);
			user.add(usrl2);
			user.add(usrl3);
			usrl2.addActionListener(this);
			usrl3.addActionListener(this);			
			
			JMenu exit=new JMenu("Exit");
			ex=new JMenuItem("Exit");
			ex.setFont(f);
			ex.setBackground(Color.WHITE);
			exit.add(ex);
			ex.addActionListener(this);
					
			mb.add(shopManage);
			mb.add(user);
			mb.add(exit);
			setJMenuBar(mb);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnOrder) {
			new Order().setVisible(true);
		}else if(e.getSource()==list1) {
			//if new stock button clicked
			new NewStock().setVisible(true);
			
		}else if(e.getSource()==list2) {
			//else if stock managment clicked
			new StockManagement().setVisible(true);
			
		}else if(e.getSource()==usrl2) {
//			if user details clicked
			new UserDetails().setVisible(true);
			
		}else if(e.getSource()==usrl3) {
			// customer Details
			new CustomerDetails().setVisible(true);
			
		}else if(e.getSource()==ex) {
			System.exit(0);
		}
	}
}
