package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bean.CaoDangbean;
import bean.DaiHocbean;
import bean.SinhVienbean;

public class SinhViendao {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	ArrayList<SinhVienbean> ds = new ArrayList<SinhVienbean>();
	public ArrayList<SinhVienbean> getDS() throws Exception {
		try {
			FileReader f = new FileReader("ds.txt");
			BufferedReader r = new BufferedReader(f);
			
			while (true)
			{
				String st = r.readLine();
				if (st == "" || st == null)
					break;
				
				String[] sp = st.trim().split("[,]");
				
				if (sp.length == 6)
				{
					ds.add(new DaiHocbean(sp[0], sp[1], sdf.parse(sp[2]), Double.parseDouble(sp[3]), Boolean.parseBoolean(sp[4]), Boolean.parseBoolean(sp[5])));
				}
				else if (sp.length == 5)
				{
					ds.add(new CaoDangbean(sp[0], sp[1], sdf.parse(sp[2]), Double.parseDouble(sp[3]), Boolean.parseBoolean(sp[4])));
				}
				else
				{
					saveError(st);
				}
			}
			r.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public void saveError(String str)
	{
		try {
			FileWriter f = new FileWriter("loi.txt");
			PrintWriter w = new PrintWriter(f);
			w.println(str);
			w.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
