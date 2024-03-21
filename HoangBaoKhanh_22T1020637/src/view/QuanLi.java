package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.NhanVien;
import bean.SinhVien;
import bo.NhanVienbo;
import dao.NhanViendao;
import dao.SinhViendao;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class QuanLi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputname;
	private JTable table = new JTable();
	private JTextField textField_1 = new JTextField();
	private JComboBox<String> cmb = new JComboBox<String>();
	private JLabel lblNewLabel_1 = new JLabel();
	private JButton btnNewButton = new JButton("Tìm kiếm");
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLi frame = new QuanLi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	void updateTableNhanVien(ArrayList<NhanVien> list) {
		DefaultTableModel tableMode = new DefaultTableModel();
		tableMode.addColumn("Mã nhân viên");
		tableMode.addColumn("Họ tên");
		tableMode.addColumn("Ngày Sinh");
		tableMode.addColumn("Hệ số lương");
		tableMode.addColumn("Tổng lương");
		for(NhanVien nv: list) {
			tableMode.addRow(nv.toObject());
		}
		try {
			textField_1.setText(NhanVienbo.TongLuongNV().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setModel(tableMode);
	}
	void updateTableSinhVien(ArrayList<SinhVien> list) {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã sinh viên");
		tableModel.addColumn("Họ và tên");
		tableModel.addColumn("Ngày sinh");
		tableModel.addColumn("Điểm môn 1");
		tableModel.addColumn("Điểm môn 2");
		tableModel.addColumn("Điểm TB");
		for (SinhVien sv: list) {
			tableModel.addRow(sv.toObject());
		}
		table.setModel(tableModel); 
	}
	/**
	 * Create the frame.
	 */
	public QuanLi() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				String x = String.valueOf(cmb.getSelectedItem());
				if(x.equals("Sinh viên")) {
					try {
						updateTableSinhVien(SinhViendao.getSV());
						lblNewLabel_1.setVisible(false);
						textField_1.setVisible(false);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if(x.equals("Nhân viên")){
					try {
						updateTableNhanVien(NhanViendao.getNV());
						lblNewLabel_1.setVisible(true);
						textField_1.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cmb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String x = String.valueOf(cmb.getSelectedItem());
				if(x.equals("Sinh viên")) {
					try {
						updateTableSinhVien(SinhViendao.getSV());
						lblNewLabel_1.setVisible(false);
						textField_1.setVisible(false);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if(x.equals("Nhân viên")){
					try {
						updateTableNhanVien(NhanViendao.getNV());
						lblNewLabel_1.setVisible(true);
						textField_1.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		cmb.setBounds(39, 37, 92, 21);
		contentPane.add(cmb);
		cmb.addItem("Sinh viên");
		cmb.addItem("Nhân viên");		
		JLabel lblNewLabel = new JLabel("Nhập tên: ");
		lblNewLabel.setBounds(371, 41, 69, 13);
		contentPane.add(lblNewLabel);
		
		inputname = new JTextField();
		inputname.setBounds(450, 38, 146, 19);
		contentPane.add(inputname);
		inputname.setColumns(10);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = inputname.getText();
				
			}
		});
		btnNewButton.setBounds(614, 37, 85, 21);
		contentPane.add(btnNewButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(35, 182, 664, 263);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		scrollPane.setViewportView(table);
		
		lblNewLabel_1.setText("Tổng lương: ");
		lblNewLabel_1.setBounds(363, 159, 77, 13);
		contentPane.add(lblNewLabel_1);
	
		textField_1.setBounds(451, 156, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
