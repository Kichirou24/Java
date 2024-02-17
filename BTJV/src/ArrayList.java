import java.util.Scanner;

public class ArrayList {

	public static void main(String[] args) {
		BtArrayList a = new BtArrayList();
		a.TaoDanhSach();
		a.XuatDanhSach();
		Scanner input = new Scanner(System.in);
		String ten = input.nextLine();
		a.Find(ten);
		a.Average();
		a.Count();
		input.close();
	}

}
