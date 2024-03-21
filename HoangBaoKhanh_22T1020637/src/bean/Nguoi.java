package bean;

import java.util.Date;

public class Nguoi {
	private String hoTen;
	private Date ngaySinh;
	public Nguoi(String hoTen, Date ngaySinh) {
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
	}
	public Nguoi() {
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
}
