package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class frmMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable ChinhThuc;
	private JTable HopDong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMain frame = new frmMain();
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
	public frmMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane TabbedPane = new JTabbedPane(JTabbedPane.TOP);
		TabbedPane.setBounds(10, 134, 400, 242);
		contentPane.add(TabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		TabbedPane.addTab("Chinh Thuc", null, scrollPane, null);
		
		ChinhThuc = new JTable();
		scrollPane.setViewportView(ChinhThuc);
		
		JTabbedPane TabbedPane1 = new JTabbedPane(JTabbedPane.TOP);
		TabbedPane1.setBounds(420, 134, 400, 242);
		contentPane.add(TabbedPane1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		TabbedPane1.addTab("Hop Dong", null, scrollPane_1, null);
		
		HopDong = new JTable();
		scrollPane_1.setViewportView(HopDong);
	}
}
