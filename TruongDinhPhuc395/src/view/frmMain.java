package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.CaoDangbean;
import bean.DaiHocbean;
import bean.SinhVienbean;
import dao.SinhViendao;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class frmMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	SinhViendao svdao = new SinhViendao();
	ArrayList<SinhVienbean> ds = new ArrayList<SinhVienbean>();
	private JTable table;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
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

	void napBang(ArrayList<SinhVienbean> ds) {
		// Tao ra mo hinh bang 
		DefaultTableModel sv = new DefaultTableModel();
		// Tao cot
		sv.addColumn("Mã sinh viên");
		sv.addColumn("Họ tên");
		sv.addColumn("Ngày sinh");
		sv.addColumn("Điểm trung bình");
		sv.addColumn("Điểm nghiên cứu khoa học");
		sv.addColumn("Điều kiện ngoại ngữ");
		// Them hang
		
		for (SinhVienbean h : ds)
		{
			String[] sp = h.toString().split(";");
			sv.addRow(sp);
		}
		// Dua mo hinh vao bang
		table.setModel(sv);
	}
	
	void readFile()
	{
		try {
			FileReader f = new FileReader("ds.txt");
			BufferedReader r = new BufferedReader(f);
			
			while (true)
			{
				String st = r.readLine();
				if (st == "" || st == null)
					break;
				
				String[] sp = st.trim().split("[,]");
				
				if (sp.length == 6)
				{
					ds.add(new DaiHocbean(sp[0], sp[1], sdf.parse(sp[2]), Double.parseDouble(sp[3]), Boolean.parseBoolean(sp[4]), Boolean.parseBoolean(sp[5])));
				}
				else if (sp.length == 5)
				{
					ds.add(new CaoDangbean(sp[0], sp[1], sdf.parse(sp[2]), Double.parseDouble(sp[3]), Boolean.parseBoolean(sp[4])));
				}
				else
				{
					saveError(st);
				}
			}
			r.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void writeFile()
	{
		try {
			FileWriter f1 = new FileWriter("f1.txt");
			PrintWriter r1 = new PrintWriter(f1);
			
			FileWriter f2 = new FileWriter("f2.txt");
			PrintWriter r2 = new PrintWriter(f2);

			for (SinhVienbean sv : ds)
			{
				if (sv instanceof DaiHocbean) {
						r1.println(sv.toString());				
				}
			}
			
			for (SinhVienbean sv : ds)
			{
				if (sv instanceof CaoDangbean) {
						r2.println(sv.toString());				
				}
			}
			
			r1.close();
			r2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveError(String str)
	{
		try {
			FileWriter f = new FileWriter("loi.txt");
			PrintWriter w = new PrintWriter(f);
			w.println(str);
			w.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public frmMain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				readFile();
			}
			@Override
			public void windowClosing(WindowEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "Luu file khong?");
				if (n == 0)
					writeFile();
				
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(31, 89, 258, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nhập tên sinh viên cần tìm thông tin");
		lblNewLabel.setBounds(31, 64, 258, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Find");
		btnNewButton.setBounds(315, 88, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<SinhVienbean> tam = new ArrayList<SinhVienbean>();
				if (txtName.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Tên trống!");
				}
				else
				{					
					Boolean fi = false;
					for (SinhVienbean sv : ds)
					{
						if (sv.getHoTen().toLowerCase().trim().contains(txtName.getText().toLowerCase().trim()))
						{
							fi = true;
							tam.add(sv);
						}
					}
					if (fi == true)
						napBang(tam);
					else
						JOptionPane.showMessageDialog(null, "Không tìm thấy tên của sinh viên!");
				}
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Hiển thị danh sách sinh viên đại học, cao đẳng");
		lblNewLabel_1.setBounds(31, 28, 258, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Show");
		btnNewButton_1.setBounds(315, 24, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ds = svdao.getDS();
					napBang(ds);
				} catch (Exception e1) {
					e1.printStackTrace();
				}				
			}
		});
		contentPane.add(btnNewButton_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 168, 819, 229);
		contentPane.add(tabbedPane);
		
		table = new JTable();
		tabbedPane.addTab("Sinh Viên", null, table, null);
		
		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.setBounds(315, 134, 89, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter f1 = new FileWriter("f1.txt");
					PrintWriter r1 = new PrintWriter(f1);
					
					FileWriter f2 = new FileWriter("f2.txt");
					PrintWriter r2 = new PrintWriter(f2);

					for (SinhVienbean sv : ds)
					{
						if (sv instanceof DaiHocbean) {
								r1.println(sv.toString());				
						}
					}
					
					for (SinhVienbean sv : ds)
					{
						if (sv instanceof CaoDangbean) {
								r2.println(sv.toString());				
						}
					}
					r1.close();
					r2.close();
					JOptionPane.showMessageDialog(null, "Đã lưu");
				} catch (Exception el) {
					JOptionPane.showMessageDialog(null, "Không thể lưu!");
					
				}
			}
		});
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Lưu danh sách sinh viên đại học, cao đẳng");
		lblNewLabel_2.setBounds(31, 138, 258, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Hiển thị danh sách sinh viên đại học");
		lblNewLabel_3.setBounds(460, 28, 267, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Hiển thị danh sách sinh viên cao đẳng");
		lblNewLabel_4.setBounds(460, 92, 267, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_3 = new JButton("Show");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<SinhVienbean> tam = new ArrayList<SinhVienbean>();
				for (SinhVienbean sv : ds)
					if (sv instanceof DaiHocbean) {
						 tam.add(sv);
					}
				napBang(tam);
			}
		});
		btnNewButton_3.setBounds(501, 53, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Show");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<SinhVienbean> tam = new ArrayList<SinhVienbean>();
				for (SinhVienbean sv : ds)
					if (sv instanceof CaoDangbean) {
						 tam.add(sv);
					}
				napBang(tam);
			}
		});
		btnNewButton_3_1.setBounds(501, 134, 89, 23);
		contentPane.add(btnNewButton_3_1);
		
		
	}
}
