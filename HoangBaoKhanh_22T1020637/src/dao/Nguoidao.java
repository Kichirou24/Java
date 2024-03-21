package dao;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import bean.Nguoi;
import bean.NhanVien;
import bean.SinhVien;

public class Nguoidao {
	public static ArrayList<Nguoi> getDanhSach() throws Exception {
		ArrayList<Nguoi> list = new ArrayList<Nguoi>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(new FileReader("ds.txt"));
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line == null || line.equals("")) break;
			String[] tokens = line.split("[;]");
			if(tokens.length == 4) {
				String maNV = tokens[0];
				String hoTen = tokens[1];
				Date ngaySinh = sdf.parse(tokens[2]);
				Double heSoLuong = Double.parseDouble(tokens[3]);
//				public NhanVien(String hoTen, Date ngaySinh, String maNV, Double heSoLuong) {
				list.add(new NhanVien(hoTen, ngaySinh, maNV, heSoLuong));
			} else if(tokens.length == 5) {
				String maSV = tokens[0];
				String hoten = tokens[1];
				Date ngaySinh = sdf.parse(tokens[2]);
				Double diem1 = Double.parseDouble(tokens[3]);
				Double diem2 = Double.parseDouble(tokens[4]);
				list.add(new SinhVien(hoten, ngaySinh, maSV, diem1, diem2));
			}
		}
		return list;
	}
}
