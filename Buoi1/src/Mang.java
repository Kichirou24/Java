import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Mang {
	public String TaoNgay(String ngay1, String ngay2) {
		try {
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			Date n1 = f.parse(ngay1);
			Date n2 = f.parse(ngay2);
			
			Random r = new Random();
			while (true) {
				Long t = r.nextLong();
				if (t >= n1.getTime() && t <= n2.getTime()) {
					Date n = new Date(t);
					return f.format(n);
				}
			}
		} catch (Exception tt) {
			System.out.println("Loi: " + tt.getMessage());
			return null;
		}
	}
	
	public String TaoHoTen() {
		String[] ho = {"Tran", "Le", "Nguyen"};
		String[] chulot = {"Thanh", "Hoang", "Trung", "Van", "My"};
		String[] ten = {"Hung", "Nga", "Tien", "Tam", "Ton", "Giang", "Sy"};
		
		Random r = new Random();
		String h = ho[r.nextInt(ho.length)];
		String cl = chulot[r.nextInt(chulot.length)];
		String t = ten[r.nextInt(ten.length)];
		return h + " " + cl + " " + t;
	}
	
	public void HienThiThongTin(int n) {
		Random r = new Random();
		System.out.println("Thong tin " + n + " sinh vien: ");
		for (int i = 1; i <= n; i++) {
			double dtb = (double)Math.floor(r.nextDouble()*1000) / 100;
			String hoten = TaoHoTen();
			String ngaysinh = TaoNgay("01/01/1990", "01/01/2005");
			String gioitinh = (r.nextInt(2) == 1) ? "Nam" : "Nu";
			System.out.println(i + ". " + hoten + "; " + ngaysinh + "; " + gioitinh + "; " + dtb);
		}
	}
	
	public void HienThiKetQua(int n) {
		Random r = new Random();
		System.out.println("Ket Qua: ");
		for (int i = 1; i <= n; i++) {
			double dtb = (double)Math.floor(r.nextDouble()*1000) / 100;
			String hoten = TaoHoTen();
			String ngaysinh = TaoNgay("01/01/1990", "01/01/2005");
			String gioitinh = (r.nextInt(2) == 1) ? "Nam" : "Nu";
			String kq = (dtb >= 5) ? "Dau" : "Rot";
			System.out.println(i + ". " + hoten + "; " + ngaysinh + "; " + gioitinh + "; " + dtb + "; " + kq);
		}
	}
	
	public static void main(String[] args) {
		Mang m = new Mang();
		// Hien thi thong tin 10 sinh vien
		m.HienThiThongTin(10);
		// Hien thi ket qua 10 sinh vien
		m.HienThiKetQua(10);
		// Hien thi thong tin n sinh vien 
		Scanner nhap = new Scanner(System.in);
		System.out.print("Nhap so sinh vien: ");
		Integer n = nhap.nextInt();
		m.HienThiThongTin(n);		
	}
}
