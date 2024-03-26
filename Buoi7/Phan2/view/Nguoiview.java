package view;

import bean.Nguoibean;
import bo.Nguoibo;

public class Nguoiview {
	public static void main(String[] args) {
		try {
			Nguoibo nbo = new Nguoibo();
			System.out.println("Danh sach nguoi: ");
			
			for (Nguoibean nguoi : nbo.getDS())
				System.out.println(nguoi.toString());
			
			System.out.println("Danh sach nu: ");
			
			for (Nguoibean nguoi : nbo.getDSNu())
				System.out.println(nguoi.toString());
			
			System.out.println("Danh sach nguoi > 20 tuoi: ");
			
			for (Nguoibean nguoi : nbo.getDSTheoTuoi(20))
				System.out.println(nguoi.toString());
			
			System.out.println("TBC Tuoi tuoi: " + nbo.tbcTuoi());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}