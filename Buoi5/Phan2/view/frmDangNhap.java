package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmDangNhap extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDangNhap frame = new frmDangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static String userName = "";
	
	public void login()
	{
		// lay username
		userName = txtUser.getText();
		// mo bang menu
		frmMenu menu = new frmMenu();
		menu.setVisible(true);
		// tat bang login
		setVisible(false);
	}
	
	/**
	 * Create the frame.
	 */
	public frmDangNhap() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBounds(132, 48, 160, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User name");
		lblNewLabel.setBounds(52, 51, 70, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(52, 91, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		txtPass = new JPasswordField();
		txtPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtPass.setColumns(10);
		txtPass.setBounds(132, 88, 160, 20);
		contentPane.add(txtPass);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// lay username
				userName = txtUser.getText();
				// mo bang menu
				frmMenu menu = new frmMenu();
				menu.setVisible(true);
				// tat bang login
				setVisible(false);
			}
		});
		btnNewButton.setBounds(155, 143, 89, 23);
		contentPane.add(btnNewButton);
	}
}