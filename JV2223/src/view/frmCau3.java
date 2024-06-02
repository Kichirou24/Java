package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.gvBean;
import bean.nvBean;
import bo.gvBo;
import bo.nvBo;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class frmCau3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable DSNV;
	private JTable DSGV;
	private JTextField txtCntNhanVien;
	private JTextField txtCntGiangVien;

	public void loadNV() throws Exception{
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Ma");
		dtm.addColumn("HoTen");
		dtm.addColumn("LoaiHopDong");
		dtm.addColumn("HeSoLuong");
		
		nvBo nv = new nvBo();
		
		ArrayList<nvBean> ds = nv.getNV();
		
		for (nvBean n : ds)
		{
			String st = n.toString();
			String[] sp = st.split("[,]");
			dtm.addRow(sp);
		}
		
		txtCntNhanVien.setText(ds.size() + "");
		
		DSNV.setModel(dtm);
	}
	
	public void loadGV() throws Exception{
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Ma");
		dtm.addColumn("HoTen");
		dtm.addColumn("LoaiHopDong");
		dtm.addColumn("HeSoLuong");
		dtm.addColumn("PhuCap");
		
		gvBo gv = new gvBo();
		
		ArrayList<gvBean> ds = gv.getGV();
		
		for (gvBean g : ds)
		{
			String st = g.toString();
			String[] sp = st.split("[,]");
			dtm.addRow(sp);
		}
		
		txtCntGiangVien.setText(ds.size() + "");
		
		DSGV.setModel(dtm);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCau3 frame = new frmCau3();
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
	public frmCau3() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					loadNV();
					loadGV();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 986, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 102, 455, 221);
		contentPane.add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(475, 102, 472, 221);
		contentPane.add(tabbedPane_1);

		DSNV = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setViewportView(DSNV);
		tabbedPane.addTab("Danh Sach Nhan Vien", null, scrollPane, null);
		
		DSGV = new JTable();
		JScrollPane scrollPane_1 = new JScrollPane();
		
		scrollPane_1.setViewportView(DSGV);
		tabbedPane_1.addTab("Danh Sach Giang Vien", null, scrollPane_1, null);
		
		txtCntNhanVien = new JTextField();
		txtCntNhanVien.setBounds(369, 79, 96, 19);
		contentPane.add(txtCntNhanVien);
		txtCntNhanVien.setColumns(10);
		
		txtCntGiangVien = new JTextField();
		txtCntGiangVien.setColumns(10);
		txtCntGiangVien.setBounds(851, 79, 96, 19);
		contentPane.add(txtCntGiangVien);
		
		JLabel lblNewLabel = new JLabel("So Luong");
		lblNewLabel.setBounds(294, 79, 65, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblSoLuong = new JLabel("So Luong");
		lblSoLuong.setBounds(778, 82, 63, 13);
		contentPane.add(lblSoLuong);
	}
}