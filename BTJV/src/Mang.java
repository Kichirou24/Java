import java.util.Scanner;

public class Mang {
	
	
	public static void main(String[] args) {
		BtMang m = new BtMang();
		
		// Hien thi 100 sinh vien
		m.HienThi(10);
		
		System.out.println("------------------------");
		
		// Hien thi ...
		m.HienThi2(10);
		System.out.println("------------------------");
		
		// Hien thi n sinh vien
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		m.HienThi(n);
		input.close();
	}

}
