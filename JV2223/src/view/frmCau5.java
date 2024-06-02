package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.nguoiDao;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class frmCau5 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable DanhSach;

	public void load() throws Exception{
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("LoaiHopDong");
		dtm.addColumn("SoLuong");
		
		ArrayList<String> ds = new ArrayList<String>();
		
		try {			
			nguoiDao nDao = new nguoiDao();
			nDao.connect();
			
			String sql = "SELECT loaiHopDong, COUNT(loaiHopDong) 'soLuong' FROM	NhanVien GROUP BY loaiHopDong";
			PreparedStatement cmd = nDao.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			
			while (rs.next()) {
				String loaiHopDong = rs.getString(1);
				String soLuong = rs.getString(2);
				ds.add(loaiHopDong + ',' + soLuong);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (String d : ds)
		{
			String[] s = d.split("[,]");
			dtm.addRow(s);
		}
		
		DanhSach.setModel(dtm);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCau5 frame = new frmCau5();
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
	public frmCau5() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					load();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 666, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 55, 632, 260);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh Sach", null, scrollPane, null);
		
		DanhSach = new JTable();
		scrollPane.setViewportView(DanhSach);
	}

}
