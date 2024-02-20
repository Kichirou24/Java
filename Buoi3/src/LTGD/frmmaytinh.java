package LTGD;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class frmmaytinh extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtKq;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmmaytinh frame = new frmmaytinh();
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
	public frmmaytinh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("A=");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBounds(27, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("B=");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setBounds(27, 45, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Kq=");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setBounds(27, 73, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtA = new JTextField();
		txtA.setBounds(50, 8, 120, 20);
		contentPane.add(txtA);
		txtA.setColumns(10);
		
		txtB = new JTextField();
		txtB.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					Double a = Double.parseDouble(txtA.getText()); // txtA.getText() -> lay gia tri cua txtA
					Double b = Double.parseDouble(txtB.getText()); // txtB.getText() -> lay gia tri cua txtB
					Double kq = a + b;
					// Doi Double sang chuyen
					txtKq.setText(kq.toString()); // txtKq.setText() --> in gia tri cua txtKq
				}
				if (e.getKeyCode() == 27)
				{
					System.exit(1);
				}
			}
		});
		txtB.setBounds(50, 42, 120, 20);
		contentPane.add(txtB);
		txtB.setColumns(10);
		
		txtKq = new JTextField();
		txtKq.setBounds(50, 70, 120, 20);
		contentPane.add(txtKq);
		txtKq.setColumns(10);
		
		
		// Phep +
		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Doi chuyen sang Double
				Double a = Double.parseDouble(txtA.getText()); // txtA.getText() -> lay gia tri cua txtA
				Double b = Double.parseDouble(txtB.getText()); // txtB.getText() -> lay gia tri cua txtB
				Double kq = a + b;
				// Doi Double sang chuyen
				txtKq.setText(kq.toString()); // txtKq.setText() --> in gia tri cua txtKq
			}
		});
		btnNewButton.setBounds(10, 98, 46, 23);
		contentPane.add(btnNewButton);
		
		// Phep -
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Doi chuyen sang Double
				Double a = Double.parseDouble(txtA.getText());
				Double b = Double.parseDouble(txtB.getText());
				Double kq = a - b;
				// Doi Double sang chuyen
				txtKq.setText(kq.toString());
			}
		});
		btnNewButton_1.setBounds(60, 98, 46, 23);
		contentPane.add(btnNewButton_1);
		
		// Phep *
		JButton btnNewButton_1_1 = new JButton("*");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Doi chuyen sang Double
				Double a = Double.parseDouble(txtA.getText());
				Double b = Double.parseDouble(txtB.getText());
				Double kq = a * b;
				// Doi Double sang chuyen
				txtKq.setText(kq.toString());
			}
		});
		btnNewButton_1_1.setBounds(116, 98, 46, 23);
		contentPane.add(btnNewButton_1_1);
		
		// Phep /
		JButton btnNewButton_1_2 = new JButton("/");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Doi chuyen sang Double
				Double a = Double.parseDouble(txtA.getText());
				Double b = Double.parseDouble(txtB.getText());
				if (b != 0)
				{
					Double kq = a / b;
					// Doi Double sang chuyen
					txtKq.setText(kq.toString());
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Ve lop 1 ma hoc");
				}
				
			}
		});
		btnNewButton_1_2.setBounds(165, 98, 46, 23);
		contentPane.add(btnNewButton_1_2);
	}
}
