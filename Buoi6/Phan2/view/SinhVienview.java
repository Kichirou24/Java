package view;

import bean.SinhVienbean;
import bo.SinhVienbo;

public class SinhVienview {
	public static void main(String[] args) {
		
		try {
			SinhVienbo svbo = new SinhVienbo();
			
			System.out.println("Danh sach sinh vien: ");
			for (SinhVienbean sv : svbo.getDS())
				System.out.println(sv.toString());
			
			System.out.println("Danh sach lop K46: ");
			for (SinhVienbean sv : svbo.getDSTheoLop("K46"))
				System.out.println(sv.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}