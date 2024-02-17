import java.util.Scanner;

public class File {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		BtFile f = new BtFile();
		// Tao n sv
		f.TaoDanhSach(n);
		System.out.println("---------------");
		// Hien thi n sv
		f.Show(n);
		System.out.println("---------------");
		// Tim kiem ten sinh vien
		Scanner input2 = new Scanner(System.in);
		String ten = input2.nextLine();
		f.Find(ten);
		// Dem so sinh vien dau/rot
		System.out.println(f.Count());
		System.out.println("---------------");
		// Tinh trung binh dtb
		System.out.println(f.Average());
		input.close();
		input2.close();
	}
}
