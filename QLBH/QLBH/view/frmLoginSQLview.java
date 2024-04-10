package view;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.KetNoidao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPasswordField;

public class frmLoginSQLview extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtServerName;
	private JTextField txtDatabaseName;
	private JTextField txtUser;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLoginSQLview frame = new frmLoginSQLview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	void login() throws HeadlessException, Exception
	{
		KetNoidao kn = new KetNoidao();
		KetNoidao.serverName = txtServerName.getText();
		KetNoidao.user = txtUser.getText();
		char[] cp = txtPassword.getPassword();
		KetNoidao.password = "";
		for (char c : cp)
		{
			KetNoidao.password += c;
		}
		if (KetNoidao.serverName.equals("") || KetNoidao.user.equals("") || KetNoidao.password.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Vui long nhap day du thong tin de login");
			return;
		}
		if (kn.KetNoi() == null)
		{
			JOptionPane.showMessageDialog(null, "Wrong");
			return;
		}
		else
		{
			frmLoginview lview = new frmLoginview();
			setVisible(false);
			lview.setVisible(true);
		}
	}

	/**
	 * Create the frame.
	 */
	public frmLoginSQLview() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				txtDatabaseName.setText(KetNoidao.databaseName);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 392, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Server Name");
		lblNewLabel.setBounds(10, 40, 125, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Database Name");
		lblNewLabel_1.setBounds(10, 88, 125, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User");
		lblNewLabel_2.setBounds(10, 136, 125, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(10, 190, 125, 13);
		contentPane.add(lblNewLabel_3);
		
		txtServerName = new JTextField();
		txtServerName.setBounds(145, 37, 179, 19);
		contentPane.add(txtServerName);
		txtServerName.setColumns(10);
		
		txtDatabaseName = new JTextField();
		txtDatabaseName.setColumns(10);
		txtDatabaseName.setBounds(145, 85, 179, 19);
		contentPane.add(txtDatabaseName);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(145, 133, 179, 19);
		contentPane.add(txtUser);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					login();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(130, 235, 85, 21);
		contentPane.add(btnLogin);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(145, 187, 179, 19);
		contentPane.add(txtPassword);
	}
}
