package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.Hangbean;
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
	public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	ArrayList<Hangbean> ds = new ArrayList<Hangbean>();
	private JTable table;
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
		
		table.setModel(dtm);
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
					for (Hangbean h : hbo.getHang()) {
						ds.add(h);
					}
					updateTable(ds);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		setTitle("Quan ly ban hang");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 627, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 127, 593, 238);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh sach hang", null, scrollPane, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = table.getSelectedRow(); // lay dong vua chon
				String maHang = table.getValueAt(id, 0).toString();
				String tenHang = table.getValueAt(id, 1).toString();
				String ngayNhapHang = table.getValueAt(id, 2).toString();
				String soLuong = table.getValueAt(id, 3).toString();
				String gia = table.getValueAt(id, 4).toString();
				txtMaHang.setText(maHang);
				txtTenHang.setText(tenHang);
				txtNgayNhapHang.setText(ngayNhapHang);
				txtSoLuong.setText(soLuong);
				txtGia.setText(gia);
			}
		});
		scrollPane.setViewportView(table);
		
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
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		btnNewButton.setBounds(243, 70, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnInsert = new JButton("Delete");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (JOptionPane.showConfirmDialog(null, "May co chac chua ? ") == 0)
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
		});
		btnInsert.setBounds(338, 70, 85, 21);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		btnUpdate.setBounds(433, 70, 85, 21);
		contentPane.add(btnUpdate);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		btnFind.setBounds(528, 70, 85, 21);
		contentPane.add(btnFind);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					updateTable(hbo.getHang());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLoad.setBounds(457, 28, 90, 40);
		contentPane.add(btnLoad);
	}
}
