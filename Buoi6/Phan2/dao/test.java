package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bean.Nguoibean;
import bean.NhanVienbean;
import bean.SinhVienbean;

public class test {

	public static void main(String[] args) {
	ArrayList<Nguoibean> ds = new ArrayList<Nguoibean>();
		
		try {
			SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");	
			
			// Tao 2 nguoi
			String ngay1 = "10/12/2004";
			Nguoibean ng1 = new Nguoibean("Hung", true, date.parse(ngay1));
			String ngay2 = "05/02/2002";
			Nguoibean ng2 = new Nguoibean("Nga", false, date.parse(ngay2));
			
			// Tao 2 sinh vien
			String ngay5 = "01/06/2000";
			Nguoibean sv1 = new SinhVienbean("sv1", "Anh", false, date.parse(ngay5), "A", 6.5);
			String ngay6 = "05/05/1999";
			Nguoibean sv2 = new SinhVienbean("sv2", "Huy", true, date.parse(ngay6), "B", 9.0);
			
			// Tao 2 nhan vien
			String ngay3 = "17/04/1999";
			NhanVienbean nv1 = new NhanVienbean("nv1", "Tien", true, date.parse(ngay3), 3.5, "Tienbip@gmail.com", "0987654321");
			String ngay4 = "10/07/2008";
			NhanVienbean nv2 = new NhanVienbean("nv2", "Thu", false, date.parse(ngay4), 3.0, "Thudieu@gmail.com", "0123456789");
			
			ds.add(ng1);
			ds.add(ng2);
			ds.add(sv1);
			ds.add(sv2);
			ds.add(nv1);
			ds.add(nv2);
			
			System.out.println("Danh sach sinh vien: ");
			for (Nguoibean sv : ds)
				if (sv instanceof SinhVienbean)
					System.out.println(sv.toString());
			
			System.out.println("Danh sach nhan vien: ");
			for (Nguoibean nv : ds)
				if (nv instanceof NhanVienbean)
					System.out.println(nv.toString());
			
			System.out.println("Danh sach nguoi: ");
			for (Nguoibean ng : ds)
				if (!(ng instanceof SinhVienbean) && !(ng instanceof NhanVienbean))
					System.out.println(ng.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
