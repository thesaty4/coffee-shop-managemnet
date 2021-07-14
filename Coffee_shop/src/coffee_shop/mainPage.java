package coffee_shop;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class mainPage extends JFrame implements ActionListener{


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainPage window = new mainPage();
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
	public mainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private JButton login,registration;
	private void initialize() {
		setTitle("Coffee Shop Management");
		setBounds(100, 50, 1211, 651);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
				
		login = new JButton("Login");
		login.setFont(new Font("Tahoma", Font.BOLD, 11));
		login.setBounds(773, 413, 118, 35);
		getContentPane().add(login);
		login.addActionListener(this);
		
		registration = new JButton("Registration");
		registration.setFont(new Font("Tahoma", Font.BOLD, 11));
		registration.setBounds(773, 459, 118, 35);
		getContentPane().add(registration);
		registration.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, -41, 1383, 885);
		lblNewLabel.setIcon(new ImageIcon(mainPage.class.getResource("/coffee_shop/image/theme6.jpg")));
		getContentPane().add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(login)) {
			this.setVisible(false);
			new login().setVisible(true);
		}else if(e.getSource().equals(registration)) {
			this.setVisible(false);
			new Registration().setVisible(true);
		}
		
	}
}
