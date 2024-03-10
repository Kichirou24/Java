package LTGD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ibm.icu.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class frmBanHang extends JFrame {
	/**
	 * Init
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtGia;
	private JTextField txtSoLuong;
	private JTextField txtThanhTien;
	JComboBox cmbHang = new JComboBox();
	ArrayList<String> ds = new ArrayList<String>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmBanHang frame = new frmBanHang();
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
	public frmBanHang() {
		setTitle("Bán hàng");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					FileReader f = new FileReader("hang.txt");
					BufferedReader r = new BufferedReader(f);
					while (true)
					{
						String st = r.readLine();
						if (st == null || st == "") break;
						System.out.println(st);
						// dua du lieu vao ds
						ds.add(st);
						String[] d = st.split("[;]");
						// dua du lieu vao cmbHang
						cmbHang.addItem(d[1]);
					}
					r.close();
				} catch(Exception tt)
				{
					tt.printStackTrace();
				}
			}		
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chọn hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(33, 30, 114, 20);
		contentPane.add(lblNewLabel);
		cmbHang.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 27)
				{
					System.exit(1);
				}
			}
		});
		cmbHang.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String th = cmbHang.getSelectedItem().toString();
				for(String h : ds) // h1;Xang;20000
				{
					String[] t = h.split("[;]");
					if (t[1].equals(th))
					{
						txtGia.setText(t[2]);
					}
				}
			}
		});
		
		cmbHang.setBounds(157, 28, 114, 22);
		contentPane.add(cmbHang);
		
		JLabel lblNewLabel_1 = new JLabel("Giá");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(33, 68, 114, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nhập số lượng");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(33, 101, 114, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Thành tiền");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setBounds(33, 165, 114, 19);
		contentPane.add(lblNewLabel_3);
		
		txtGia = new JTextField();
		txtGia.setBounds(157, 67, 114, 20);
		contentPane.add(txtGia);
		txtGia.setColumns(10);
		
		txtSoLuong = new JTextField();
		txtSoLuong.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 27)
				{
					System.exit(1);
				}
			}
		});
		txtSoLuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer soLuong = Integer.parseInt(txtSoLuong.getText());
				Integer thanhTien = soLuong * Integer.parseInt(txtGia.getText());
				txtThanhTien.setText(thanhTien.toString());
			}
		});
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(157, 105, 114, 20);
		contentPane.add(txtSoLuong);
		
		txtThanhTien = new JTextField();
		txtThanhTien.setColumns(10);
		txtThanhTien.setBounds(157, 160, 128, 36);
		contentPane.add(txtThanhTien);
		
		JButton btnNewButton = new JButton("Ban");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter f = new FileWriter("luuhang.txt", true); // mo file ra de ghi 
					PrintWriter w = new PrintWriter(f);
					String th = cmbHang.getSelectedItem().toString(); // lay ten hang
					String gia = txtGia.getText(); // lay gia
					String sl = txtSoLuong.getText(); // lay so luong
					String tt = txtThanhTien.getText(); // lay thanh tien
					
					Date d = new Date(); // Lay ngay gio hien tai
					SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
					String ngay = date.format(d); // doi ngay tu Date sang String
					String st = th + ";" + gia + ";" + sl + ";" + tt + ";" + ngay;
					
					// Luu 1 hang vao file
					w.println(st);
					w.close();
					JOptionPane.showMessageDialog(null, "Da ban " + th + "\nSo luong " + sl);
				}
				catch (Exception tt)
				{
					tt.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(100, 207, 114, 36);
		contentPane.add(btnNewButton);
	}
}