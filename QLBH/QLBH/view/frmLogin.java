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

public class frmLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtPassword;
	private JTextField txtUsername;
	private JTextField txtFullname;
	public static String Fullname = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
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
	public frmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 314, 291);
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
					Fullname = txtFullname.getText();
					char[] pc = txtPassword.getPassword();
					String password = "";
					for (char c : pc)
					{
						password += c;
					}
					if (abo.check(username, password) == true)
					{
						frmQLBHview qlbh = new frmQLBHview();
						qlbh.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Wrong username/password");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(49, 199, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Accountbo abo = new Accountbo();
					String username = txtUsername.getText();
					Fullname = txtFullname.getText();
					char[] pc = txtPassword.getPassword();
					String password = "";
					for (char c : pc)
					{
						password += c;
					}
					Accountbean acc = new Accountbean(username, Fullname, password);
					if (abo.register(acc) == 0)
						JOptionPane.showMessageDialog(null, "Da ton tai user");
					else
						JOptionPane.showMessageDialog(null, "Register successfully");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(171, 199, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN/REGISTER");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(119, 10, 105, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(10, 70, 72, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Fullname");
		lblNewLabel_3.setBounds(10, 115, 72, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(10, 157, 72, 13);
		contentPane.add(lblNewLabel_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(111, 154, 129, 19);
		contentPane.add(txtPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(111, 67, 129, 19);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtFullname = new JTextField();
		txtFullname.setBounds(111, 112, 129, 19);
		contentPane.add(txtFullname);
		txtFullname.setColumns(10);
	}
}
