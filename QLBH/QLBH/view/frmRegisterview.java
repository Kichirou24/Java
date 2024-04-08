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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class frmRegisterview extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtFullname;
	public static String Fullname = "";
	private JPasswordField txtPassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegisterview frame = new frmRegisterview();
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
	public frmRegisterview() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 309, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
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
					{
						JOptionPane.showMessageDialog(null, "Register successfully");
						setVisible(false);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRegister.setBounds(111, 185, 91, 35);
		contentPane.add(btnRegister);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(111, 74, 156, 19);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setBounds(22, 77, 69, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("fullname");
		lblNewLabel_1.setBounds(22, 118, 69, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setBounds(22, 159, 69, 13);
		contentPane.add(lblNewLabel_2);
		
		txtFullname = new JTextField();
		txtFullname.setColumns(10);
		txtFullname.setBounds(111, 115, 156, 19);
		contentPane.add(txtFullname);
		
		JLabel lblNewLabel_3 = new JLabel("REGISTER");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(99, 24, 103, 26);
		contentPane.add(lblNewLabel_3);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(111, 156, 156, 19);
		contentPane.add(txtPassword);
	}
}
