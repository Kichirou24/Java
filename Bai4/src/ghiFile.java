import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class ghiFile {
	public String TaoNgay(String ngay1, String ngay2) {
		try {
			SimpleDateFormat f = new SimpleDateFormat("HH:mm dd/MM/yyyy");
			Date n1 = f.parse(ngay1);
			Date n2 = f.parse(ngay2);
			
			Random r = new Random();
			while (true) {
				Long t = r.nextLong();
				if (t >= n1.getTime() && t <= n2.getTime()) {
					Date n = new Date(t);
					return f.format(n);
				}
			}
		} catch (Exception tt) {
			System.out.println("Loi: " + tt.getMessage());
			return null;
		}
	}
	
	public void ghi1(int n)
	{
		try {
			FileOutputStream f = new FileOutputStream("input1.txt");
			OutputStreamWriter o = new OutputStreamWriter(f);
			PrintWriter w = new PrintWriter(o);
			
			Random r = new Random();
			for (int i = 1; i <= n; i++)
			{
				// random loai xe
				int[] lx = {0, 2, 4, 0, 2, 4, 0, 2, 4};
				int id = r.nextInt(8);
				int loaiXe = lx[id];
				// random bien so         bs = B1(int) + B2(alpha) + B3(" ", 1, ..9) +  "-" + B4( >= 10000 -> 100.00         < 10000 -> 9999)
				String bienSo = "";
				if (loaiXe != 0) {
					int B1t = r.nextInt(99);
					String B1 = B1t + "";
					char B2 = (char)('A' + r.nextInt(26));
					String B3;
					int d = r.nextInt(9);
					if (d == 0) B3 = "";
					else B3 = d + "";
					int B4t = r.nextInt(99999);
					String B4 = B4t + "";
					if (B4t >= 10000)
					{
						String B41 = B4.substring(0, 3);
						String B42 = B4.substring(3);
						B4 = B41 + "." + B42;
					}
					bienSo = B1 + B2 + B3 + "-" + B4;
				}
				else
				{
					bienSo = "Not Available";
				}
				// so ve xe
				String soVeXe;
				if (loaiXe == 0)
				{
					int svx = r.nextInt(9999);
					soVeXe = svx + "";
				}
				else
				{
					soVeXe = "Not Available";
				}
				// Thoi gian xe vao
				String thoiGianVao = TaoNgay("00:00 01/01/2000", "23:59 31/12/2024");
				// Tinh trang xe
				String[] tt = {"Binh thuong", "Mat kinh chieu hau trai", "Mat kinh chieu hau phai", "Lung lop xe", "Be kinh"};
				id = r.nextInt(4);
				String tinhTrang;
				if (loaiXe != 0)
					tinhTrang = tt[id];
				else 
					tinhTrang = "Not Available";
				// ghi vao file
				w.println(loaiXe + ";" + bienSo + ";" + soVeXe + ";" + thoiGianVao + ";" + tinhTrang);
				
			}
			w.close();
			System.out.println("Da tao xong ghi1\n");
		} catch(Exception e) {
			System.out.println("Loi o ham ghi input1: " + e.getMessage());
		}
	}
	
	public String taoThoiGianRa(String thoiGianVao)
	{
		try {
			SimpleDateFormat date = new SimpleDateFormat("HH:mm dd/MM/yyyy");
			Date timein = date.parse(thoiGianVao);
			Random r = new Random();
			while (true)
			{
				int t = r.nextInt(100000000);
				Long tt = t + timein.getTime();
				Date timeout = new Date(tt);
				return date.format(timeout);
			}
		} catch (Exception e)
		{
			System.out.println("Loi taoThoiGianRa: " + e.getMessage());
			return null;
		}
	}
	
	public void ghi2(int n)
	{
		try {
			
			FileOutputStream f = new FileOutputStream("input2.txt");
			OutputStreamWriter o = new OutputStreamWriter(f);
			PrintWriter w = new PrintWriter(o);
			try {
				FileInputStream fo = new FileInputStream("input1.txt");
				InputStreamReader i = new InputStreamReader(fo);
				BufferedReader r = new BufferedReader(i);
				
				Random rd = new Random();
				
				while (true)
				{
					String st = r.readLine();
					if (st == "" || st == null) break;
					String[] ds = st.split("[;]");
					// loaiXe + bienSo + soVeXe + thoiGianVao + tinhTrang
					String loaiXe = ds[0];
					String bienSo = ds[1];
					String soVeXe = ds[2];
					// thoi gian ra
					String thoiGianVao = ds[3];
					String thoiGianRa = taoThoiGianRa(thoiGianVao);
					// tinh trang xe sau khi ra
					String[] tt = {"Bi hong kinh chieu hau", "Bi tray xuot ben phai", "Bi tray xuot ben trai", "Bi tray xuot phia sau", "Bi tray xuot phia sau"};
					int tid = rd.nextInt(10);
					String tinhTrang;
					if (tid == 5)
					{
						int id = rd.nextInt(4);
						tinhTrang = tt[id];
					}
					else
					{
						tinhTrang = ds[4];
					}
					w.println(loaiXe + ";" + bienSo + ";" + soVeXe + ";" + thoiGianRa + ";" + tinhTrang);
				}
				System.out.println("Da tao xong ghi2\n");
				r.close();
			}
			catch (Exception e)
			{
				System.out.println("Loi o ghi input2: " + e.getMessage());
			}
			w.close();
		} catch (Exception e)
		{
			System.out.println("Loi doc input1: " + e.getMessage());
		}
	}
	
	public void tinhTienGuiXe()
	{
		try {
			FileOutputStream f = new FileOutputStream("output.txt");
			OutputStreamWriter o = new OutputStreamWriter(f);
			PrintWriter w = new PrintWriter(o);
			
			try {
				FileInputStream f1 = new FileInputStream("input1.txt");
				InputStreamReader i1 = new InputStreamReader(f1);
				BufferedReader r1 = new BufferedReader(i1);
				
				FileInputStream f2 = new FileInputStream("input2.txt");
				InputStreamReader i2 = new InputStreamReader(f2);
				BufferedReader r2 = new BufferedReader(i2);
				String[] ds1;
				String[] ds2;
				while (true)
				{
					SimpleDateFormat date = new SimpleDateFormat("HH:mm dd/MM/yyyy");
					String st1 = r1.readLine();
					if (st1 == "" || st1 == null) break;
					ds1 = st1.split("[;]");
					
					String st2 = r2.readLine();
					if (st2 == "" || st2 == null) break;
					ds2 = st2.split("[;]");
					
					// loai xe
					String loaiXe = ds1[0];
					int loaiXei = Integer.parseInt(loaiXe);
					// bien so 
					String bienSo = ds1[1];
					// so ve xe
					String soVeXe = ds1[2];
					// thoi gian vao
					String thoiGianVao = ds1[3];
					Date timein = date.parse(thoiGianVao);
					// thoi gian ra
					String thoiGianRa = ds2[3];
					Date timeout = date.parse(thoiGianRa);
					// tinh trang vao
					String tinhTrangVao = ds1[4];
					// tinh trang ra
					String tinhTrangRa = ds2[4];
					// tinh tien
					double timeinout = timeout.getTime() - timein.getTime();
					double mo;
					boolean check = tinhTrangVao.contains(tinhTrangRa);
					if (check == false)
					{
						w.println(loaiXe + ";" + bienSo + ";" + soVeXe + ";" + thoiGianVao + ";" + thoiGianRa + "; Chua xac dinh - Dang xu ly boi thuong");
						continue;
					}
					else if (loaiXei == 0)
					{
						timeinout = Math.ceil(timeinout / (24 * 60 * 60 * 1000));
						mo = timeinout * 1000;
						String t = mo + "";
						String money = t.substring(0, t.length() - 2);
						w.println(loaiXe + ";" + bienSo + ";" + soVeXe + ";" + thoiGianVao + ";" + thoiGianRa + ";"+ money);
					}
					else if (loaiXei == 2)
					{
						timeinout = Math.ceil(timeinout / (24 * 60 * 60 * 1000));
						mo = timeinout * 3000;
						String t = mo + "";
						String money = t.substring(0, t.length() - 2);
						w.println(loaiXe + ";" + bienSo + ";" + soVeXe + ";" + thoiGianVao + ";" + thoiGianRa + ";"+ money);
					}
					else if (loaiXei == 4)
					{
						timeinout = Math.ceil(timeinout / (60 * 60 * 1000 / 2));
						mo = timeinout * 5000;
						String t = mo + "";
						String money = t.substring(0, t.length() - 2);
						w.println(loaiXe + ";" + bienSo + ";" + soVeXe + ";" + thoiGianVao + ";" + thoiGianRa + ";"+ money);
					}
				}
				r1.close();
				r2.close();
				System.out.println("Da tinh xong");
			} catch (Exception e)
			{
				System.out.println("Loi ham tinh tien: " + e.getMessage());
			}
			w.close();
		} catch(Exception e)
		{
			System.out.println("Loi ham ghi ket qua tinh tien: " + e.getMessage());
		}
	}
	
	public static void main(String[] args)
	{
		ghiFile m = new ghiFile();
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		m.ghi1(n);
		m.ghi2(n);
		m.tinhTienGuiXe();
		input.close();
	}
}
