package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bean.Nguoibean;
import bean.NhanVienbean;
import bean.SinhVienbean;

public class Nguoidao {
	public ArrayList<Nguoibean> ds = new ArrayList<Nguoibean>();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public ArrayList<Nguoibean> get() throws Exception {
		try {
			int cnt = 1;
			FileReader f = new FileReader("ds.txt");
			BufferedReader r = new BufferedReader(f);
			
			while (true) {
				String st = r.readLine();
				
				if (st == null || st == "")
					break;
				
				String[] sp = st.split("[;]");
				String time = sp[2];
				
				if (!isValidDate(time))
					continue;
				
				if (sp.length == 3)
					// Nguoi
					ds.add(new Nguoibean(sp[0], Boolean.parseBoolean(sp[1]), sdf.parse(sp[2])));
				else if (sp.length == 6)
				{
					// Sinh vien
					if (!isValidId(sp[0]))
						continue;
					ds.add(new SinhVienbean(sp[0], sp[1], Boolean.parseBoolean(sp[2]), sdf.parse(sp[3]), sp[3], Double.parseDouble(sp[5])));
				}
				else if (sp.length == 7)
				{
					// Nhan vien
					// Check isValid
					String email = sp[5];
					String phone = sp[6];
					if (!isValidEmail(email) || !isValidPhone(phone) || !isValidId(sp[0]))
						continue;
					ds.add(new NhanVienbean(sp[0], sp[1], Boolean.parseBoolean(sp[2]), sdf.parse(sp[3]), Double.parseDouble(sp[4]), sp[5], sp[6]));
				}
				else
					SaveError("Error line: " + cnt);
				cnt += 1;
			}
			r.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public boolean isValidDate(String date) {
		Pattern pt = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{4}");
		Matcher mc = pt.matcher(date);
		
		if (mc.find() == false)
			return false;
		
		try {
			sdf.setLenient(false);
			sdf.parse(date);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isValidPhone(String phone) {
		Pattern pt = Pattern.compile("(0|\\+84)\\d{9,10}");
		Matcher mc = pt.matcher(phone);
		return mc.find();
	}
	
	public boolean isValidEmail(String email) {
		Pattern pt = Pattern.compile("(\\w+)@(\\w+.)(\\w+.){2,}");
		Matcher mc = pt.matcher(email);
		return mc.find();
	}
	
	public boolean isValidId(String id) {
		Pattern pt = Pattern.compile("^[a-zA-Z]");
		Matcher mc = pt.matcher(id);
		return mc.find();
	}
	
	public String countPassFail() {
		int pass = 0, fail = 0;
		for (Nguoibean ng : ds)
		{
			if (ng instanceof SinhVienbean) {
				if (((SinhVienbean) ng).getdTB() <= 5)
					pass += 1;
				else
					fail += 1;
			}
		}
		return "Sinh vien dau: " + pass + " .Sinh vien rot: " + fail;
	}
	
	public void Show() {
		System.out.println("Danh sach sinh vien: ");
		for(Nguoibean sv : ds)
			if (sv instanceof SinhVienbean) 
				System.out.println(sv.toString());

		for(Nguoibean nv : ds)
			if (nv instanceof NhanVienbean)
				System.out.println(nv.toString());
	}
	
	public ArrayList<Nguoibean> searchNV(String namenv){
		ArrayList<Nguoibean> temp = new ArrayList<Nguoibean>();
		for (Nguoibean ng : ds)
			if (ng instanceof NhanVienbean && ng.getHoTen().toLowerCase().trim().contains(namenv.toLowerCase().trim()))
				temp.add(ng);
		return temp;
	}
	
	public void SaveError(String str) {
		try {
			FileWriter f = new FileWriter("loi.txt", true);
			PrintWriter w = new PrintWriter(f);
			w.println(str);
			w.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}