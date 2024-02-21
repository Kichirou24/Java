import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

public class BtArrayList {

	public ArrayList<String> DsHoTen = new ArrayList<String>();
	public ArrayList<Double> DsDTB = new ArrayList<Double>();
	
	public void TaoDanhSach() {
		try
		{
			FileReader f = new FileReader("sv.txt");
			BufferedReader r = new BufferedReader(f);
			
			while (true)
			{
				String st = r.readLine();
				if (st == "" || st == null) break;
				String[] ds = st.split("[;]");
				DsHoTen.add(ds[1]);
				DsDTB.add((double) Math.round(Double.parseDouble(ds[3])));
			}
			
			r.close();
		}catch (Exception e)
		{
			System.out.println("Loi o ham TaoDanhSach" + e.getMessage());
		}
	}

	public void XuatDanhSach()
	{
		int n = DsHoTen.size();
		for (int i = 0; i < n; i++)
		{
			System.out.println(DsHoTen.get(i) + ";" + DsDTB.get(i));
		}
	}
	
	public void Find(String ten)
	{
		int n = DsHoTen.size();
		for (int i = 0; i < n; i++)
		{
			if (DsHoTen.get(i).indexOf(ten) != -1)
			{
				System.out.println(DsHoTen.get(i));
			}
		}
	}
	
	public void Count()
	{
		Integer pass = 0;
		Integer fail = 0;
		
		Integer n = DsDTB.size();
		for (int i = 0; i < n; i++)
		{
			if (DsDTB.get(i) >= 5) pass++;
			else fail++;
		}
		System.out.println("Dau: " + pass + "; Rot: " + fail);
	}
	
	public void Average()
	{
		double sum = 0;
		Integer n = DsDTB.size();
		
		for (int i = 0; i < n; i++)
		{
			sum += DsDTB.get(i);
		}
		System.out.println("Trung binh DTB " + Math.round(sum / n * 10) / 10);
	}
}
