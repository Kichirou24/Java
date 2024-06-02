package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class nguoiDao {
	public Connection cn;
	public Connection connect()
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String st = "jdbc:sqlserver://KICHIROU\\SQLEXPRESS:1433;databaseName=JV2223;user=sa;password=1234";
			cn = DriverManager.getConnection(st);
			if (cn.equals(null))
				JOptionPane.showMessageDialog(null, "Loi");
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return cn;
	}
	
	public ArrayList<String> getAndSave() throws Exception
	{
		ArrayList<String> ds = new ArrayList<String>();
		FileReader f1 = new FileReader("danhsach.txt");
		BufferedReader r = new BufferedReader(f1);
		
		FileWriter f2 = new FileWriter("ketqua.txt");
		PrintWriter w = new PrintWriter(f2);
		
		String line = "";
		while ((line = r.readLine()) != null)
		{
			String[] sp = line.split("[,]");
			if (sp.length == 4 || sp.length == 5)
			{
				if (sp[2].equals("chinhthuc") || sp[2].equals("hopdong"))
				{
					ds.add(line);
					System.out.println(line);
					w.write(line +'\n');
				}
			}
		}
		r.close();
		w.close();
		return ds;
	}
}
