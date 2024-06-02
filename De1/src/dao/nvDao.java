package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import bean.nvBean;

public class nvDao {
	public Connection cn;
	public void showFile() throws Exception{
		FileReader fr = new FileReader("ds.txt");
		BufferedReader r = new BufferedReader(fr);
		
		String line = "";
		
		while ((line = r.readLine()) != null) {
			String[] sp = line.split("[,]");
			
			if (sp.length == 4 && (sp[2].equals("hopdong") || sp[2].equals("chinhthuc")))
				System.out.println(line);
		}
		
		r.close();
	}

	public ArrayList<nvBean> readFile() throws Exception{
		ArrayList<nvBean> ds = new ArrayList<nvBean>();
		
		FileReader fr = new FileReader("ds.txt");
		BufferedReader r = new BufferedReader(fr);
		
		String line = "";
		
		while ((line = r.readLine()) != null) {
			String[] sp = line.split("[,]");
			
			if (sp.length == 4 && (sp[2].equals("hopdong") || sp[2].equals("chinhthuc")))
			{
				ds.add(new nvBean(sp[0], sp[1], sp[2], Double.parseDouble(sp[3])));
				System.out.println(line);
			}
		}
		
		r.close();
		
		return ds;
	}
	
	public Connection connect(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String st = "jdbc:sqlserver://KICHIROU\\SQLEXPRESS:1433;databaseName=De1;user=sa;password=1234";
			cn = DriverManager.getConnection(st);
			if (cn.equals(null))
				JOptionPane.showMessageDialog(null, "Loi");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
	
	public int insertSQL(nvBean nv) throws Exception{
		nvDao nvD = new nvDao();
		nvD.connect();
		
		String sql = "INSERT INTO NhanVien(maNV, hoTen, loaiHopDong, heSoLuong) VALUES(?, ?, ?, ?)";
		PreparedStatement cmd = nvD.cn.prepareStatement(sql);
		
		cmd.setString(1, nv.getMaNV());
		cmd.setString(2, nv.getHoTen());
		cmd.setString(3, nv.getLoaiHopDong());
		cmd.setDouble(4, nv.getHeSoLuong());
		
		int kq = cmd.executeUpdate();
		cmd.close();
		nvD.cn.close();
		return kq;
	}
	
	public ArrayList<nvBean> getSQL() throws Exception{
		ArrayList<nvBean> ds = new ArrayList<nvBean>();
		
		nvDao nvD = new nvDao();
		nvD.connect();
		
		String sql = "SELECT * FROM NhanVien";
		PreparedStatement cmd = nvD.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		
		while (rs.next())
		{
			String maNV = rs.getString(1);
			String hoTen = rs.getString(2);
			String loaiHopDong = rs.getString(3);
			double heSoLuong = rs.getDouble(4);
			
			nvBean nv = new nvBean(maNV, hoTen, loaiHopDong, heSoLuong);
			ds.add(nv);
		}
		
		return ds;
	}
	
	public ArrayList<nvBean> showSQL() throws Exception{
		ArrayList<nvBean> ds = new ArrayList<nvBean>();
		
		nvDao nvD = new nvDao();
		nvD.connect();
		
		String sql = "SELECT * FROM NhanVien WHERE NhanVien.loaiHopDong = 'chinhthuc'";
		PreparedStatement cmd = nvD.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		
		while (rs.next())
		{
			String maNV = rs.getString(1);
			String hoTen = rs.getString(2);
			String loaiHopDong = rs.getString(3);
			double heSoLuong = rs.getDouble(4);
			
			nvBean nv = new nvBean(maNV, hoTen, loaiHopDong, heSoLuong);
			ds.add(nv);
			System.out.println(nv.toString());
		}
		
		return ds;
	}
}