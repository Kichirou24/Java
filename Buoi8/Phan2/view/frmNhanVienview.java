package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.NhanVienbean;
import bo.NhanVienbo;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frmNhanVienview extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtMaNhanVien;
	private JTextField txtHoTen;
	private JTextField txtGioiTinh;
	private JTextField txtNgaySinh;
	private JTextField txtHSL;
	private JTextField txtEmail;
	private JTextField txtPhone;
	public NhanVienbo nvbo = new NhanVienbo();
	public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmNhanVienview frame = new frmNhanVienview();
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
	
	public void updateTable(ArrayList<NhanVienbean> ds) {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Ma nhan vien");
		dtm.addColumn("Ho ten");
		dtm.addColumn("Gioi tinh");
		dtm.addColumn("Ngay sinh");
		dtm.addColumn("He so luong");
		dtm.addColumn("Email");
		dtm.addColumn("Phone");
		
		for (NhanVienbean nv : ds)
		{
			String[] sp = nv.toString().split("[;]");
			dtm.addRow(sp);
		}
		
		table.setModel(dtm);
	}
	
	public frmNhanVienview() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					updateTable(nvbo.getNV());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 134, 803, 243);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Danh sach nhan vien", null, panel, null);
		
		table = new JTable();
		panel.add(table);
		
		JLabel lblNewLabel = new JLabel("Ma nhan vien");
		lblNewLabel.setBounds(10, 26, 84, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblHoTen = new JLabel("Ho ten");
		lblHoTen.setBounds(245, 29, 84, 13);
		contentPane.add(lblHoTen);
		
		JLabel lblGioiTinh = new JLabel("Gioi tinh");
		lblGioiTinh.setBounds(10, 49, 84, 13);
		contentPane.add(lblGioiTinh);
		
		JLabel lblNgaySinh = new JLabel("Ngay sinh");
		lblNgaySinh.setBounds(245, 52, 84, 13);
		contentPane.add(lblNgaySinh);
		
		JLabel lblHeSoLuong = new JLabel("He so luong");
		lblHeSoLuong.setBounds(10, 72, 84, 13);
		contentPane.add(lblHeSoLuong);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(245, 75, 84, 13);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(10, 95, 84, 13);
		contentPane.add(lblPhone);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setBounds(104, 23, 131, 19);
		contentPane.add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);
		
		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(339, 26, 177, 19);
		contentPane.add(txtHoTen);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(104, 49, 131, 19);
		contentPane.add(txtGioiTinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(339, 49, 177, 19);
		contentPane.add(txtNgaySinh);
		
		txtHSL = new JTextField();
		txtHSL.setColumns(10);
		txtHSL.setBounds(104, 72, 131, 19);
		contentPane.add(txtHSL);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(339, 72, 177, 19);
		contentPane.add(txtEmail);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(104, 95, 131, 19);
		contentPane.add(txtPhone);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String manv = txtMaNhanVien.getText();
					String hoten = txtHoTen.getText();
					Boolean gioitinh = txtGioiTinh.getText().toLowerCase() == "nam" ? true : false;
					Date ngaysinh = sdf.parse(txtNgaySinh.getText());
					Double hsl = Double.parseDouble(txtHSL.getText());
					String email = txtEmail.getText();
					String phone = txtPhone.getText();
					
					int kq = nvbo.insert(manv, hoten, gioitinh, ngaysinh, hsl, email, phone);
					
					if (kq == 0)
						JOptionPane.showMessageDialog(null, "Ma nv " + manv + " da ton tai");
					else if (kq == 1)
						JOptionPane.showMessageDialog(null, "Da them nhan vien " + manv + " vao danh sach");
					else
						JOptionPane.showMessageDialog(null, "Them nhan vien " + manv + " that bai");
					updateTable(nvbo.getNV());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnInsert.setBounds(245, 95, 85, 21);
		contentPane.add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String manv = JOptionPane.showInputDialog("Nhap ma nhan vien can xoa");
					if (nvbo.delete(manv) == 1)
						JOptionPane.showMessageDialog(null, "Xoa nhan vien " + manv + " thanh cong");
					else
						JOptionPane.showMessageDialog(null, "Xoa nhan vien " + manv + " that bai");
					updateTable(nvbo.getNV());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(336, 95, 85, 21);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String manv = JOptionPane.showInputDialog("Nhap ma nhan vien can cap nhat he so luong");
					Double hsl = Double.parseDouble(JOptionPane.showInputDialog("Nhap he so luong muon tang"));
					if (nvbo.update(manv, hsl) == 1)
						JOptionPane.showMessageDialog(null, "Cap nhat he so luong cua " + manv + " thanh cong");
					else
						JOptionPane.showMessageDialog(null, "Cap nhat he so luong cua " + manv + " that bai");
					updateTable(nvbo.getNV());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(431, 95, 85, 21);
		contentPane.add(btnUpdate);
	}
}
