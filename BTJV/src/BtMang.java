import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class BtMang {
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
	
	public void HienThi(int n) {
		Random r = new Random();
		for (int i = 1; i <= n; i++) {
			double dtb = r.nextDouble()*10;
			dtb = (double) Math.round(dtb * 10) / 10;
			System.out.println(TaoHoTen() + ";" + TaoNgay("01/01/1960", "01/01/2024") + ";" + dtb);
		}
	}
	
	public void HienThi2(int n)
	{
		Random r = new Random();
		for (int i = 1; i <= n; i++) {
			// random gioi tinh
			Integer t = r.nextInt(2);
			String gt = (t == 1 ? "Nam" : "Nu");
			// random dtb
			double dtb = r.nextDouble()*10;
			dtb = (double) Math.round(dtb * 10) / 10;
			// ket qua
			String kq = ((dtb >= 5) ? "Dau" : "Rot");
			// xep loai
			String xl = (dtb <= 10 && dtb >= 8) ? "Gioi" : 
	            (dtb >= 6.5) ? "Kha" : 
	            (dtb >= 5) ? "Trung Binh" : 
	            (dtb >= 3.1) ? "Yeu" : "Kem";
			System.out.println(TaoHoTen() + ";" + TaoNgay("01/01/1960", "01/01/2024") + ";" + gt + ";" + dtb + ";" + kq + ";" + xl);
		}
	}
}