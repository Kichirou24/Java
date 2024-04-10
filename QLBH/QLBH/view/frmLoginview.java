package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Accountbean;
import bo.Accountbo;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmLoginview extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtPassword;
	private JTextField txtUsername;
	public static String Fullname;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLoginview frame = new frmLoginview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public frmLoginview() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 314, 268);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Accountbo abo = new Accountbo();
					String username = txtUsername.getText();
					for (Accountbean acc : abo.getAccount())
					{
						if (acc.getUsername().equals(username))
						{
							Fullname = acc.getFullname();
						}
					}
					char[] pc = txtPassword.getPassword();
					String password = "";
					for (char c : pc)
					{
						password += c;
					}
					if (abo.check(username, password) == true)
					{
						frmMainview qlbh = new frmMainview();
						qlbh.setVisible(true);
						setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Wrong username/password");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(45, 163, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegisterview register = new frmRegisterview();
				register.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(155, 163, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN/REGISTER");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(105, 10, 185, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(10, 70, 72, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(10, 109, 72, 13);
		contentPane.add(lblNewLabel_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(111, 106, 129, 19);
		contentPane.add(txtPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(111, 67, 129, 19);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
	}
}
