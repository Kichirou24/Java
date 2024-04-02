package view;

import java.util.Scanner;

import bean.NhanVienbean;
import bo.NhanVienbo;

public class NhanVienview {
	public static void main(String[] args)
	{
		try {
			NhanVienbo nvbo = new NhanVienbo();
			for (NhanVienbean nv : nvbo.getNV())
			{
				System.out.println(nv.toString());
			}
			
			nvbo.save("data.txt");
			System.out.println("Da luu vao CSDL");
			
			Scanner input = new Scanner(System.in);
			String manv1 = input.nextLine();
			nvbo.delete(manv1);
			System.out.println("Da xoa");
			String manv2 = input.nextLine();
			Double hsl = input.nextDouble();
			nvbo.update(manv2, hsl);
			System.out.println("Da cap nhat");
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
