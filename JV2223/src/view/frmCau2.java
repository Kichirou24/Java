package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bo.nguoiBo;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frmCau2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable DanhSach;

	public void load() throws Exception {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Ma");
		dtm.addColumn("HoTen");
		dtm.addColumn("LoaiHopDong");
		dtm.addColumn("HeSoLuong");
		dtm.addColumn("PhuCap");
		
		nguoiBo nBo = new nguoiBo();
		
		ArrayList<String> ds = nBo.getAndSave();
		for (String s : ds)
		{
			String[] sp = s.split("[,]");
			dtm.addRow(sp);
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
					
					frmCau2 frame = new frmCau2();
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
	public frmCau2() {
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
		setBounds(100, 100, 670, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 80, 636, 244);
		contentPane.add(tabbedPane);
		
		DanhSach = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setViewportView(DanhSach);
		tabbedPane.addTab("Danh sach", null, scrollPane, null);
		
		
		JLabel lblNewLabel = new JLabel("Danh sach hop le");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(214, 39, 165, 31);
		contentPane.add(lblNewLabel);
	}
}
