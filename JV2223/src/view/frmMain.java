package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.gvBean;
import bean.nvBean;
import bo.gvBo;
import bo.nvBo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class frmMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	nvBo nv = new nvBo();
	gvBo gv = new gvBo();
	
	ArrayList<nvBean> dsNV = new ArrayList<nvBean>();
	ArrayList<gvBean> dsGV = new ArrayList<gvBean>();

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
		setBounds(100, 100, 366, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cau 2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCau2 cau2 = new frmCau2();
				cau2.setVisible(true);
			}
		});
		btnNewButton.setBounds(121, 31, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cau 3");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dsNV = nv.getNV();
					dsGV = gv.getGV();				
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				frmCau3 cau3 = new frmCau3();
				cau3.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(121, 84, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_2 = new JButton("Cau 4");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int kq = 1;
				try {
					for (nvBean n : dsNV)
						nv.saveSQL(n);
					for (gvBean g : dsGV)
						gv.saveSQL(g);
					
				} catch (Exception e2) {
					kq = 0;
					e2.printStackTrace();
				}
				if (kq == 1)
					JOptionPane.showMessageDialog(null, "Luu thanh cong");
				else if (kq == 0)
					JOptionPane.showMessageDialog(null, "Luu khong thanh cong");
			}
		});
		btnNewButton_1_2.setBounds(121, 125, 85, 21);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_1 = new JButton("Cau 5");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCau5 cau5 = new frmCau5();
				cau5.setVisible(true);
			}
		});
		btnNewButton_1_1.setBounds(121, 167, 85, 21);
		contentPane.add(btnNewButton_1_1);
	}
}
