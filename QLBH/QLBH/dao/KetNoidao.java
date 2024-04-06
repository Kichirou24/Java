package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoidao {
	public Connection cn;
	public void KetNoi() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String st = "jdbc:sqlserver://KICHIROU\\SQLEXPRESS:1433;databaseName=QLBH;user=sa;password=1234";
		cn = DriverManager.getConnection(st);
	}
}
