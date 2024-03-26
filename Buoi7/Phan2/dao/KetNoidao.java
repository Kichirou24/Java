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
		String st = "jdbc:sqlserver://LABE403-32;databaseName=Nhom2;user=sa;password=123";
		cn = DriverManager.getConnection(st);
		System.out.println("Da ket noi den CSDL");
	}

	public static void main(String[] args)
	{
		try {
			// b1: Ket noi SQL
			KetNoidao kn = new KetNoidao();
			kn.KetNoi();
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
			
			// b1: da ket noi
			// b2:
			String sql1 = "DELETE FROM NhanVien WHERE manv=?";
			// b3: Tao cau lenh
			PreparedStatement cmd1 = kn.cn.prepareStatement(sql1);
			cmd1.setString(1, "nv1");
			// b4: Thuc hien lenh
			cmd1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
