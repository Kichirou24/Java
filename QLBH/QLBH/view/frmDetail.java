package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.KetNoidao;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class frmDetail extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable ChiTiet;
	frmStatics frmStatic = new frmStatics();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDetail frame = new frmDetail();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void load() throws Exception
	{
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("sohoadon");
		dtm.addColumn("mahang");
		dtm.addColumn("tenhang");
		dtm.addColumn("ngaymua");
		dtm.addColumn("soluongmua");
		dtm.addColumn("gia");
		dtm.addColumn("thanhtien");
		ArrayList<String> a = new ArrayList<String>();
		try {
			KetNoidao kn = new KetNoidao();
			kn.KetNoi();
			String sql = "SELECT * FROM HoaDon WHERE MONTH(ngaymua) = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, frmStatics.thang);
			ResultSet rs = cmd.executeQuery();
			while (rs.next())
			{
				Integer soHoaDon = rs.getInt(1);
				String maHang = rs.getString(2);
				String tenHang = rs.getString(3);
				Date ngayMuaHang = rs.getDate(4);
				Integer soLuongMua = rs.getInt(5);
				Double gia = rs.getDouble(6);
				Double thanhTien = gia * soLuongMua;
				a.add(soHoaDon + ";" + maHang + ";" + tenHang + ";" + ngayMuaHang + ";" + soLuongMua + ";" + gia + ";" + thanhTien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (String h : a)
		{
			String[] sp = h.split("[;]");
			dtm.addRow(sp);
		}
		ChiTiet.setModel(dtm);
		
	}
	
	/**
	 * Create the frame.
	 */
	public frmDetail() {
		setTitle("Cac hoa don trong thang " + frmStatics.thang);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					load();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 571, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 31, 537, 222);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh sach chi tiet", null, scrollPane, null);
		
		ChiTiet = new JTable();
		scrollPane.setViewportView(ChiTiet);
	}
}
