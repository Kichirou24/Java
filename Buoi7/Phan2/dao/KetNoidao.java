package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class KetNoidao {
	public Connection cn;
	
	public void KetNoi() throws Exception {
		// b1: Xac dinh HQTCSDL
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xac dinh HQTCSDL");
		// b2: Ket noi CSDL
		String st = "jdbc:sqlserver://KICHIROU\\SQLEXPRESS:1433;databaseName=Nhom2;user=sa;password=1234";
		cn = DriverManager.getConnection(st);
		System.out.println("Da ket noi den CSDL");
	}

	public static void main(String[] args)
	{
		try {
			// b1: Ket noi SQL
			KetNoidao kn = new KetNoidao();
			kn.KetNoi();
			// Lay ve tat ca nhan vien
			// b2: Tao lenh sql
			String sql = "SELECT * FROM NhanVien";
			// b3: Tao cau lenh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			// b4: Thuc hien lenh
			ResultSet rs = cmd.executeQuery();
			// b5: Duyet rs
			while (rs.next())
			{
				System.out.println(rs.getString("manv") + ";" + rs.getString("hoten") + ";" + rs.getBoolean("gioitinh") + ";" + rs.getDate("ngaysinh") + ";" + rs.getDouble("hsl") + ";" + rs.getString("email") + ";" + rs.getString("phone"));
			}
			
			// Lay ve nhan vien co ho Le
			// b2: Tao lenh sql
			sql = "SELECT * FROM NhanVien AS nv WHERE nv.hoten LIKE 'Le%'";
			// b3: Tao cau lenh
			cmd = kn.cn.prepareStatement(sql);
			// b4: Thuc hien lenh
			rs = cmd.executeQuery();
			// b5: Duyet rs
			while (rs.next())
			{
				System.out.println(rs.getString("manv") + ";" + rs.getString("hoten") + ";" + rs.getBoolean("gioitinh") + ";" + rs.getDate("ngaysinh") + ";" + rs.getDouble("hsl") + ";" + rs.getString("email") + ";" + rs.getString("phone"));
			}
			
			// Tinh TBC cua HSL
			// b2: Tao lenh sql
			sql = "SELECT	AVG(nv.hsl) FROM	NhanVien AS nv ";
			// b3: Tao cau lenh
			cmd = kn.cn.prepareStatement(sql);
			// b4: Thuc hien lenh
			rs = cmd.executeQuery();
			// b5: Duyet rs
			while (rs.next())
			{
				System.out.println(rs.getString("manv") + ";" + rs.getString("hoten") + ";" + rs.getBoolean("gioitinh") + ";" + rs.getDate("ngaysinh") + ";" + rs.getDouble("hsl") + ";" + rs.getString("email") + ";" + rs.getString("phone"));
			}
			
			// Them vao 1 nhan vien
			// b2: Tao lenh sql
			sql = "INSERT INTO NhanVien VALUES('nv6', 'A', 0, '2000-05-05', 4, 'd@husc.edu.vn', 4)";
			// b3: Tao cau lenh
			cmd = kn.cn.prepareStatement(sql);
			// b4: Thuc hien lenh
			rs = cmd.executeQuery();
			// b5: Duyet rs
			while (rs.next())
			{
				System.out.println(rs.getString("manv") + ";" + rs.getString("hoten") + ";" + rs.getBoolean("gioitinh") + ";" + rs.getDate("ngaysinh") + ";" + rs.getDouble("hsl") + ";" + rs.getString("email") + ";" + rs.getString("phone"));
			}
			
			// Tang HSL len 2 cho nv1
			// b2: Tao lenh sql
			sql = "UPDATE NhanVien SET hsl = 2 WHERE manv = 'nv1'";
			// b3: Tao cau lenh
			cmd = kn.cn.prepareStatement(sql);
			// b4: Thuc hien lenh
			rs = cmd.executeQuery();
			// b5: Duyet rs
			while (rs.next())
			{
				System.out.println(rs.getString("manv") + ";" + rs.getString("hoten") + ";" + rs.getBoolean("gioitinh") + ";" + rs.getDate("ngaysinh") + ";" + rs.getDouble("hsl") + ";" + rs.getString("email") + ";" + rs.getString("phone"));
			}
			
			// Xoa nhan vien (nv1)
			// b2: Tao lenh sql
			sql = "DELETE FROM NhanVien WHERE manv='nv1'";
			// b3: Tao cau lenh
			cmd = kn.cn.prepareStatement(sql);
			// b4: Thuc hien lenh
			rs = cmd.executeQuery();
			// b5: Duyet rs
			while (rs.next())
			{
				System.out.println(rs.getString("manv") + ";" + rs.getString("hoten") + ";" + rs.getBoolean("gioitinh") + ";" + rs.getDate("ngaysinh") + ";" + rs.getDouble("hsl") + ";" + rs.getString("email") + ";" + rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
