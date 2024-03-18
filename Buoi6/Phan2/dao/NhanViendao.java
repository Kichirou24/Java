package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bean.NhanVienbean;

public class NhanViendao {
	public ArrayList<NhanVienbean> getDS() throws Exception{
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

		// Tao 2 nhan vien
		String ngay3 = "17/04/1999";
		NhanVienbean nv1 = new NhanVienbean("nv1", "Tien", true, date.parse(ngay3), 3.5, "Tienbip@gmail.com", "0987654321");
		String ngay4 = "10/07/2008";
		NhanVienbean nv2 = new NhanVienbean("nv2", "Thu", false, date.parse(ngay4), 3.0, "Thudieu@gmail.com", "0123456789");
		
		// khai bao 1 mang de chua nguoi
		ArrayList<NhanVienbean> ds = new ArrayList<NhanVienbean>();
		// add do mang chua nguoi
		ds.add(nv1);
		ds.add(nv2);
		
		return ds;
	}
}
