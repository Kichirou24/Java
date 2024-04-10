package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class KetNoidao {
	public static String serverName, databaseName = "QLBH", user, password;
	public Connection cn;
	
	public Connection KetNoi() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String st = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + databaseName + ";user=" + user + ";password=" + password;
			cn = DriverManager.getConnection(st);
			if (cn.equals(null))
			{
				JOptionPane.showMessageDialog(null, "Loi");
			}			
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return cn;
	}
}