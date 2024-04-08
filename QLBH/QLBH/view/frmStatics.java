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
import java.util.ArrayList;

public class frmStatics extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable DanhSach;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmStatics frame = new frmStatics();
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
			String sql = "SELECT MONTH(ngaymua) AS Thang, SUM(gia * soluongmua) AS ThanhTien FROM HoaDon GROUP BY MONTH(ngaymua)";
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
	
	/**
	 * Create the frame.
	 */
	public frmStatics() {
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
		setTitle(frmLogin.Fullname);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 642, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 40, 608, 255);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh sach", null, scrollPane, null);
		
		DanhSach = new JTable();
		scrollPane.setViewportView(DanhSach);
	}
}
