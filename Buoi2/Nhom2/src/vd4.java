import java.util.Scanner;

public class vd4 {
	public static void main(String[] args) {
		String[] ds = {"Le Van Teo", "Le Van Nam", "Nguyen thi Nam", "Tran Tien"};
		
		// Nhap vao 1 ho ten -> in ra ho ten tim duoc (tim tuong doi)
		Scanner nhap = new Scanner(System.in);
		System.out.println("Nhap: ");
		String key = nhap.nextLine();
		
		for(String ht:ds) {
			if (ht.trim().toLowerCase().contains(key.trim().toLowerCase()) == true)
				System.out.println(ht);
		}
	}
}
