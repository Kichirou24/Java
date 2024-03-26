package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Nguoibean {
	private String hoTen;
	private boolean gioiTinh;
	private Date ngaySinh;
	
	SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
	
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public Nguoibean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Nguoibean(String hoTen, boolean gioiTinh, Date ngaySinh) {
		super();
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
	}
	
	public int getTuoi() {
		String dt = date.format(ngaySinh);
		int year = Integer.parseInt(dt.split("[/]")[2]);
		Date d = new Date();
		int yearnow = Integer.parseInt(date.format(d).split("[/]")[2]);
		
		return yearnow - year;
	}

	@Override
	public String toString() {
		try {
			String ngay = date.format(ngaySinh);
			return hoTen + ";" + (gioiTinh == true ? "Nam" : "Nu") + ";" + ngay + ";" + getTuoi();			
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	
}