import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LopHoc {
	public ArrayList<Object> ds1 = new ArrayList<Object>();
	public void TaoLop(String tf) {
		try {
			FileInputStream f = new FileInputStream(tf);
			InputStreamReader i = new InputStreamReader(f);
			BufferedReader r = new BufferedReader(i);
			while(true)
			{
				String st = r.readLine();
				if (st == null || st == "")
					break;
				String[] t = st.split("[|]");
				if (t.length == 4) // Khoa CNTT
				{
					SvCntt sv = new SvCntt();
					sv.setMaSv(t[0]);
					sv.setHoTen(t[1]);
					sv.setDm1(Double.parseDouble(t[2]));
					sv.setDm2(Double.parseDouble(t[3]));
					ds1.add(sv);
				}
				if (t.length == 5) // Khoa Toan
				{
					SvToan sv = new SvToan();
					sv.setMaSv(t[0]);
					sv.setHoTen(t[1]);
					sv.setDm1(Double.parseDouble(t[2]));
					sv.setDm2(Double.parseDouble(t[3]));
					sv.setDm3(Double.parseDouble(t[4]));
					ds1.add(sv);
				}
				if (t.length == 6) // Khoa Ly
				{
					SvLy sv = new SvLy();
					sv.setMaSv(t[0]);
					sv.setHoTen(t[1]);
					sv.setDm1(Double.parseDouble(t[2]));
					sv.setDm2(Double.parseDouble(t[3]));
					sv.setDm3(Double.parseDouble(t[4]));
					sv.setDm4(Double.parseDouble(t[5]));
					ds1.add(sv);
				}
			}
			r.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void HienThi() {
		System.out.println("Danh sach sv Khoa CNTT");
		for (Object sv:ds1)
		{
			if (sv instanceof SvCntt) {
				SvCntt sv1 = (SvCntt) sv;
				sv1.HienThi();
			}
		}
		System.out.println("Danh sach sv Khoa Toan");
		for (Object sv:ds1)
		{
			if (sv instanceof SvToan) {
				SvToan sv1 = (SvToan) sv;
				sv1.HienThi();
			}
		}
		System.out.println("Danh sach sv Khoa Ly");
		for (Object sv:ds1)
		{
			if (sv instanceof SvLy) {
				SvLy sv1 = (SvLy) sv;
				sv1.HienThi();
			}
		}
	}
	
	public void HienThiKhoa(String tenKhoa) {
		if (tenKhoa.toUpperCase().contains("CNTT"))
		{
			for (Object sv:ds1)
			{
				if (sv instanceof SvCntt) {
					SvCntt sv1 = (SvCntt) sv;
					sv1.HienThi();
				}
			}
		}
		else if (tenKhoa.toUpperCase().contains("TOAN"))
		{
			for (Object sv:ds1)
			{
				if (sv instanceof SvToan) {
					SvToan sv1 = (SvToan) sv;
					sv1.HienThi();
				}
			}
		}
		else if (tenKhoa.toUpperCase().contains("LY"))
		{
			for (Object sv:ds1)
			{
				if (sv instanceof SvLy) {
					SvLy sv1 = (SvLy) sv;
					sv1.HienThi();
				}
			}
		}
	}
	
	public void HienThiDiemTrungBinh()
	{
		// dtb khoa cntt
		System.out.println("Diem trung binh Khoa CNTT");
		Double sum = 0.0;
		int cnt = 0;
		for (Object sv:ds1)
		{
			if (sv instanceof SvCntt) {
				SvCntt sv1 = (SvCntt) sv;
				sum += sv1.getDtb();
				cnt++;
			}
		}
		Double dtb = (Double)(sum / cnt);
		System.out.println(dtb);
		
		// dtb khoa toan
		
		System.out.println("Diem trung binh Khoa Toan");
		sum = 0.0;
		cnt = 0;
		for (Object sv:ds1)
		{
			if (sv instanceof SvToan) {
				SvToan sv1 = (SvToan) sv;
				sum += sv1.getDtb();
				cnt++;
			}
		}
		dtb = (Double)(sum / cnt);
		System.out.println(dtb);
		
		// dtb khoa ly
		
		System.out.println("Diem trung binh Khoa Ly");
		sum = 0.0;
		cnt = 0;
		for (Object sv:ds1)
		{
			if (sv instanceof SvLy) {
				SvLy sv1 = (SvLy) sv;
				sum += sv1.getDtb();
				cnt++;
			}
		}
		dtb = (Double)(sum / cnt);
		System.out.println(dtb);
	}
	
	public void LuuThongTin(String tf)
	{
		
		try {
			FileWriter f = new FileWriter(tf);
			PrintWriter w = new PrintWriter(f);
			
			if (tf.equals("f1.txt")) {
				for (Object sv:ds1)
				{
					if (sv instanceof SvCntt) {
						SvCntt sv1 = (SvCntt) sv;
						String t = sv1.getMaSv() + "|" + sv1.getHoTen() + "|" + sv1.getDm1() + "|" + sv1.getDm2() + "|" + sv1.getDtb() + "|" + sv1.getKetQua();
						w.println(t);
					}
				}
			}
			else if (tf.equals("f2.txt"))
			{
				for (Object sv:ds1)
				{
					if (sv instanceof SvToan) {
						SvToan sv1 = (SvToan) sv;
						String t = sv1.getMaSv() + "|" + sv1.getHoTen() + "|" + sv1.getDm1() + "|" + sv1.getDm2() + "|" + sv1.getDm3() + "|" + sv1.getDtb() + "|" + sv1.getKetQua();
						w.println(t);
					}
				}
			}
			else if (tf.equals("f3.txt"))
			{
				for (Object sv:ds1)
				{
					if (sv instanceof SvLy) {
						SvLy sv1 = (SvLy) sv;
						String t = sv1.getMaSv() + "|" + sv1.getHoTen() + "|" + sv1.getDm1() + "|" + sv1.getDm2() + "|" + sv1.getDm3() + "|" + sv1.getDm4() + "|" + sv1.getDtb() + "|" + sv1.getKetQua();
						w.println(t);
					}
				}
			}
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void TimHienThi(String hoTen, String tenKhoa)
	{
		if (tenKhoa.toUpperCase().contains("CNTT"))
		{
			for (Object sv:ds1)
			{
				if (sv instanceof SvCntt) {
					SvCntt sv1 = (SvCntt) sv;
					String st = sv1.getHoTen();
					if (sv1.getHoTen().trim().toUpperCase().contains(hoTen.toUpperCase()))
					{
						System.out.println(sv1.getMaSv() + "|" + sv1.getHoTen() + "|" + sv1.getDm1() + "|" + sv1.getDm2() + "|" + sv1.getDtb() + "|" + sv1.getKetQua());
					}
				}
			}
		}
		else if (tenKhoa.toUpperCase().contains("TOAN"))
		{
			for (Object sv:ds1)
			{
				if (sv instanceof SvToan) {
					SvToan sv1 = (SvToan) sv;
					if (sv1.getHoTen().trim().toUpperCase().contains(hoTen.toUpperCase()))
					{
						System.out.println(sv1.getMaSv() + "|" + sv1.getHoTen() + "|" + sv1.getDm1() + "|" + sv1.getDm2() + "|" + sv1.getDm3() + "|" + sv1.getDtb() + "|" + sv1.getKetQua());
					}
				}
			}
		}
		else if (tenKhoa.toUpperCase().contains("LY"))
		{
			for (Object sv:ds1)
			{
				if (sv instanceof SvLy) {
					SvLy sv1 = (SvLy) sv;
					if (sv1.getHoTen().trim().toUpperCase().contains(hoTen.toUpperCase()))
					{
						System.out.println(sv1.getMaSv() + "|" + sv1.getHoTen() + "|" + sv1.getDm1() + "|" + sv1.getDm2() + "|" + sv1.getDm3() + "|" + sv1.getDm4() + "|" + sv1.getDtb() + "|" + sv1.getKetQua());
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		LopHoc lh = new LopHoc();
		lh.TaoLop("sv.txt");
		// Hien thi sinh vien theo khoa
		lh.HienThi();
		// Nhap 1 khoa, liet ke sinh vien cua khoa do
		Scanner i = new Scanner(System.in);
		String tenKhoa1 = i.nextLine();
		lh.HienThiKhoa(tenKhoa1);
		// Hien thi diem trung binh cua tung khoa
		lh.HienThiDiemTrungBinh();
		// Luu thong tin
		
		// Khoa Cntt
		lh.LuuThongTin("f1.txt");
		// Khoa Toan
		lh.LuuThongTin("f2.txt");
		// Khoa Ly
		lh.LuuThongTin("f3.txt");
		
		// Nhap hoc ten va 1 khoa, hien thi ra thong tin cua sv tim duoc
		String hoten = i.nextLine();
		String tenKhoa = i.nextLine();
		lh.TimHienThi(hoten, tenKhoa);	
	}
}
