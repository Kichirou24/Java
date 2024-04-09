package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.KetNoidao;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class frmStaticsview extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable DanhSach;
	public static String date;
	private JTextField txtDate;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmStaticsview frame = new frmStaticsview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void load() throws Exception {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Thang");
		dtm.addColumn("ThanhTien");
		ArrayList<String> a = new ArrayList<String>();
		try {
			KetNoidao kn = new KetNoidao();
			kn.KetNoi();
			String sql = "SELECT ngaymua, SUM(gia * soluongmua) AS ThanhTien FROM HoaDon GROUP BY ngaymua";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next())
			{
				String Thang = rs.getString(1);
				String ThanhTien = rs.getString(2);
				a.add(Thang + ";" + ThanhTien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (String h : a)
		{
			String[] sp = h.split("[;]");
			dtm.addRow(sp);
		}
		DanhSach.setModel(dtm);
	}
	
	
	public void get() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			int id = DanhSach.getSelectedRow(); // lay dong vua chon
			date = DanhSach.getValueAt(id, 0).toString();
			Date d1 = sdf.parse(date);
			date = sdf.format(d1);
			txtDate.setText(sdf.format(d1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Create the frame.
	 */
	public frmStaticsview() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					load();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		setTitle(frmLoginview.Fullname);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 642, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 40, 608, 255);
		contentPane.add(tabbedPane);

		DanhSach = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		DanhSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				get();
			}
		});
		scrollPane.setViewportView(DanhSach);
		tabbedPane.addTab("Danh sach", null, scrollPane, null);
		
		JButton btnDetail = new JButton("Detail");
		btnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					load();
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				frmDetailview detail = new frmDetailview();
				detail.setVisible(true);
			}
		});
		btnDetail.setBounds(255, 9, 85, 21);
		contentPane.add(btnDetail);
		
		JLabel lblNewLabel = new JLabel("Ngay");
		lblNewLabel.setBounds(10, 13, 55, 13);
		contentPane.add(lblNewLabel);
		
		txtDate = new JTextField();
		txtDate.setBounds(75, 10, 170, 19);
		contentPane.add(txtDate);
		txtDate.setColumns(10);
	}
}
