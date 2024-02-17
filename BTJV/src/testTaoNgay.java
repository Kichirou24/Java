import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class testTaoNgay {
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
	
	public void HienThi(int n) {
		for (int i = 1; i <= n; i++) {
			System.out.println(i + ":" + TaoNgay("01/01/1960", "01/01/2024") + ";");
		}
	}
	
	public static void main(String[] args) {
		testTaoNgay m = new testTaoNgay();
		String ngay1 = "01/02/1960";
		String ngay2 = "01/02/2000";
		System.out.println(m.TaoNgay(ngay1, ngay2));
		
		m.HienThi(200);
	}
}
