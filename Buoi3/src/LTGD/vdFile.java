package LTGD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class vdFile {

	public static void main(String[] args) {
		ArrayList<String> ds = new ArrayList<String>();
		try {
			FileReader f = new FileReader("hang.txt");
			BufferedReader r = new BufferedReader(f);
			while (true)
			{
				String st = r.readLine();
				if (st == null || st == "") break;
				ds.add(st);
				//System.out.println(st);
				//String[] ds = st.split("[;]"); tach chuoi
				//System.out.println(ds[0] + " " + ds[1] + " " + ds[2]);
			}
			r.close();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Du lieu tu mang ds");
		for (String s:ds)
			System.out.println(s);
	}

}
