import java.util.Scanner;

public class vd3 {
	public static void main(String[] args) {
		Scanner nhap = new Scanner(System.in);
		System.out.print("Nhap ho ten: ");
		String ht = nhap.nextLine();
		
		// In ra ho, chulot, ten
		
		Integer i = ht.indexOf(" "); // vi tri khoang trang dau tien trai qua
		Integer j = ht.lastIndexOf(" "); // vi tri khoang trang dau tien phai qua
		
		if (i == -1)
		{
			System.out.println(ht);
			return;
		}
		
		System.out.println("Ho: " + ht.substring(0, i)); // ht[0, i - 1]
		
		if (i != j) {	
			System.out.println("Chu lot: " + ht.substring(i + 1, j)); // ht[i + 1, j - 1]
			return;
		}
		
		System.out.println("Ten: " + ht.substring(j + 1)); // ht[j + 1, ...]
	}
}