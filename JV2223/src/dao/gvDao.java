package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import bean.gvBean;

public class gvDao {
	public Connection cn;
	public ArrayList<gvBean> getGV() throws Exception
	{
		ArrayList<gvBean> ds = new ArrayList<gvBean>();
		
		FileReader f = new FileReader("ketqua.txt");
		BufferedReader r = new BufferedReader(f);
		
		String line = "";
		while ((line = r.readLine()) != null)
		{
			String[] sp = line.split("[,]");
			if (sp.length == 5)
			{
				String maGV = sp[0];
				String hoTen = sp[1];
				String loaiHopDong = sp[2];
				Double heSoLuong = Double.parseDouble(sp[3]);
				Double phuCap = Double.parseDouble(sp[4]);
				
				ds.add(new gvBean(maGV, hoTen, loaiHopDong, heSoLuong, phuCap));
				System.out.println(line);
			}
		}
		r.close();
		return ds;
	}
	
	public int saveSQL(gvBean gv) throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String st = "jdbc:sqlserver://KICHIROU\\SQLEXPRESS:1433;databaseName=JV2223;user=sa;password=1234";
		cn = DriverManager.getConnection(st);
		
		String sql = "INSERT INTO GiangVien(maGV, hoTen, loaiHopDong, heSoLuong, phuCap) VALUES(?, ?, ?, ?, ?)";
		PreparedStatement cmd = cn.prepareStatement(sql);
		cmd.setString(1, gv.getMaGV());
		cmd.setString(2, gv.getHoTen());
		cmd.setString(3, gv.getLoaiHopDong());
		cmd.setDouble(4, gv.getHeSoLuong());
		cmd.setDouble(5, gv.getPhuCap());
		
		int kq = cmd.executeUpdate();
		cmd.close();
		cn.close();
		return kq;
	}
}
