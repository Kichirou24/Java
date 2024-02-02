
public class vd1 {
	public static void main(String[] args) {
		try {
			int a = 5;
			int b = 0;
			double s = a/b;
			System.out.println(s);
		} catch (Exception e) {
			System.out.println("Loi:" + e.getMessage());
			e.printStackTrace();
		}

		
		
	}
}