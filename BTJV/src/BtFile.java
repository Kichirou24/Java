import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Random;

public class BtFile {
	public void TaoDanhSach(int n)
	{
		try {
			FileWriter f = new FileWriter("sv.txt");
			PrintWriter w = new PrintWriter(f);
			
			Random r = new Random();
			BtMang m = new BtMang();
			for (int i = 1; i <= n; i++)
			{
				double dtb = r.nextDouble()*10;
				w.println("Sv " + i + ";" + m.TaoHoTen() + ";" + m.TaoNgay("01/01/1960", "01/01/2000") + ";" + dtb);
			}
			w.close();
			System.out.println("Da tao xong\n");
		} catch(Exception e) {
			System.out.println("Loi o ham TaoDanhSach: " + e.getMessage());
		}
	}
	
	public void XuatDanhSach(int n)
	{
		try {
			FileReader f = new FileReader("sv.txt");
			BufferedReader r = new BufferedReader(f);
			
			while (true)
			{
				String st = r.readLine();
				if (st == "" || st == null) break;
				String[] ds = st.split("[;]");
				System.out.println(ds[0] + "\n" + ds[1] + "\n" + ds[2] + "\n\n");
			}
			r.close();
		}
		catch (Exception e)
		{
			System.out.println("Loi o ham XuatDanhSach: " + e.getMessage());
		}
	}
	
	public void Show(int n) {
		try {
			FileReader f = new FileReader("sv.txt");
			BufferedReader r = new BufferedReader(f);
			
			Random rd = new Random();
			while (true)
			{
				String st = r.readLine();
				if (st == "" || st == null) break;
				String[] ds = st.split("[;]");
				// ds[0] sv; ds[1] ho ten; ds[2] ngay sinh; ds[3] dtb
				Integer t = rd.nextInt(2);
				String gt = (t == 1 ? "Nam" : "Nu");
				double dtb = Double.parseDouble(ds[3]);
				String kq = ((dtb >= 5) ? "Dau" : "Rot");
				String xl = (dtb <= 10 && dtb >= 8) ? "Gioi" : 
		            (dtb >= 6.5) ? "Kha" : 
		            (dtb >= 5) ? "Trung Binh" : 
		            (dtb >= 3.1) ? "Yeu" : "Kem";

				System.out.println(ds[0] + ": " + ds[1] + "; " + ds[2] + "; " + gt + "; " + kq + "; " + xl + ";\n");
			}
			r.close();
		}
		catch (Exception e)
		{
			System.out.println("Loi o ham HienThi: " + e.getMessage());
		}
	}
	
	public double Average() {
		double sum = 0;
		Integer c = 0;
		try {
			FileReader f = new FileReader("sv.txt");
			BufferedReader r = new BufferedReader(f);
			
			while (true)
			{
				String st = r.readLine();
				if (st == "" || st == null) break;
				String[] ds = st.split("[;]");
				Double dtb = Double.parseDouble(ds[3]);
				sum += dtb;
				c++;
			}
			r.close();
		}
		catch (Exception e)
		{
			System.out.println("Loi o ham TrungBinh: " + e.getMessage());
		}
		return (double) Math.round(sum / c * 10) / 10;
	}
	
	public String Count() {
		Integer pass = 0;
		Integer fail = 0;
		try {
			FileReader f = new FileReader("sv.txt");
			BufferedReader r = new BufferedReader(f);
			
			while (true)
			{
				String st = r.readLine();
				if (st == "" || st == null) break;
				String[] ds = st.split("[;]");
				double dtb = Double.parseDouble(ds[3]);
				String kq = ((dtb >= 5) ? "Dau" : "Rot");
				if (kq == "Dau") pass++;
				else fail++;
			}
			r.close();
		}
		catch (Exception e)
		{
			System.out.println("Loi o ham Dem: " + e.getMessage());
		}
		return "Dau: " + pass + "; Rot: " + fail + ";";
	}
	
	public void Find(String ten)
	{
		try {
			FileReader f = new FileReader("sv.txt");
			BufferedReader r = new BufferedReader(f);
			
			while (true)
			{
				String st = r.readLine();
				if (st == "" || st == null) break;
				String[] ds = st.split("[;]");
				String hvt = ds[1];
				if (hvt.indexOf(ten) != -1)
				{
					System.out.println(hvt);
				}
				
			}
			r.close();
		}
		catch (Exception e)
		{
			System.out.println("Loi o ham TimKiem: " + e.getMessage());
		}
	}
	
	public void NoValid()
	{
		try {
			FileReader f = new FileReader("sv.txt");
			BufferedReader r = new BufferedReader(f);
			
			while (true)
			{
				String st = r.readLine();
				if (st == "" || st == null) break;
				String[] ds = st.split("[;]");
				String hvt = ds[1];
				System.out.println(hvt);
				
			}
			r.close();
		}
		catch (Exception e)
		{
			System.out.println("Loi o ham TimKiem: " + e.getMessage());
		}
	}
}
