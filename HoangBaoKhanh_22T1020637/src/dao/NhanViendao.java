package dao;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import bean.Nguoi;
import bean.NhanVien;

public class NhanViendao {
	public static ArrayList<NhanVien> getNV() throws Exception {
		ArrayList<Nguoi> list = Nguoidao.getDanhSach(); 
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		for(Nguoi nguoi: list) {
			if(nguoi instanceof NhanVien) {
				dsNV.add((NhanVien) nguoi);
				
			}
		}
		return dsNV;
	}
	public static void save() throws Exception {
		ArrayList<NhanVien> list = NhanViendao.getNV();
		FileWriter out = new FileWriter("f1.txt");
		for (NhanVien nv: list)
			out.write(nv.toString() + "\n");
		out.close();
	}
}
