//
import java.util.Scanner;

public class vd5 {

	public static void main(String[] args) {
		String[] ds = {
				"Sv1;Nguyen Van Nam;K46;CNTT;dhkh", 
				"Sv2;Do Chu;K46;CNTT;dhkh", 
				"Sv3;Pham Hung;K47;CNTT;dhkh", 
				"Sv4;Le Lai;K47;CNTT;dhkh",
				"Sv5;Tran Thi Tuoi;K45;CNTT;dhkh",
				"Sv6;Ho Binh;K45;CNTT;dhkh"
				};
		
		// Nhap 1 khoa in ra ds sv va so luong SV cua khoa do
		
		Scanner nhap = new Scanner(System.in);
		System.out.print("Nhap khoa: ");
		String key = nhap.nextLine();
		
		int count = 0;
		for(String tt:ds)
		{
			String[] sv = tt.split("[;]");
			if (sv[2].toLowerCase().equals(key.toLowerCase())) {
				System.out.println(tt);
				count++;
			}
		}
		System.out.println("So luong sinh vien cua khoa " + key + " la: " + count);
		
		nhap.close();
	}

}
