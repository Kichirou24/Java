package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bean.SinhVienbean;

public class SinhViendao {
	public ArrayList<SinhVienbean> getDS() throws Exception{
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

		// Tao 2 sinh vien
		String ngay5 = "01/06/2000";
		SinhVienbean sv1 = new SinhVienbean("sv1", "Anh", false, date.parse(ngay5), "K46", 6.5);
		String ngay6 = "05/05/1999";
		SinhVienbean sv2 = new SinhVienbean("sv2", "Huy", true, date.parse(ngay6), "K46", 9.0);
		
		// khai bao 1 mang de chua nguoi
		ArrayList<SinhVienbean> ds = new ArrayList<SinhVienbean>();
		// add do mang chua nguoi
		ds.add(sv1);
		ds.add(sv2);
		
		return ds;
	}
}
