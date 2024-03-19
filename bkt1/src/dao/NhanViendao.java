package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import bean.NhanVienbean;

public class NhanViendao {
	public ArrayList<NhanVienbean> ds = new ArrayList<NhanVienbean>();
	
	public ArrayList<NhanVienbean> get() throws Exception {
		try {
			FileReader f = new FileReader("ds.txt");
			BufferedReader r = new BufferedReader(f);
			
			while (true)
			{
				String st = r.readLine();
				
				if (st == null || st.equals(""))
					break;
				
				String[] sp = st.split("[,]");
				String lhd = sp[2];
				
				if (!isValidLHD(lhd) || sp.length != 4)
					saveError(st);
				else
				{
					ds.add(new NhanVienbean(sp[0], sp[1], sp[2], Integer.parseInt(sp[3])));
				}
			}
			r.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return ds;
	}
	
	public void Show() {
		System.out.println("Danh sach nhan vien: ");
		for(NhanVienbean nv : ds)
			System.out.println(nv.toString()); 
				
	}
	
	public void showHD()
	{
		try {
			for (NhanVienbean nv : ds)
				if (nv.getLoaiHopDong().equals("chinhthuc"))
					nv.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveValid(String str)
	{
		try {
			FileWriter f = new FileWriter("dshople.txt");
			PrintWriter w = new PrintWriter(f);
			for (NhanVienbean nv : ds)
				w.println(nv);
			w.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	public boolean isValidLHD(String lhd)
	{
		if (!lhd.equals("chinhthuc") || !lhd.equals("hopdong"))
			return false;
		return true;
	}
}
