package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.BanHangbean;
import bean.Hangbean;
import bo.BanHangbo;
import bo.Hangbo;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.Font;

public class frmQLBHview extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaHang;
	private JTextField txtTenHang;
	private JTextField txtNgayNhapHang;
	private JTextField txtSoLuong;
	private JTextField txtGia;
	public Hangbo hbo = new Hangbo();
	public BanHangbo bhbo = new BanHangbo();
	public frmLogin login = new frmLogin();
	public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	ArrayList<Hangbean> ds = new ArrayList<Hangbean>();
	public static ArrayList<BanHangbean> dsBH = new ArrayList<BanHangbean>();
	private JTable TonKho;
	private JTable HoaDon;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmQLBHview frame = new frmQLBHview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the function.
	 */
	
	public void updateTable(ArrayList<Hangbean> ls) throws Exception
	{
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Ma hang");
		dtm.addColumn("Ten hang");
		dtm.addColumn("Ngay nhap hang");
		dtm.addColumn("So luong");
		dtm.addColumn("Gia");
		
		for (Hangbean h : ls)
		{
			String[] sp = h.toString().split("[;]");
			dtm.addRow(sp);
		}
		
		TonKho.setModel(dtm);
	}
	
	public void updateTable2(ArrayList<BanHangbean> ls) throws Exception
	{
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Ma hang");
		dtm.addColumn("Ten hang");
		dtm.addColumn("Ngay mua hang");
		dtm.addColumn("So luong mua");
		dtm.addColumn("Gia");
		
		for (BanHangbean h : ls)
		{
			String[] sp = h.toString().split("[;]");
			dtm.addRow(sp);
		}
		
		HoaDon.setModel(dtm);
	}
	
	public void get(JTable table) {
		int id = table.getSelectedRow(); // lay dong vua chon
		String maHang = table.getValueAt(id, 0).toString();
		String tenHang = table.getValueAt(id, 1).toString();
		String ngayNhapHang = table.getValueAt(id, 2).toString();
		String soLuong = table.getValueAt(id, 3).toString();
		String gia = table.getValueAt(id, 4).toString();
		txtMaHang.setText(maHang.trim());
		txtTenHang.setText(tenHang);
		txtNgayNhapHang.setText(ngayNhapHang);
		txtSoLuong.setText(soLuong);
		txtGia.setText(gia);
	}
	
	public void insert()
	{
		try {
			String maHang = txtMaHang.getText();
			String tenHang = txtTenHang.getText();
			Date ngayNhapHang = sdf.parse(txtNgayNhapHang.getText());
			Integer soLuong = Integer.parseInt(txtSoLuong.getText());
			Double gia = Double.parseDouble(txtGia.getText());

			int kq = hbo.insert(maHang, tenHang, ngayNhapHang, soLuong, gia);
			
			if (kq == 0)
				JOptionPane.showMessageDialog(null, "Ma hang " + maHang + " da ton tai");
			else if (kq == 1)
				JOptionPane.showMessageDialog(null, "Them ma hang " + maHang + " thanh cong");
			else
				JOptionPane.showMessageDialog(null, "Them ma hang " + maHang + " that bai");
			ds.add(new Hangbean(maHang, tenHang, ngayNhapHang, soLuong, gia));
			updateTable(ds);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public void delete()
	{
		try {
			if (JOptionPane.showConfirmDialog(null, "Xac nhan xoa hang") == 0)
			{
				int kq= hbo.delete(txtMaHang.getText());
				if (kq == 1)
				{
					JOptionPane.showMessageDialog(null, "Xoa ma hang " + txtMaHang.getText() + " thanh cong");
				}
				else
					JOptionPane.showMessageDialog(null, "Xoa ma hang " + txtMaHang.getText() + " that bai");
			}
		} catch (Exception e1) {
				e1.printStackTrace();
		}
	}
	
	public void update()
	{
		try {
			String maHang = txtMaHang.getText();
			String tenHang = txtTenHang.getText();
			Date ngayNhapHang = sdf.parse(txtNgayNhapHang.getText());
			Integer soLuong = Integer.parseInt(txtSoLuong.getText());
			Double gia = Double.parseDouble(txtGia.getText());
			
			if (hbo.update(maHang, tenHang, ngayNhapHang, soLuong, gia) == 1)
			{
				for (Hangbean h : ds)
				{
					if (h.getMaHang().trim().equals(maHang.trim())){
						h.setTenhang(tenHang);
						h.setNgayNhapHang(ngayNhapHang);
						h.setSoLuong(soLuong);
						h.setGia(gia);
					}
				}
				JOptionPane.showMessageDialog(null, "Cap nhat " + maHang + " thanh cong");
			}
			else
				JOptionPane.showMessageDialog(null, "Cap nhat " + maHang + " that bai");
			updateTable(ds);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public void find()
	{
		try {
			ArrayList<Hangbean> ls = new ArrayList<Hangbean>();
			String tenHang = JOptionPane.showInputDialog("Nhap ten hang can tim");
			for (Hangbean h : ds)
			{
				if (h.getTenhang().trim().toLowerCase().contains(tenHang.trim().toLowerCase())) {
					ls.add(h);
				}
			}
			updateTable(ls);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void load()
	{
		try {
			updateTable(hbo.getHang());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public Boolean checkSoLuong(String maHang, Integer soluongmua)
	{
		for (Hangbean h : ds)
		{
			if (h.getMaHang().trim().equals(maHang.trim()))
				if (h.getSoLuong() < soluongmua)
					return false;
				else
					h.setSoLuong(h.getSoLuong() - soluongmua);
		}
		return true;
	}
	
	public void Add() throws Exception
	{
		try {
			String maHang = txtMaHang.getText().trim();
			String tenHang = txtTenHang.getText();
			Date ngayMua = new Date();			
			if (maHang.trim().equals("") || maHang.trim() == null)
			{
				JOptionPane.showMessageDialog(null, "Vui long chon 1 hang ban muon them vao danh sach hoa don");
				return;
			}
			
			Integer soluongmua = Integer.parseInt(JOptionPane.showInputDialog("Nhap so luong mua"));
			Double gia = Double.parseDouble(txtGia.getText());
			
			BanHangbean bh = new BanHangbean(maHang, tenHang, ngayMua, soluongmua, gia);
			Boolean ADD = false;
			for (BanHangbean b : dsBH) {
				if (b.getMaHang().trim().equals(maHang))
				{
					if (checkSoLuong(maHang, soluongmua) == true)
					{
						b.setSoLuongMua(soluongmua + b.getSoLuongMua());
						bhbo.add(bh);
					}
					else
						JOptionPane.showMessageDialog(null, "Trong kho khong du de ban");
					ADD = true;
				}
			}
			if (ADD == false)
				if (checkSoLuong(maHang, soluongmua) == false)
					JOptionPane.showMessageDialog(null, "Trong kho khong du de ban");
				else
				{
					dsBH.add(bh);
					bhbo.add(bh);
				}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		updateTable(ds);
		updateTable2(dsBH);
	}
	
	public void Buy() throws Exception
	{
		int confirm = JOptionPane.showConfirmDialog(null, "Xac nhan hoa don?");
		if (confirm == 0)
		{
			try {
				for(BanHangbean bh : dsBH)
				{
					bhbo.insert(bh.getMaHang(), bh.getTenhang(), bh.getNgayMua(), bh.getSoLuongMua(), bh.getGia());
				}
				dsBH.clear();
				JOptionPane.showMessageDialog(null, "Luu hoa don thanh cong");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		ArrayList<BanHangbean> temp = new ArrayList<BanHangbean>();
		updateTable2(temp);
	}
	/**
	 * Create the frame.
	 */
	public frmQLBHview() {
		setFont(new Font("CaskaydiaCove NFP", Font.PLAIN, 14));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					for (Hangbean h : hbo.getHang()) 
						ds.add(h);
					updateTable(ds);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		setTitle(frmLogin.Fullname);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 994, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 127, 457, 238);
		contentPane.add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(477, 127, 493, 238);
		contentPane.add(tabbedPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh sach hang ton kho", null, scrollPane, null);
		
		JLabel lblNewLabel = new JLabel("Ma hang");
		lblNewLabel.setBounds(10, 28, 78, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ten hang");
		lblNewLabel_1.setBounds(10, 51, 78, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ngay nhap hang");
		lblNewLabel_1_1.setBounds(10, 74, 78, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("So luong");
		lblNewLabel_2.setBounds(243, 28, 59, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gia");
		lblNewLabel_3.setBounds(243, 51, 59, 13);
		contentPane.add(lblNewLabel_3);
		
		txtMaHang = new JTextField();
		txtMaHang.setBounds(98, 25, 135, 19);
		contentPane.add(txtMaHang);
		txtMaHang.setColumns(10);
		
		txtTenHang = new JTextField();
		txtTenHang.setColumns(10);
		txtTenHang.setBounds(98, 48, 135, 19);
		contentPane.add(txtTenHang);
		
		txtNgayNhapHang = new JTextField();
		txtNgayNhapHang.setColumns(10);
		txtNgayNhapHang.setBounds(98, 71, 135, 19);
		contentPane.add(txtNgayNhapHang);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(312, 25, 135, 19);
		contentPane.add(txtSoLuong);
		
		txtGia = new JTextField();
		txtGia.setColumns(10);
		txtGia.setBounds(312, 48, 135, 19);
		contentPane.add(txtGia);

		TonKho = new JTable();
		TonKho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				get(TonKho);
			}
		});
		scrollPane.setViewportView(TonKho);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane_1.addTab("Hoa Don", null, scrollPane_1, null);
		
		HoaDon = new JTable();
		HoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				get(HoaDon);
			}
		});
		scrollPane_1.setViewportView(HoaDon);
		
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnNewButton.setBounds(243, 70, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnInsert = new JButton("Delete");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnInsert.setBounds(338, 70, 85, 21);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnUpdate.setBounds(433, 70, 85, 21);
		contentPane.add(btnUpdate);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				find();
			}
		});
		btnFind.setBounds(528, 70, 85, 21);
		contentPane.add(btnFind);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load();
			}
		});
		btnLoad.setBounds(457, 28, 90, 40);
		contentPane.add(btnLoad);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					Add();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Buy();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(477, 96, 85, 21);
		contentPane.add(btnNewButton_1);
		
		btnBuy.setBounds(577, 96, 85, 21);
		contentPane.add(btnBuy);
	}
}
