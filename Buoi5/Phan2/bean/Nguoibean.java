package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Nguoibean {
	private String hoten;
	private boolean gioitinh;
	private Date ngaysinh;

	public Nguoibean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Nguoibean(String hoten, boolean gioitinh, Date ngaysinh) {
		super();
		this.hoten = hoten;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public boolean isGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	
	public int getTuoi() {
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		String ns = date.format(ngaysinh); // ns = "10/11/2004"
		// int namsinh = Integer.parseInt(ns.split("[/]")[2]);
		String namsinh = ns.substring(6); // cat chuoi lay nam
		
		Date d = new Date(); // lay ngay gio hien tai
		String nht = date.format(d);
		// int namhientai = Integer.parseInt(nht.split("[/]")[2]);
		String namhientai = nht.substring(6);
		Integer tuoi = Integer.parseInt(namhientai) - Integer.parseInt(namsinh);
		
		return tuoi;
	}

	@Override
	public String toString() {
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		String ngay = date.format(ngaysinh);
		return hoten + ";" + (gioitinh == true ? "Nam" : "Nu") + ";" + ngay + ";" + getTuoi();
	}
}
