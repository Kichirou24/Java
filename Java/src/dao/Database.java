package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import bean.NhanVienbean;

public class Database {
	public Connection cn;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public Connection connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String st = "jdbc:sqlserver://KICHIROU\\SQLEXPRESS:1433;databaseName=Java;user=sa;password=123";
			cn = DriverManager.getConnection(st);
			if (cn.equals(null))
				JOptionPane.showMessageDialog(null, "Loi Connect SQL");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
	
	public ArrayList<NhanVienbean> getNV() throws Exception {
		ArrayList<NhanVienbean> ds = new ArrayList<NhanVienbean>();
		try {
			// b1: ket noi csdl
			Database kn = new Database();
			kn.connect();
			// b2: tao lenh sql
			String sql = "SELECT * FROM NhanVien";
			// b3: tao doi tuong PrepareStatement
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			// b4: truyen tham so neu co
			// b5: cho thuc hien cau lenh
			ResultSet rs = cmd.executeQuery();
			// b6: duyet rs va luu vao mang ds
			while (rs.next())
			{
				String manv = rs.getString("manv");
				String hoten = rs.getString("hoten");
				boolean gioitinh = rs.getBoolean("gioitinh");
				Date ngaysinh = rs.getDate("ngaysinh");
				Double hsl = rs.getDouble("hsl");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				NhanVienbean nv = new NhanVienbean(manv, hoten, gioitinh, ngaysinh, hsl, email, phone);
				ds.add(nv);
			}
			// b7: dong ket noi
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public int deleteNV(String manv) throws Exception{
		Database kn = new Database();
		kn.connect();
		
		String sql = "DELETE FROM NhanVien WHERE manv=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, manv);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
	
	public int updateNV(String manv, Double hsl) throws Exception {
		Database kn = new Database();
		kn.connect();
		
		String sql = "UPDATE NhanVien SET hsl = hsl + ? WHERE manv = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setDouble(1, hsl);
		cmd.setString(2, manv);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
	
	public int insertNV(String maNV, String hoTen, boolean gioiTinh, Date ngaySinh, Double hSL, String email, String phone) throws Exception {
		Database kn = new Database();
		kn.connect();
		
		String sql = "INSERT INTO NhanVien (manv, hoten, gioitinh, ngaysinh, hsl, email, phone)\r\n"
				+ "VALUES(?,?,?,?,?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, maNV);
		cmd.setString(2, hoTen);
		cmd.setBoolean(3, gioiTinh);
		cmd.setDate(4, new java.sql.Date(ngaySinh.getTime()));
		cmd.setDouble(5, hSL);
		cmd.setString(6, email);
		cmd.setString(7, phone);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
