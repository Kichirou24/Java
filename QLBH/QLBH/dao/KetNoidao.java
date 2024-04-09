package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import view.frmLoginSQLview;

public class KetNoidao {
	public Connection cn;
	frmLoginSQLview lsql = new frmLoginSQLview();
	public Connection KetNoi() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String st = "jdbc:sqlserver://" + lsql.serverName + ":1433;databaseName=" + lsql.databaseName + ";user=" + lsql.user + ";password=" + lsql.password;
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