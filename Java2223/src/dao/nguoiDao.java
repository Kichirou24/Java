package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import bean.giangVienBean;
import bean.nguoiBean;
import bean.nhanVienBean;

public class nguoiDao {
	public Connection cn;
	
	public Connection connect(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String st = "jdbc:sqlserver://KICHIROU\\SQLEXPRESS:1433;databaseName=Java2223;user=sa;password=1234";
			
			cn = DriverManager.getConnection(st);
			
			if (cn.equals(null))
				JOptionPane.showMessageDialog(null, "Loi Connect SQL");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
	
	public void readFileDanhSach() throws Exception{		
		FileReader f1 = new FileReader("danhsach.txt");
		BufferedReader r = new BufferedReader(f1);
		
		FileWriter f2 = new FileWriter("ketqua.txt");
		PrintWriter w = new PrintWriter(f2);
		
		String line = "";
		while (!(line = r.readLine()).equals(null))
		{
			String[] sp = line.split("[,]");
			if (sp[2].equals("chinhthuc") || sp[2].equals("hopdong"))
			{
				if (sp.length == 4)
				{
					w.write(line);
					System.out.println(line);
				}
				else if (sp.length == 5)
				{
					w.write(line);
					System.out.println(line);
				}
			}
		}
		w.close();
		r.close();
	}
	
	public ArrayList<nguoiBean> readFileKetQua() throws Exception{
		ArrayList<nguoiBean> ds = new ArrayList<nguoiBean>();
		
		FileReader f = new FileReader("ketqua.txt");
		BufferedReader r = new BufferedReader(f);
		
		String line = "";
		while (!(line = r.readLine()).equals(null))
		{
			String[] sp = line.split("[,]");
			
			if (sp.length == 4)
				ds.add(new nhanVienBean(sp[0], sp[1], sp[2], Double.parseDouble(sp[3])));
			else if (sp.length == 5)
				ds.add(new giangVienBean(sp[0], sp[1], sp[2], Double.parseDouble(sp[3]), Double.parseDouble(sp[4])));
		}

		System.out.println("Danh sach nhan vien");
		
		for (nguoiBean nguoi : ds)
			if (nguoi instanceof nhanVienBean)
				System.out.println(nguoi);
	
		System.out.println("Danh sach giang vien");
		
		for (nguoiBean nguoi : ds)
			if (nguoi instanceof giangVienBean)
				System.out.println(nguoi);
		
		r.close();
		return ds;
	}
}
