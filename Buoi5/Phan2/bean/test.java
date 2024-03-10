package bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class test {

	public static void main(String[] args) {
		try {
			SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

			String ngay1 = "10/12/2004";
			Nguoibean n1 = new Nguoibean("Hung", true, date.parse(ngay1));
			String ngay2 = "05/02/2002";
			Nguoibean n2 = new Nguoibean("Nga", false, date.parse(ngay2));
			String ngay3 = "17/04/1999";
			Nguoibean n3 = new Nguoibean("Tien", true, date.parse(ngay3));
			String ngay4 = "10/07/2008";
			Nguoibean n4 = new Nguoibean("Thu", false, date.parse(ngay4));
			
			// khai bao 1 mang de chua nguoi
			ArrayList<Nguoibean> ds = new ArrayList<Nguoibean>();
			ds.add(n1);
			ds.add(n2);
			ds.add(n3);
			ds.add(n4);
			// hien tat ca cac nguoi
			for (Nguoibean n : ds)
			{
				System.out.println(n.toString());
			}
			
			System.out.println("------------------");
			
			// xuat ra cac nguoi co tuoi >= 20	
			for (Nguoibean n : ds)
			{
				Integer tuoi = n.getTuoi();
				if (tuoi >= 20)
				{
					System.out.println(n.toString());
				}
			}
			
			System.out.println("------------------");
			// xuat ra cac nguoi co gioi tinh = false
			
			for (Nguoibean n : ds)
			{
				if (n.isGioitinh() == false)
				{
					System.out.println(n.toString());
				}
			}
			
			System.out.println("------------------");
			// in ra trung binh tuoi
			Double sum = 0.0;
			for (Nguoibean n : ds)
			{
				sum += n.getTuoi();
			}

			Double dtb = (sum/(ds.size()));
			System.out.println(dtb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}