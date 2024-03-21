package dao;

import java.io.FileWriter;
import java.util.ArrayList;

import bean.Nguoi;
import bean.SinhVien;

public class SinhViendao {
	public static ArrayList<SinhVien> getSV() throws Exception {
		ArrayList<Nguoi> list = Nguoidao.getDanhSach(); 
		ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();
		for(Nguoi nguoi: list) {
			if(nguoi instanceof SinhVien) {
				dsSV.add((SinhVien) nguoi);
				
			}
		}
		return dsSV;
	}
	public static void save() throws Exception {
		ArrayList<SinhVien> list = SinhViendao.getSV();
		FileWriter out = new FileWriter("f2.txt");
		for (SinhVien nv: list)
			out.write(nv.toString() + "\n");
		out.close();
	}
}
