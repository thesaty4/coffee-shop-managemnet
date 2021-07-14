package coffee_shop;
/** 
 * @author Satya Narayan Mishra
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Canvas;
import javax.swing.JPanel;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NewStock extends JFrame implements ActionListener{

	private JFrame frame;
	private JTextField coffeeName;
	private JTextField Price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewStock window = new NewStock();
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
	public NewStock() {
		getContentPane().setBackground(Color.WHITE);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JButton btnNewButton,btnCancel;
	private void initialize() {
		setBounds(300, 80, 900, 534);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("______________________________________________________________________________________________________________________________________________________________________________");
		label.setBounds(0, 44, 940, 23);
		getContentPane().add(label);
		
		JLabel lblNewLabel_1 = new JLabel("New Coffee Flavor");
		lblNewLabel_1.setForeground(new Color(139, 0, 0));
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 11, 884, 33);
		getContentPane().add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("______________________________________________________________________________________________________________________________________________________________________________");
		label_1.setBounds(0, 36, 940, 14);
		getContentPane().add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(482, 89, 392, 322);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel coffeeLabel = new JLabel("Coffee Name");
		coffeeLabel.setBounds(10, 112, 91, 14);
		panel_1.add(coffeeLabel);
		
		coffeeName = new JTextField();
		coffeeName.setBounds(97, 109, 244, 20);
		panel_1.add(coffeeName);
		coffeeName.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(10, 164, 91, 14);
		panel_1.add(lblPrice);
		
		Price = new JTextField();
		Price.setColumns(10);
		Price.setBounds(97, 161, 244, 20);
		panel_1.add(Price);
		
		btnNewButton = new JButton("Add");
		btnNewButton.setBounds(40, 239, 111, 23);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(255, 0, 0));
		btnCancel.setBounds(205, 239, 111, 23);
		panel_1.add(btnCancel);
		btnCancel.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(40, 89, 481, 322);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NewStock.class.getResource("/coffee_shop/image/theme5.jpg")));
		lblNewLabel.setBounds(10, 11, 425, 307);
		panel.add(lblNewLabel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnCancel)) {
			this.setVisible(false);
		}else {
			String coffee=coffeeName.getText().strip().toLowerCase();
			String tPrice=new String(Price.getText().strip());
			
			if(coffee.isEmpty()||tPrice.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Opps ! all field required..", "Warning", JOptionPane.WARNING_MESSAGE);
			}else {
				float fltTprice=Float.parseFloat(tPrice);
				connection conn=new connection();
				try {
					String sql="insert into `coffee_info` (`coffee_name`,`price`) values ('"+coffee+"',"+fltTprice+")";
					conn.stm.executeUpdate(sql);
					coffeeName.setText("");
					Price.setText("");
					
					JOptionPane.showMessageDialog(null, "New Stock Added successfully....");
				}catch(Exception ex) {

					JOptionPane.showMessageDialog(null, "Opps ! this coffee already available...");
					ex.printStackTrace();
				}
			}
		}
	}
}
