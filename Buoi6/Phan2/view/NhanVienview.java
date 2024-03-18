package view;

import bean.NhanVienbean;
import bo.NhanVienbo;

public class NhanVienview {
	public static void main(String[] args) {
		try {
			NhanVienbo nvbo = new NhanVienbo();
			
			System.out.println("Danh sach nhan vien: ");
			for (NhanVienbean nv : nvbo.getDS())
					System.out.println(nv.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
