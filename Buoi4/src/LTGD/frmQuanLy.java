package LTGD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.ibm.icu.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmQuanLy extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaHang;
	private JTextField txtTenHang;
	private JTextField txtGia;
	private JTable table;
	ArrayList<String> ds = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmQuanLy frame = new frmQuanLy();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/** 
	 * Create Function 
	 */
	
	void docFile()
	{
		try {
			FileReader f = new FileReader("hang.txt");
			BufferedReader r = new BufferedReader(f);
			while (true)
			{
				String st = r.readLine();
				if (st == null || st == "") break;
				System.out.println();
				// Them vao mang ds
				ds.add(st);
			}
			r.close();
		} catch(Exception tt)
		{
			tt.printStackTrace();
		}
	}
	
	void ghiFile()
	{
		try {
			FileWriter f = new FileWriter("hang.txt"); // mo file ra de ghi 
			PrintWriter w = new PrintWriter(f);
			
			for(String h : ds)
			{
				w.println(h);
			}
			w.close();
			JOptionPane.showMessageDialog(null, "Da luu file");
		}
		catch (Exception tt)
		{
			tt.printStackTrace();
		}
	}
	
	void napBang(ArrayList<String> ds) {
		// Tao ra mo hinh bang 
		DefaultTableModel mh = new DefaultTableModel();
		// Tao cot
		mh.addColumn("Ma hang");
		mh.addColumn("Ten hang");
		mh.addColumn("Gia");
		// Them hang
		
		for (String h : ds)
		{
			Object[] t = h.split("[;]");
			mh.addRow(t);
		}
		// Dua mo hinh vao bang
		table.setModel(mh);
	}

	/**
	 * Create the frame.
	 */
	public frmQuanLy() {
		setTitle("Quản lý");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				docFile();
				napBang(ds);
			}
			@Override
			public void windowClosing(WindowEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "Luu file khong?");
				if (n == 0)
					ghiFile();
				
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã hàng");
		lblNewLabel.setBounds(70, 45, 70, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("Tên hàng");
		lblNewLabel1.setBounds(70, 85, 70, 14);
		contentPane.add(lblNewLabel1);
		
		JLabel lblNewLabel2 = new JLabel("Giá");
		lblNewLabel2.setBounds(70, 125, 70, 14);
		contentPane.add(lblNewLabel2);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mh = txtMaHang.getText();
				String th = txtTenHang.getText();
				String gia = txtGia.getText();
				boolean add = true;
				if (mh.equals(""))
				{
					add = false;
				}
				String tt = mh + ";" + th + ";" + gia;
				for(String h : ds)
				{
					String[] t = h.split("[;]");
					if (t[0].equals(mh) )
					{
						add = false;
						break;
					}
				}
				if(add == true)
				{
					ds.add(tt);
					napBang(ds);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Khong the them");
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setBounds(70, 170, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mh = JOptionPane.showInputDialog("Nhap ma hang");
				for(String h : ds)
				{
					String[] t = h.split("[;]");
					if (t[0].equals(mh)) {
						int n = JOptionPane.showConfirmDialog(null, "Xoa khong thi bao");
						if (n == 0)
							ds.remove(h);
						break;
					}
				}
				napBang(ds);				
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 255));
		btnNewButton_1.setBounds(203, 170, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("UPDATE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mh = txtMaHang.getText();
				String th = txtTenHang.getText();
				String gia = txtGia.getText();
				String tt = mh + ";" + th + ";" + gia;
				for (String h : ds)
				{
					String[] t = h.split("[;]");
					if (t[0].equals(mh))
					{
						ds.set(ds.indexOf(h), tt); // cap nhat lai gia tri cua arraylist lai vi tri thu i sang tt. // indexOf() lay vi tri cua ds.indexOf(h)
						break;
					}
				}
				napBang(ds);
			}
		});
		btnNewButton_2.setForeground(new Color(0, 0, 255));
		btnNewButton_2.setBounds(347, 170, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("FIND");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> F = new ArrayList<String>();
				String th = txtTenHang.getText();
				
				for(String h : ds)
				{
					String[] t = h.split("[;]");
					if (t[1].contains(th)){
						String tt = t[0] + ";" + t[1] + ";" + t[2];
						F.add(tt);
					}
				}
				napBang(F);
			}
		});
		btnNewButton_3.setForeground(new Color(0, 0, 255));
		btnNewButton_3.setBounds(479, 170, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("SAVE");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ghiFile();
			}
		});
		btnNewButton_4.setForeground(new Color(0, 0, 255));
		btnNewButton_4.setBounds(613, 170, 89, 23);
		contentPane.add(btnNewButton_4);
		
		txtMaHang = new JTextField();
		txtMaHang.setBounds(150, 42, 293, 20);
		contentPane.add(txtMaHang);
		txtMaHang.setColumns(10);
		
		txtTenHang = new JTextField();
		txtTenHang.setBounds(150, 82, 293, 20);
		contentPane.add(txtTenHang);
		txtTenHang.setColumns(10);
		
		txtGia = new JTextField();
		txtGia.setColumns(10);
		contentPane.add(txtGia);
		txtGia.setBounds(150, 122, 293, 20);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(70, 206, 650, 250);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = table.getSelectedRow(); // lay dong vua chon
				String mh = table.getValueAt(id, 0).toString();
				String th = table.getValueAt(id, 1).toString();
				String gia = table.getValueAt(id, 2).toString();
				txtMaHang.setText(mh);
				txtTenHang.setText(th);
				txtGia.setText(gia);
			}
		});
		scrollPane.setViewportView(table);
	}
}
